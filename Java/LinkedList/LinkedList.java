// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ Idea

public class LinkedList
{
   public Node head, tail;

   //constructor method to create a list of object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   //method #1: add first node
   public void addFirstNode(int data)
   {
      if(head==null)        //checks to see if list is empty
      {                    //if so, sets head and tail to new node
         head=new Node(data);
         tail=head;
      }
      else
      {
         Node insert = new Node(data);  //creates node with data
         insert.next=head;  //sets the new nodes next to head
         head=insert;       //sets head to new node


      }
   }
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      if(index==0)  // checks to see if index passed is first of list
      {
         addFirstNode(data);  //if so, runs addfirstnode method defined above
      }
      else
      {
         Node current = head;    //sets current pointer to first
         Node prev = null;       //sets prev pointer to null
        for(int i=0;i<index;i++)
         {  prev=current;           //cycles thru till 1 less than index
            current=current.next;   //advances current poiter
         }
        Node insert = new Node(data);  //creates new node with desired data
        insert.next=current;     //sets new nodes next to current
        prev.next=insert;        //sets prev next to new node
      }
   }
   //method #3: remove first node
   public void removeFirstNode()
   {     Node temp = head;    //sets pointer to first in list
         head = head.next;    //moves head pointer up
         temp.next =null;     //effectively deletes the old first node
   }
      
   //method #4: remove last node
   public void removeLastNode()
   {  Node pointer=head;       //creates pointer and sets to head
         while(pointer.next.next!=null)
         {                    //cyclles thru until 2 before last
            pointer=pointer.next;
         }
         pointer.next=null;   //sets the one before last to point to null
   }
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
      if(index==0)      //checks if requested index is first node
      {
         removeFirstNode();     //calls first node removal method
      }
      else {
         Node pointer = head;       //creates pointer aimed at head

         for (int i = 1; i < index;i++)
         {
            pointer=pointer.next;      //cycles thru until 1 before index wanted
         }
         pointer.next=pointer.next.next;     // sets that index's next to the next next , skipping the index we want removed
      }
   }
          
   //method #6: countNodes
   public int countNodes()
   {
         int listSize= 0;  //counts size
         Node pointer = head;    //sets pointer to head
         while(pointer!=null){

         listSize++;       //increments size
         pointer=pointer.next;   //moves loop forward
         }

         return listSize;  //when loop is exhausted, return final size
         
   }
   
   //method #7: pritnInReverse  (Recursive method)
   public void printInReverse(Node L)
   {
      if(L.next!=null) {      //checks if L is the last node
         printInReverse(L.next);    // if not recalls the method with the next in the list
      }
      System.out.print(L.data + "\t");  //prints this instances data when the runtime stack returns to this instance to end it
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      if(head==null)
      {
         System.out.println("List is Empty");
      }
      else {
         Node temp;
         temp = head;
         while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
         }
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

