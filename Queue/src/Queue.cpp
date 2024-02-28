
// Queue Driver
// Michael Rizig
// 2/24/24

#include <iostream>
#include "Queue.h"
using namespace std;
int main(){
    Queue* queue = new Queue();
    int input=-1; int data;
    while(input!=7){
        cout<<"\n--------MAIN MENU--------\n"
              "1 - enqueue element\n"
              "2 - dequeue element\n"
              "3 - Front element\n"
              "4 - Size of queue\n"
              "5 - Is Empty queue?\n"
              "6 - Print queue content\n"
              "7 - Exit program\n"
              "Enter option number:";
        cin>>input;
        switch(input){
            case 1:
                cout<<"\nWhat number would you like to enqueue?: ";
                cin>>data;
                cout<<"\nQueue before enqueueing: "<<endl;
                queue->printList();
                queue->enqueue(data);
                cout<<"\nQueue after enqueue: "<<endl;
                queue->printList();
                break;
            case 2:
                if(queue->isEmpty()){
                    cout<<"\nQueue is Empty!!"<<endl;
                }
                else{
                    cout<<"\nQueue before dequeue: "<<endl;
                    queue->printList();
                    queue->dequeue();
                    cout<<"\nQueue after dequeue: "<<endl;
                    queue->printList();
                }
                break;
            case 3:
                cout<<"\nFront element: "<<queue->front()<<endl;
                break;
            case 4:
                cout<<"\nSize of queue: " << queue->size()<<endl;
                break;
            case 5:
                if(queue->isEmpty()){
                    cout<<"\nqueue is Empty!!"<<endl;
                }
                else{
                    cout<<"\nQueue is Not Empty!!"<<endl;
                }
                break;
            case 6:
                cout<<"\nQueue contents: "<<endl;
                queue->printList();
                break;
        }
    }
    return 0;

}