// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: IntelliJ Idea
import java.util.Scanner;
public class TestQueue {

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>();
        int response = 0; int data;
        //^create initial objects^
        while(response!=7){
            System.out.println("\n\n--------MAIN MENU--------\n" +
                    "1 - Enqueue element\n" +
                    "2 - Dequeue element\n" +
                    "3 - Front element\n" +
                    "4 - Size of queue\n" +
                    "5 - Is Empty queue?\n" +
                    "6 - Print queue content\n" +
                    "7 - Exit program\n" +
                    "Enter option number:\n");
                response = sc.nextInt();            //reads in user input
                switch(response){                   //switch user input
                    case 1:
                        System.out.print("Enter a value to queue: ");
                        data = sc.nextInt();                    //takes in value to queue
                        System.out.print("Testing method enqueue()\n" +
                                "List content before queueing node is:\t"); queue.printList();
                                queue.enqueue(data);            //queues value
                            System.out.print("\nList content after queueing node is:\t"); queue.printList();
                            break;
                    case 2:
                        System.out.print("Testing method dequeue()\n" +
                                "List content before dequeueing node is:\t"); queue.printList();
                        queue.dequeue();                        //dequeues first value
                        System.out.print("\nList content after dequeuing node is:\t"); queue.printList();
                        break;
                    case 3:
                        System.out.println("Testing front() method:" +
                                "\n Front Element: " + queue.front());      //prints element in front of line without removing it
                        break;
                    case 4:
                        System.out.println("Testing size()");
                        System.out.println("Size of queue: " + queue.size()); //prints the size of the line
                        break;
                    case 5:
                        System.out.println("Testing isEmpty()");
                        System.out.println("Is queue empty? : " + queue.isEmpty());//returns true if the queue is empty
                        break;
                    case 6:
                        System.out.println("Testing method printList()");
                        System.out.println(); queue.printList();        //prints the queue
                        break;


            }
        }


    }

}
