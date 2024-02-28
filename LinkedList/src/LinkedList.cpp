
// Linked List Driver
// Michael Rizig
// 2/23/24
#include "LinkedList.h"
#include <iostream>
using namespace std;

int main(){
    LinkedList* list = new LinkedList();
    int userChoice = 11; int value; int index;
    while(userChoice!=10){
        cout<<endl<<"---------MAIN MENU--------\n"
              "1 - Add First Node\n"
              "2 - Add Last Node\n"
              "3 - Add At Index\n"
              "4 - Remove First Node\n"
              "5 - Remove Last Node\n"
              "6 - Remove At Index\n"
              "7 - Print List Size\n"
              "8 - Print List (Forward)\n"
              "9 - Print List (In Reverse)\n"
              "10- Exit program\n"
              "Enter option number: ";
        cin>>userChoice;
        switch(userChoice){
            case 1:
                cout<<"\nPlease enter a value for the first node: ";
                cin>>value;
                cout<<endl<<"List contents before adding "<<value<<":"<<endl;
                list->printList();
                list->addFirstNode(value);
                cout<<endl<<"List contents after adding "<<value<<":"<<endl;
                list->printList();
                break;
            case 2:
                cout<<"\nPlease enter a value for the last node: ";
                cin>>value;
                cout<<endl<<"List contents before adding "<<value<<":"<<endl;
                list->printList();
                list->addLastNode(value);
                cout<<endl<<"List contents after adding "<<value<<":"<<endl;
                list->printList();
                break;
            case 3:
                if(list->isEmpty()){
                    cout<<"\nList is empty! Please add to the list first before using this feature!"<<endl;

                }
                else {
                    cout<<"\nCurrent list:"<<endl;
                    list->printList();
                    cout << "\nWhich index would you like to add at? (first index =1):";
                    cin >> index;
                    while (index < 0 || index > list->size()) {
                        cout << "Please enter a valid index! : ";
                        cin >> index;
                    }
                    cout<<"What number would you like to add at index " << index <<"? : ";
                    cin>>value;
                    cout << endl << "List contents before adding " << value << " at index " << index << ":" << endl;
                    list->printList();
                    list->addAtIndex(index, value);
                    cout << endl << "List contents after adding " << value << "at index " << index << ": " << endl;
                    list->printList();
                }
                break;
            case 4:
                if(list->isEmpty()){
                    cout<<"\nList is empty!!"<<endl;
                }
                else {
                    cout << "\nList before removing first node: " << endl;
                    list->printList();
                    list->removeFirstNode();
                    cout << "\nList after removing first node: " << endl;
                    list->printList();

                } break;
            case 5:
                if(list->isEmpty()){
                    cout<<"\nList is empty!!"<<endl;
                }
                else {
                    cout << "\nList before removing last node: " << endl;
                    list->printList();
                    list->removeLastNode();
                    cout << "\nList after removing last node: " << endl;
                    list->printList();

                }
                break;
            case 6:
                if(list->isEmpty()){
                    cout<<"\nList is empty!"<<endl;
                }
                else{
                    cout<<"\nCurrent list:"<<endl;
                    list->printList();
                    cout << "\nWhich index would you like to remove? (first index =1):";
                    cin >> index;
                    while (index < 0 || index > list->size()) {
                        cout << "Please enter a valid index! : ";
                        cin >> index;
                    }
                    cout << endl << "List contents before removing index " << index << ":" << endl;
                    list->printList();
                    list->removeAtIndex(index);
                    cout << endl << "List contents after removing index " << index << ": " << endl;
                    list->printList();
                }
                break;
            case 7:
                cout<<"\nList size: " << list->size()<<endl;
                break;
            case 8:
                cout<<"\nList contents: "<<endl;
                list->printList();
                break;
            case 9:
                cout<<"List in reverse: "<<endl;
                list->printListReversed();



        }
    }



    return 0;
}