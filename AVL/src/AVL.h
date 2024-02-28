// This class defines an AVL tree (self balancing tree)
// Michael Rizig
// 2/27/24

#include <iostream>
using namespace std;

class AVL{
    class Node{
    public:
        Node* left;
        Node* right;
        int data;
        int balanceFactor;
        Node(int data){
            left=nullptr;
            right=nullptr;
            this->data=data;
            int balanceFactor=0;
        }

    };
    public:
    Node* root;
    int treeArray[15]{-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999};
    AVL(){
    this->root= nullptr;
    }
    void insert(int data, Node* &n){
        Node* current = n;
        if(n== nullptr){
            n=new Node(data);
        }
        else{
            if(n->data>data){
                insert(data,n->left);
            }
            else if(n->data<data){
                insert(data,n->right);
            }
        }
    }
    bool search(int data, Node* &n){
        if(n!= nullptr){
            if(n->data == data){
               return true;
            }
            else {
                return search(data, n->left) || search(data, n->right);
            }
        }
        else return false;

    }
    void updateBalanceFactors(Node* &n){
        if(n!=nullptr){
            n->balanceFactor = leftCount(n) - rightCount(n);
            updateBalanceFactors(n->left);
            updateBalanceFactors(n->right);
        }

    }
    int leftCount(Node* &n){
        
        if(n==nullptr){
            return 0;
        }
        else if(n->left!=0){
            return 1 + leftCount(n->left);
        }
        return 1;
    }
    int rightCount(Node* &n){
         if(n==nullptr){
            return 0;
        }
        else if(n->right!=0){
            return 1 + leftCount(n->right);
        }
        return 1;
    }
    void remove(int data, Node* &n, Node* &prev){

        for(int i =0;i<15;i++){
            if(treeArray[i]==data){
                treeArray[i]=-999;
            }
        }

        if(n != nullptr){
            if(n->data == data){
                if(n->left!= nullptr && n->right!=nullptr){
                    if(n->data == root->data){
                        Node* temp = root->left;
                        root=root->right;
                        recursiveReadd(temp);
                    }
                    else if(prev->left!= nullptr&&prev->left->data == n->data){
                        Node* temp = n->right;
                        prev->left= n->left;
                        recursiveReadd(temp);
                    }
                    else{
                        Node* temp = n->left;
                        prev->right= n->right;
                        recursiveReadd(temp);
                    }
                }
                else if(n->left== nullptr && n->right!= nullptr){
                    if(n->data == root->data){
                        root=root->right;
                    }
                    else if(prev->left!=nullptr&&prev->left->data == n->data){
                        prev->left= n->right;
                    }
                    else{
                        prev->right= n->right;
                    }
                }
                else if(n->left!= nullptr && n->right== nullptr){
                    if(n->data == root->data){
                        root=root->left;
                    }
                    else if(prev->left!=nullptr&&prev->left->data == n->data){
                        prev->left= n->left;
                    }
                    else{
                        prev->right= n->left;
                    }
                }
                else{
                    if(n->data == root->data){
                        root= nullptr;
                    }
                    else if(prev->left!=nullptr&&prev->left->data == n->data){
                        prev->left= nullptr;
                    }
                    else{
                        prev->right= nullptr;
                    }
                }
            }
            else {
                remove(data, n->left, n);
                remove(data, n->right, n);
            }
        }
    }
    void printBalanceFactor(){
        updateBalanceFactors(root);
        string s="";
        BalanceFactors(root, s);

        cout<<s;
    }
    void printTree(){
        string s="";
        printTreeP(root, s);
        if(s[s.length()-1] == 'c')
        {
            s= s.substr(0,s.length()-1);
        }

        cout<<s;
    }
    bool isEmpty(){
       if (root==nullptr){
            return true;
        }
       return false;
    }
    int treeSize(Node* &n){
        if(n!= nullptr){
            return 1 + treeSize(n->left) + treeSize((n->right));
        }
        return 0;
    }
    string printPath(int data, Node * &n){
        string s="ROOT";
         path(data,n,s);
         return s;
    }
    void treeVisual(){
        clearTreeArray();
        treeToArray(0,root);
        string treeArra[7];
        for(int i=0;i<7;i++){
            if(treeArray[i]!=-999){
                treeArra[i] = to_string(treeArray[i]);
            }
            else{
                treeArra[i] ="-";
            }
        }
        string s = "          ["+ treeArra[0]+"]          \n"
                   "       ["+ treeArra[1]+"]   ["+ treeArra[2]+"]    \n"
                     "    ["+ treeArra[3]+"] ["+ treeArra[4]+"] ["+ treeArra[5]+"] ["+
               treeArra[6]+"]";
        cout<<"\n"<<s<<endl;

    };
    void printArrayForm(){
        cout<<"\n Array form: [";
        for (int i : treeArray) {
            if(i!=-999)
            {
                cout << i << ", ";
            }
            else cout<<"-, ";
        }
        cout <<"\b\b"<<"]"<< endl;
    }
private:
    void BalanceFactors(Node* &n, string &s){
         Node* current = n;
        if(current!= nullptr){
            printTreeP(current->left,s);
            s.append(to_string(n->balanceFactor) + ", ");
            printTreeP(current->right,s);

        }
    }
    void printTreeP(Node * &n, string &s){

        Node* current = n;
        if(current!= nullptr){
            printTreeP(current->left,s);
            s.append(to_string(n->data) + ", ");
            printTreeP(current->right,s);

        }


    }
    void clearTreeArray(){
        for(int i=0;i<14;i++){
            treeArray[i] = -999;
        }
    }
    void treeToArray(int counter, Node* &n){

        if(n!= nullptr && counter<14) {
            treeArray[counter] = n->data;
            treeToArray(2*counter+1,n->left);
            treeToArray(2*counter+2,n->right);
        }
    }


    void recursiveReadd(Node* &n){

        insert(n->data, root);
        if(n->left!= nullptr && n->right!= nullptr){
            recursiveReadd(n->left);
            recursiveReadd(n->right);
        }
        else if(n->left!= nullptr && n->right== nullptr){
            recursiveReadd(n->left);
        }
        else if(n->right!= nullptr && n->left== nullptr){
            recursiveReadd(n->right);
        }
    }
    string path(int data, Node* &n , string &s)
    {
        if(n->data == data){
            s.append(" -> "+to_string(n->data) );
            return s;
        }
        else if(n->data > data && n->left!= nullptr){
            s.append(" -> " + std::to_string(n->data));
            return path(data,n->left, s);
        }
        else if (n->right!= nullptr){
            s.append(" -> " + std::to_string(n->data));
            return path(data, n->right,s);
        }
        return "";
    }
};