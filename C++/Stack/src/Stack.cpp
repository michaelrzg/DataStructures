
// Stack Driver
// Michael Rizig
// 2/24/24

#include <iostream>
#include "Stack.h"
using namespace std;
int main(){
    Stack* stack = new Stack();
    int input=-1; int data;
    while(input!=7){
        cout<<"\n--------MAIN MENU--------\n"
              "1 - Push element\n"
              "2 - Pop element\n"
              "3 - Front element\n"
              "4 - Size of stack\n"
              "5 - Is Empty stack?\n"
              "6 - Print stack content\n"
              "7 - Exit program\n"
              "Enter option number:";
        cin>>input;
        switch(input){
            case 1:
                cout<<"\nWhat number would you like to push?: ";
                cin>>data;
                cout<<"\nStack before push: "<<endl;
                stack->printList();
                stack->push(data);
                cout<<"\nStack after push: "<<endl;
                stack->printList();
                break;
            case 2:
                if(stack->isEmpty()){
                    cout<<"\nStack is Empty!!"<<endl;
                }
                else{
                    cout<<"\nStack before pop: "<<endl;
                    stack->printList();
                    stack->pop();
                    cout<<"\nStack after pop: "<<endl;
                    stack->printList();
                }
                break;
            case 3:
                cout<<"\nFront element: "<<stack->peek()<<endl;
                break;
            case 4:
                cout<<"\nSize of stack: " << stack->size()<<endl;
                break;
            case 5:
                if(stack->isEmpty()){
                    cout<<"\nStack is Empty!!"<<endl;
                }
                else{
                    cout<<"\nStack is Not Empty!!"<<endl;
                }
                break;
            case 6:
                cout<<"\nStack contents: "<<endl;
                stack->printList();
                break;
        }
    }
    return 0;
    
}