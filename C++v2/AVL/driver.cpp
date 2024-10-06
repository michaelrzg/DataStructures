#include <iostream>
#include "AVL.h"

void test(AVL* tree){
    tree->insert(5);
    tree->insert(4);
    tree->insert(6);
     tree->insert(3);
    tree->insert(7);
    tree->insert(8);

 
}

int main(){
    AVL* tree = new AVL();
    int choice = 11;
    while(choice!=10){
        cout<< "\n----------------MAIN MENU---------------\n"
                "1. Insert Data Element\n"
                "2. Delete Data Element\n"
                "3. Search for Data Element\n"
                "4. Print Tree Size\n"
                "5. Path from Root to Data Element\n"
                "6. Check if Empty Tree\n"
                "7. Print Traversal\n"
                "8. Run Test\n"
                "9. Print Root\n"
                "10. Exit program\n"
                "Enter option number: ";
        cin>>choice;
        while(cin.fail()){
            cout<<"Please enter an integer option above: ";
            cin.clear();
            cin.ignore(256,'\n');
            cin>>choice;
        }
        switch (choice){
            case 1:
                cout<<"\nEnter a value to be inserted into the tree: ";
                int data;
                cin>>data;
                while(cin.fail()){
                    cout<<"Value entered is not an integer. Enter an integer: ";
                    cin.clear();
                    cin.ignore(256,'\n');
                    cin>>data;
                }
                tree->insert(data);
                break;
            case 2: break;
            case 3: 
                cout<<"\nEnter a value to search for in tree: ";
                int query;
                cin>>query;
                while(cin.fail()){
                    cout<<"Value entered is not an integer. Enter an integer: ";
                    cin.clear();
                    cin.ignore(256,'\n');
                    cin>>query;
                }
                if(tree->search(query)){
                    cout<<"Value " << query<< " exists in the tree!"<<endl;
                }
                else{
                    cout<<"Value " << query<< " does not exists in the tree!"<<endl;
                }
                break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7:
                tree->print();
                break;
            case 8:
                test(tree);
                break;
            case 9:
                if(tree->root != nullptr){
                    cout<<"ROOT: " << tree->root->data<<endl;
                }
        }
    }

    


}
