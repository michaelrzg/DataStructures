// AVL (self balancing binary tree) inplementation in c++
// Michael Rizig

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
int current_balance;
/// @brief insert a node into the treeS
/// @param data value of node to be inserted into tree
/// @return if insertion is succesful, returns true. else returns false
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
    cout<<"Inserted node <" <<data << "> successfully. Parent node: " << current->parent->data<< ". Current tree (inorder): "<<endl;
    balance();
    print_inorder();
    return true;
}
/// @brief print the tree in order (lVR)
/// @return false if tree is empty, else true
bool print_inorder(){
    if(root == nullptr){
        cout<<"Tree is empty!"<<endl;
        return false;
    }
    cout<<"Inorder: $";
    inorder_traversal(root);
    cout<<" $"<<endl;
    cout<<endl;
    cout<<"Preorder: $";
    preorder_traversal(root);
    cout<<" $"<<endl;
    cout<<endl;
    return true;
    
}
private:
/// @brief recursively traverse tree in inorder (LVR)
/// @param root : root node to begin traversal
void inorder_traversal(Node* root){
    //base case:
    if(root == nullptr){
        return;
    }
    inorder_traversal(root->left);
    cout<<" " << root->data;;
    inorder_traversal(root->right);
    return;
}
/// @brief recursively traverse tree in preorder (VLR)
/// @param root : root node to begin traversal
void preorder_traversal(Node* root){
     //base case:
    if(root == nullptr){
        return;
    }
    cout<<" " << root->data;;
    preorder_traversal(root->left);
    preorder_traversal(root->right);
    return;
}
/// @brief balance the AVL tree
void balance(){
    Node* unbalanced_node = find_unbalanced_node();
    if(unbalanced_node == nullptr){
        cout<<"Tree is balanced."<<endl;
    }
    else{
        cout<<"Tree is not balanced. Unbalanced node: "<< unbalanced_node->data<<endl;
        // determine how the node is imbalanced 
        if(get_balance_factor(unbalanced_node) == 2){
            // node is left imbalanced, can either be left left or left right
            if(get_balance_factor(unbalanced_node->left)==1 && get_balance_factor(unbalanced_node->left->left)==0){
                left_left(unbalanced_node);
            }
            
        }
    }

}

/// @brief Returns balance factor of passed in node (for balancing tree)
/// @param node : Node in avl
/// @return int representation of balance factor (left subtree height - right subtree height)
int get_balance_factor(Node* node){
    if (node == nullptr){
        cout<<"Node does not exist"<<endl;
    }
    return height(node->left) - height(node->right);
}

/// @brief finds and returns the first unbalanced node found in the avl
/// @return Node* to unbalanced node. If tree is balanced, return null
Node* find_unbalanced_node(){
    if(current_balance >1 || current_balance < -1){
        return this->root;
    }
    else{
        return find_unbalanced_helper(root);
    }
}
/// @brief recursive helper function to find unbalanced node
/// @param node : root of tree
/// @return : returns node that has a balance factor of -2 or 2. If none exist, returns null
Node* find_unbalanced_helper(Node* node){
    if(node == nullptr){
        return nullptr;
    }
    else{
        int node_balance = get_balance_factor(node);
        if(node_balance > 1 || node_balance < -1){
            return node;
        }
        else{
            Node* left = find_unbalanced_helper(node->left);
            if(left!= nullptr){
                return left;
            }
            Node* right = find_unbalanced_helper(node->right);
            if (right!=nullptr){
                return right;
            }
            return nullptr;
            
        }
    }
    

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
/// @brief left-left correction for unbalanced node with -2 , -1 on n->left and -1 on n->left->left
/// @param n 
void left_left(Node* n){
    // determine if n is a left or right node
    if(n->data < n->parent->data){ 
        // node is a left node
        n->parent->left = n->left;
        n->parent->left->right = new Node(n->data,n->parent);
        return;
    }
    else{
        n->parent->right = n->left;
        n->parent->right->right = new Node(n->data,n->parent);
        return;
    }
}

};

