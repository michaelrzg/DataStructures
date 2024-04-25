// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: IntelliJ Idea
import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    //method below returns the digit in the index of the passed in seq number from the number variable. (so if (1234,0) are passed in returns 4
    public static int ExtractDigit(int number , int seq){
                                                        //works by taking the seq number and setting the power of 10 to it. This decides which digit is to be extracted.
        return (number / (int)(Math.pow(10,seq))) % 10;   //divides number by said value of 10^seq which leaves the digit we want extracted in the ones place and ignores remainder/decimal
                                                        //finally, takes modulus of the remaining number by 10 to extract first digit from it.
                                                        //if the sequence requested is higher than the number if digits in a given integer, the method will return 0, which is what is required for radix search anyways
    }

    //below method returns digit count.
    public static int digitCount(int num){
        int count =0;           //sets counter to 0
        if(num==0){
            return 1;           //checks if passed in number is 0, returns 1
        }
        while(num!=0){
            num/=10;            //continuously divides teh numebr by 10 until there is no more ones place left
            count++;
        }
        return count;       //returns how many divides happened which will equal how many digits are in the number
    }


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int response = 0; int size; int sequence = 0;
        int [] array = new int[0]; int current=0; String originalInput=""; int highest =0;
        Queue<Integer> q0=new Queue<>(),q1=new Queue<>(),q2=new Queue<>(),q3=new Queue<>(),q4=new Queue<>(),q5=new Queue<>(),q6=new Queue<>(),q7=new Queue<>(),q8=new Queue<>(),q9 = new Queue<>();
        //^setup objects and set of queues^
        while(response!=5){
            System.out.print("\n\n--------MAIN MENU--------\n" +
                    "1 - Read array size\n" +
                    "2 - Read array values\n" +
                    "3 - Run Radix Sort algorithm (no printing)\n" +
                    "4 - Print outputs\n" +
                    "5 - Exit program\n" +
                    "Enter option number:");
                    response = sc.nextInt(); sc.nextLine();     //reads user input
                    switch(response){                           //switch with user input
                        case 1:
                            System.out.println("Enter a size for the array: ");
                            size = sc.nextInt(); sc.nextLine();
                            array = new int[size];              //recreates the array with correct size
                            System.out.println("Array size: " + size);
                            break;
                        case 2:
                          for(int i=0;i< array.length;i++){
                              System.out.println("Enter value " + (i+1) + " : ");   //goes thru each position and prompts user for value
                              array[i] = sc.nextInt();
                          }
                          originalInput = Arrays.toString(array);           //saves the original values in a string to reprint original array in option 4
                            highest = digitCount(array[0]);                 //sets highest digit count variable to first cell of array
                            for(int i=0;i<array.length;i++){
                                if(digitCount(array[i]) > highest){
                                    highest = digitCount(array[i]);         //loops thru array and finds digit with highest count, sets variable to it
                                }
                            }
                          break;

                        case 3:
                           for(int p=0;p<highest;p++){         //starts by creating nested loop that runs the outer the number of times that the highest number has digits
                               for (int j : array) {                //outer loop runs the search and incriments sequence counter, inner array sorts each token into a queue
                                   current = ExtractDigit(j, sequence);      //this line decides which queue a number is going to go in, based on the extracted digit.
                                   switch (current) {                          //switch adds that number to the correct queue
                                       case 0 -> q0.enqueue(j);
                                       case 1 -> q1.enqueue(j);
                                       case 2 -> q2.enqueue(j);
                                       case 3 -> q3.enqueue(j);
                                       case 4 -> q4.enqueue(j);
                                       case 5 -> q5.enqueue(j);
                                       case 6 -> q6.enqueue(j);
                                       case 7 -> q7.enqueue(j);
                                       case 8 -> q8.enqueue(j);
                                       case 9 -> q9.enqueue(j);
                                   }                                    //this entire loop never updates the actual array, only queues numbers
                               }
                            for(int k=0;k<array.length;k++){            //this loop goes thru from q0-q9 and adds from the lowest queue until that queue is empty, then moves on to the next until that is emptu, and so on
                                   if(q0.front()!=null){                // the array is updated using all the values stored
                                       array[k] = q0.dequeue();
                                   } else if(q1.front()!=null){
                                       array[k] = q1.dequeue();
                                   } else if(q2.front()!=null){
                                       array[k] = q2.dequeue();
                                   } else if(q3.front()!=null){
                                       array[k] = q3.dequeue();
                                   } else if(q4.front()!=null){
                                       array[k] = q4.dequeue();
                                   } else if(q5.front()!=null){
                                       array[k] = q5.dequeue();
                                   } else if(q6.front()!=null){
                                       array[k] = q6.dequeue();
                                   } else if(q7.front()!=null){
                                       array[k] = q7.dequeue();
                                   } else if(q8.front()!=null){
                                       array[k] = q8.dequeue();
                                   } else if(q9.front()!=null){
                                       array[k] = q9.dequeue();
                                   }
                               }
                            sequence++;                                 //finally this line updates the sequence counter.
                           }
                            break;
                        case 4:             //prints original saved in string format, and the sorted array
                            System.out.println("\nArray Inputs before sorting:\t" + originalInput);
                            System.out.println("Array Inputs after sorting:\t\t" + Arrays.toString(array));
                            break;
                            }

                    }

        }
    }

