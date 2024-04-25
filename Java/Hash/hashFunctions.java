
// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: IntelliJ Idea
import java.util.Scanner;
public class hashFunctions
{
    public static void main(String[]args){
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

        Scanner sc = new Scanner(System.in); int userChoice=6; int [][] table = new int[50][2];
        while(userChoice!=5){
            System.out.print("-----MAIN MENU--------------------------------------\n" +
                    "1. Run HF1 (Division method with Linear Probing)\n" +
                    "2. Run HF2 (Division method with Quadratic Probing)\n" +
                    "3. Run HF3 (Division method with Double Hashing)\n" +
                    "4. Run HF4 (Student Designed HF)\n" +
                    "5. Exit program\n" +
                    "Enter option number:");
            userChoice=sc.nextInt();
            switch(userChoice){
                case 1:
                    System.out.println("\nTESTING METHOD HF1:\n\nHash table resulted from HF1:\n");
                    table=HF1(keys);
                    print(table);
                    break;
                case 2:
                    System.out.println("\nTESTING METHOD HF2:\n\nHash table resulted from HF2:\n");
                    table=HF2(keys);
                    print(table);
                    break;
                case 3:
                    System.out.println("\nTESTING METHOD HF3:\n\nHash table resulted from HF3:\n");
                    table=HF3(keys);
                    print(table);
                    break;
                case 4:
                    System.out.println("\nTESTING METHOD HF4:\n\nHash table resulted from HF4:\n");
                    table=HF4(keys);
                    print(table);
                    break;
            }
        }
    }
    public static int sumProbes(int [][] table){
       int sum=0;
        for (int i=0;i<50;i++){
            sum+=table[i][1];
        }
        return sum;

    }
    public static int[][] HF1(int [] keys){
        int[][]table = new int[50][2];              //working table and variables for method
        int loc=0; int counter=0;
        for (int key : keys) {                      //iterates through passed keys array
            loc = (key % 50);                       //division method to get first hash address

            while (table[loc][0] != 0) {            //if address is occupied
                loc++;                              //linearly goes forward through array until location is found
                counter++;
                if (loc == 50) {                    //when iterator reaches 50, resets to first element in array
                    loc = 0;
                }
            }
            table[loc][0] = key;                    //when while is exited, a location is found, sets locaiton to key value
            table[loc][1] = counter;                //sets probe value to counter value
            counter = 0;                            //resets counter for next key
        }
        return table;

    }
    public static int[][] HF2(int []keys){
        int[][]table = new int[50][2];      //new array
        int loc=0; int counter=0; int factor=1; int oKey;
        for (int key : keys) {              //iterates through all keys
            loc = oKey = (key % 50);               //division method to find initial hash address
            while (table[loc][0] != 0) {        //while the current address is not empty
                System.out.println(loc);
                loc = (oKey +(factor*factor)) %50; factor++; counter++;      //quadratic probing d + i^2 % 50; always results in a value between 0-50
            }
            table[loc][0] = key;                                   //when while is exited, a location is found, sets locaiton to key value
            table[loc][1] = counter;                               //sets probe value to counter value
            counter = 0; factor=1;
        }                                         //resets counter for next key


        return table;                                               //finally returns complete table

    }
    public static int[][] HF3(int [] keys) {
        int[][] table = new int[50][2];
        int H2 = 0;
        int loc = 0;
        int counter = 0;                    //setup variables and table
        for (int key : keys) {              //iterate through keys
            boolean skip = false;           //reset bool to false
            loc = (key % 50);               //original key
            H2 = 30 - key % 25;             //double hash value
            int j = 0;
            while (table[loc][0] != 0) {    //while no open location is found
                j++;
                loc = ((key%50) + j * H2 )%50 ;     //find second address using original key and double hash value
                counter++;
                if (counter > 50) {                 //if 50 attempts are made, break and set flag true
                    System.out.println("No location found for key: " + key);
                    skip = true;
                    break;
                }
            }
            if(!skip) {                 //if flag was set, skip setting value
                table[loc][0] = key;                                   //when while is exited, a location is found, sets location to key value
                table[loc][1] = counter;                               //sets probe value to counter value

            }   counter = 0;                                           //reset counter
        }
            return table;
        }


        /** below function HF4 uses FOLDING method found in slides, and DOUBLE HASHING as collision resolution
         *  STEP1: gets first and second half of key value, multiplies the least significant half by 2 and adds them, mod 50
         *
         *  ex. key = 1234 ; p1 = 12 ; p2 = 34 ; location = 12 +34(2) = 80 %50 = 30
         *
         *  STEP2:
         *  if location is taken, re-hashes using the following formulas:
         *  H2(key) = 30-key%11
         *  newLocation = key + j * H2
         *  same num of tries limit as HF3
         *
         *  RESULT : 58 total probes ; 3 un-hashed keys
         *  47 hashed keys / 50 total keys = 94% success rate
         *
         *  (**UN-HASHED KEYS ARE PRINTED ABOVE TABLE**)
         *  **/
    public static int [][] HF4(int []keys){
        int[][] table = new int[50][2];
        int H2 = 0;
        int loc = 0;
        int counter = 0;                    //setup variables and table
        for (int key : keys) {              //iterate through keys
            boolean skip = false;               //reset bool to false
            int p1 = key/100;
            int p2 = key%100;
            loc = (p1+p2*2)%50;                   //original key
            H2 = 30 - key % 11;                   //double hash value
            int j = 0;
            while (table[loc][0] != 0) {         //while no open location is found
                j++;
                loc = ((key) + j * H2 )%50 ;     //find second address using original key and double hash value
                counter++;
                if (counter > 50) {                 //if 50 attempts are made, break and set flag true
                    System.out.println("No location found for key: " + key);
                    skip = true;
                    break;
                }
            }
            if(!skip) {                                               //if flag was set, skip setting value
                table[loc][0] = key;                                   //when while is exited, a location is found, sets location to key value
                table[loc][1] = counter;                               //sets probe value to counter value

            }   counter = 0;                                           //reset counter
        }
        return table;
    }


    public static void print(int [][]array){
       System.out.println(
               "Index\tKey\t  probes\n" +
               "------------------------");
       for(int i=0;i<50;i++){
           if(i<10){
               System.out.print("  0" + i + "    " + array[i][0] + "    "+ array[i][1]);
           }
           else{
               System.out.print("  " + i + "    " + array[i][0] + "    "+ array[i][1]);
           }
           System.out.println();
       }
       System.out.println("------------------------\n" +
               "Sum of probe values = "+ sumProbes(array)+".\n");
    }


}
