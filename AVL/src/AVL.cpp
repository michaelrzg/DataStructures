// This is the driver class for the AVL (self-balancing tree)
// Michael Rizig
// 2/27/24

#include <iostream>
#include "AVL.h"

using namespace std;
int dataBuffer(string s){
    while( s[0] <48 || s[0]>57){
        cout<<"\nPlease enter a valid input: ";
        cin>>s;
    }
    return stoi(s);
}
int main(){
     AVL* tree = new AVL;
     tree->insert(15,tree->root);
     tree->insert(7,tree->root);
     tree->insert(6,tree->root);
     //tree->insert(5,tree->root);
    int input = 11; std::string inputBuffer;
    int data;string buffer;
    while (input != 10) {
        std::cout << "\n----------------MAIN MENU---------------\n"
                     "1. Insert Data Element\n"
                     "2. Delete Data Element\n"
                     "3. Search for Data Element\n"
                     "4. Print Tree Size\n"
                     "5. Path from Root to Data Element\n"
                     "6. Check if Empty Tree\n"
                     "7. Print Traversal\n"
                     "10. Exit program\n"
                     "Enter option number: ";

        cin >> inputBuffer;
        input= dataBuffer(inputBuffer);
        switch (input) {
            case 1:
                cout << "\nEnter a number to be inserted into tree: ";
                cin >> buffer;
                data= dataBuffer(buffer);
                std::cout << "\nTree before insert:" << endl;
                tree->printTree();
                tree->insert(data, tree->root);
                std::cout << "\nTree after insert:" << endl;
                tree->printTree();
                tree->treeVisual();
                break;
            case 2:
                cout << "\nEnter a number to be remove from the tree: ";
                cin>>buffer;
                data= dataBuffer(buffer);
                std::cout << "\nTree before delete:" << endl;
                tree->printTree();
                tree->remove(data,tree->root,tree->root);
                std::cout << "\nTree after delete:" << endl;
                tree->printTree();
                tree->treeVisual();
                break;
            case 3:
                cout<<"\nEnter a number to find in tree: ";
                cin>>buffer;
                data= dataBuffer(buffer);
                tree->treeVisual();
                if(tree->search(data, tree->root)){
                    cout<<"\nResult: "<<data<<" exists in the tree."<<endl;
                }
                else{
                    cout<<"\nResult: "<<data<<" does not exist in the tree."<<endl;
                }
                break;
            case 4:
                cout<<"\nTree size: "<< tree->treeSize(tree->root)<<endl;
                tree->treeVisual();
                break;
            case 5:
                cout<<"\nWhat n ode would you like to track down?: ";
                cin>>buffer;
                data= dataBuffer(buffer);
                cout<<tree->printPath(data,tree->root);
                tree->treeVisual();
                break;
            case 6:
                if(tree->isEmpty()){
                    cout<<"\nTree is empty!"<<endl;
                }
                else{
                    cout<<"\nTree is not empty!"<<endl;

                }
                break;
            case 7:
                cout<<"\nTree Traversal: "<<endl;
                tree->treeVisual();
                cout<<"\n LVR(in-order): ";
                tree->printTree();
                cout<<"\n";
                tree->printArrayForm();
                break;
            case 8:
                tree->updateBalanceFactors(tree->root);
                tree->printBalanceFactor();
                break;  
        }   
    }
}