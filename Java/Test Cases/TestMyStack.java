// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: IntelliJ Idea
import java.util.Scanner;
public class TestMyStack {
    public static void main(String[]args){


        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int response=8;
        int data;       //^setup objects^
        while(response!=7){
            System.out.print("\n\n--------MAIN MENU-------\n" +
                    "1 - Push element\n" +
                    "2 - Pop element \n" +
                    "3 - Top element\n" +
                    "4 - Size of stack\n" +
                    "5 - Is Empty stack?\n" +
                    "6 - Print stack content\n" +
                    "7 - Exit program\n" +
                    "Enter option number:");
            response = sc.nextInt();    //reads user input
            switch(response){
                case 1:
                    System.out.println("Enter a value to push: " );
                    data = sc.nextInt();
                    System.out.print("Testing method push()\n" +
                            "List content before pushing node is: "); stack.printList();
                    stack.push(data);
                    System.out.print("\nList content after  pushing node is: "); stack.printList();
                    break;
                case 2:
                    System.out.print("Testing method pop()\n" +
                            "List content before popping node is: "); stack.printList();
                    System.out.println("\nPopped element value: " + stack.pop());
                    System.out.print("List content after  popping node is: "); stack.printList();
                    break;
                case 3:
                    System.out.print("Testing method top()\n" +
                            "List content before top() method is: "); stack.printList();
                    System.out.println("\nTop element is : " + stack.top());
                    System.out.print("List content after  top() method is: "); stack.printList();
                    break;
                case 4:
                    System.out.println("Testing size() method. \nSize of the stack is : " + stack.size());
                    break;
                case 5:
                    System.out.println("Testing isEmpty() method.");
                    System.out.println("Method returns " + stack.isEmpty());
                    break;
                case 6:
                    System.out.println("\nCurrent Stack : " ); stack.printList();
                    break;
            }
        }


    }
}
