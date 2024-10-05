#include <iostream>
using namespace std;
class LinkedList{
    class Node{
        public:
            int data;
            Node* left;
            Node* right;
            Node* parent;
            Node(int data, Node* parent){
                this->data = data;
                this->parent = parent;
                this->right = nullptr;
                this->left = nullptr;
                }
    };

public:
Node* root;

bool insert(int data){
    if (root==nullptr){
        root = new Node(data,nullptr);
        cout<<endl<<"Root is null! Created Root node and inserted data: <" << data << ">" << endl;
        print_inorder();
        return true;
    }
    Node* current = root;
    Node* prev;
    while(current!=nullptr){
        if(current->data > data){
            prev = current;
            current = current->left;
        }
        else if (current->data <data){
            prev = current;
            current = current->right;
        }
        else if(current->data == data){
            cout<<"Node " << data << " already inserted into the tree! Aborting."<<endl;
            print_inorder();
            return false;
        }
    }
    current =new  Node(data,prev);
    if(prev !=nullptr){
        if (prev->data < data){
            prev->right = current;
        }
        else{
            prev->left = current;
        }
    }
    cout<<"Inserted node <" <<data << "> successfully. Current tree (inorder): "<<endl;
    print_inorder();
    return true;
}
bool print_inorder(){
    if(root == nullptr){
        cout<<"Tree is empty!"<<endl;
        return false;
    }
    cout<<"root";
    inorder_traversal(root);
    cout<<" -> END"<<endl;
    balance();
    cout<<endl;
    return true;
    
}
private:
/// @brief recursively traverse tree in in order (LVR)
/// @param root : root node to begin traversal
void inorder_traversal(Node* root){
    //base case:
    if(root == nullptr){
        return;
    }
    inorder_traversal(root->left);
    cout<<" -> " << root->data;;
    inorder_traversal(root->right);
    return;
}

/// @brief balance the AVL tree
void balance(){
    int current_balance = get_balance_factor(root);
    if(current_balance <= 1 && current_balance >=-1 ){
        cout<<"Tree is balanced. Balance factor: " << current_balance<<endl;
        return;
    }
    cout<<"Tree is not balanced. Balance factor: "<<current_balance<<endl;

    

}

/// @brief Returns balance factor of passed in node (for balancing tree)
/// @param node : Node in avl
/// @return int representation of balance factor (left subtree height - right subtree height)
int get_balance_factor(Node* node){
    return height(node->left) - height(node->right);
}
/// @brief finds and returns the unbalanced node in the avl
/// @return 
Node* find_unbalanced_node(){
    // TODO:
}

/// @brief returns height of a given node
/// @return int height of longest subtree of node
int height(Node* node){
   return height_helper(node);
}

/// @brief recursive function that returns the height of tallest subtree 
/// @param node : node to determine hight ofs
/// @return int representing height of subtree
int height_helper(Node* node){
    if(node == nullptr){
        return 0;
    }
    return 1+ max( height_helper(node->left), height_helper(node->right));
}

};

