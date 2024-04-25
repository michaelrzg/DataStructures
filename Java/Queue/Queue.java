// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: IntelliJ Idea
public class Queue<E> {

    Node<E> head;
    Node<E> tail;

//below method takes a generic type data and adds it to the back of the line
    public void enqueue(E data){
        if(head==null){     //if list is empty sets head and tail to new node data
            tail = head = new Node<>(data);
        }
        else{
            Node<E> temp = new Node<>(data);    //creates temp node data
            tail.next=temp; //sets it to end of list
            tail=temp;      //updates tail pointer
        }
    }
    //below method removes first element from list and returns it
    public E dequeue()
    {
        if(head==null){   //if list is empty, returns null
            return null;
        }
        Node<E> temp = head;    //sets temp variable to store current head data
        head = head.next;       //progresses head by 1
        return temp.data;       //returns prev head data

    }
    //below method reutrns the data of the first element without removing it from list
    public E front(){
        if(head == null){
            return null;
        }
        return head.data;
    }
    //below method checks if the list is empty, returns true if empty
    public boolean isEmpty()
    {
        return head==null;
    }
//below method prints the list
    public void printList() {
        Node<E> pointer = head;         //creates a pointer and points it at head
        while(pointer!=null){           //check if pointer is null
            System.out.print(pointer.data + "\t");  // if not null, prints current data variable of pointer
            pointer=pointer.next;                   //progresses loop
        }
    }
    //below method returns the size of the list
    public int size(){
        int count=0;                //counter set to 0
        Node<E> pointer = head;     //pointer set to head
        while(pointer!=null){       //while pointer has a value
            count++;                //increment counter
            pointer=pointer.next;   //progress loop
        }
        return count;
    }

    class Node<E>{
        E data;
        Node<E> next;
        Node(E data){
            this.data=data;
        }
    }


}
