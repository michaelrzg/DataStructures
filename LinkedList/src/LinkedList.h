
// Linked List Source Header
// Michael Rizig
// 2/23/24
#include <iostream>
class LinkedList{

    class Node{
    public:
       Node* next;
       int data;
        explicit Node(int a){
            data=a;
            next= nullptr;
        }
    };
    Node* head;
public:
    void addNode(int i) {
        if (isEmpty()) {
            head = new Node(i);

        } else {
            Node *temp = head;
            while (temp->next != nullptr) {
                temp = temp->next;
            }
            temp->next = new Node(i);
        }
    }
    void addFirstNode(int i){
        if (head== nullptr){
            head = new Node(i);
            return;
        }
        else{
            Node* temp = new Node(i);
            temp->next=head;
            head=temp;
        }
    }
    void addLastNode(int i){
        if(isEmpty()){
            head=new Node(i);
            return;
        }
        else{
            Node* Current = head;
            while(Current->next!= nullptr){
                Current=Current->next;
            }
            Current->next=new Node(i);
            return
            ;
        }
    }
    void addAtIndex(int index, int data){
        if(isEmpty()){
            std::cout<<"List is Empty!"<<std::endl;

        }
        if(index==1){
            addFirstNode(data);

        }
        else if(size()<index || index<1){
            std::cout<<"Invalid Index!"<<std::endl;
        }
        else{
            Node* current = head;
            Node*prev;
            for(int i=0;i<index-1;i++){
                prev=current;
                current = current->next;
            }
            Node* temp = new Node(data);
            prev->next = temp;
            temp->next = current;

        }
    }
    void removeFirstNode(){
        if(head!= nullptr){
            if(head->next== nullptr){
                head= nullptr;
            }
            else{
                head=head->next;
            }
        }
    }
    void removeLastNode(){
        if(this->isEmpty()){
            return;
        }
        else if (head->next==nullptr){
            head= nullptr;
        }
        else{
            Node* current=head;
            Node* prev=head;
            while(current->next!= nullptr){
                prev=current;
                current=current->next;
            }
            prev->next= nullptr;
        }

    }
    void removeAtIndex(int index){
        if(isEmpty()){
            return;
        }
        else if(index==1){
            removeFirstNode();
            return;
        }
        else{
            Node* current = head;
            Node* prev = current;
            for(int i=0;i<index-1;i++){
                prev=current;
                current=current->next;
            }
            prev->next=current->next;

        }
    }

    bool removeNode(int i){
        if(isEmpty()){
            std::cout<<"There are no nodes in the list!"<<std::endl;
            return false;
        }
        else{
            if(head->data==i){
                if(head->next== nullptr){
                    head= nullptr;
                }
                else{
                    head=head->next;
                }
                return true;
            }
            else {
                Node *current = head->next;
                Node* prev=head;
                do{
                    if(current->data==i){
                        prev->next=current->next;
                        return true;
                    }
                    prev = current;
                    current=current->next;
                }
                while(current->next!= nullptr);
                std::cout<<i<< " is not in the list!"<<std::endl;
                return false;

            }
        }
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