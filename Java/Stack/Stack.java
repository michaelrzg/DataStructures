// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: IntelliJ Idea
public class Stack<E> {

    public Node<E> head = null;

//push method adds passed element to top of stack
    public void push(E element){
        Node<E> temp = new Node<>(element); //creates node with element data
        if (head != null) {     //checks to see if list is empty
            temp.next = head;   //if list is not empty, sets temps next pointer to the first node, making temp the new first node
        }
        head=temp;  //whether the list is empty or not this code must be run
    }

    //pops the first element off stack and returns it
    public E pop(){
        if(head==null){     //checks if list is empty
            return null;    //returns nothing if it is
        }

        Node<E> temp = head;    //sets a temp value to heads current memory address
        head=head.next; //progresses head down the list
        return temp.data;   //returns previous heads data
    }
    //peeks top element without removing it
    public E top(){
        if(head==null){     //checks if list is empty
            return null;    //returns nothing if it is
        }
       return head.data;    //else returns the top value of stack, doesn't progress stack
    }
    //prints list
    public void printList(){
        Node<E> pointer = head;     //creates pointer and sets it to top of stck
        while(pointer!=null){       //loops thru while pointer has a value
            System.out.print(pointer.data + "\t");  //prints
            pointer=pointer.next;       //progresses
        }
    }
    //returns size of stack
    public int size(){
        int counter=0;  //counter variable set to 0
        if(head==null){     //checks if list is empty, returns 0;
            return 0;
        }
        Node<E> pointer = head; //temp pointer
        while(pointer!=null){       //moves thru list while pointer has a value
            pointer=pointer.next;   //progresses
            counter++;              //counts
        }
        return counter;             //returns count
    }
    //returns true if list is empty
    public boolean isEmpty(){
        return head == null;    //if head == null, true is returned, else false
    }

    //generic node class
    public class Node <E> {

        E data;
        Node<E> next = null;

        Node(E element) {
            data = element;
        }
    }

}
