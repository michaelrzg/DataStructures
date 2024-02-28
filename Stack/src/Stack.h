
//Stack Source Header
//Michael Rizig
// 2/24/24

#include <iostream>
class Stack{
    class Node{
    public:
        Node*next;
        int data;
        Node(int data){
            this->data = data;
            next= nullptr;
        }
    };

    Node* head;
public:
    void push(int i){
        if(head== nullptr){
            head= new Node(i);
        }
        else{
            Node* temp = new Node(i);
            temp->next=head;
            head=temp;
        }
    }
    int pop(){
        if(head== nullptr){
            return 0;
        }
        else
        {
            int data = head->data;
            if(head->next== nullptr){
                head= nullptr;
            }
            else{
                head=head->next;
            }
            return data;

        }
    }
    int peek(){
        if(head== nullptr){
            return 0;
        }
        else return head->data;
    }
    bool isEmpty(){
        if(head== nullptr){
            return true;
        }
        return false;
    }
    int size(){
        int counter=0;
        if(isEmpty()){
            return 0;
        }
        else{
            Node* current =head;
            while(current!= nullptr){
                counter++;
                current=current->next;
            }
            return counter;
        }
    }

    void printList(){
        std::cout<<"HEAD -> ";
        Node* temp = head;
        while(temp!=nullptr){
            std::cout<<temp->data<<" -> ";
            temp=temp->next;
        }
        std::cout<<"||"<<std::endl;
    }
    void printListReversed(){
        std::string s="";
        Node* current=head;
        while(current!=nullptr){
            s.insert(0,"<- "+std::to_string(current->data) +" ");
            current=current->next;
        }
        s.insert(0,"|| ");
        std::cout<<s<<"<- HEAD"<<std::endl;
    }

};