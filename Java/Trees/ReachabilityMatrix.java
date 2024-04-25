
// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 9
// IDE Name: IntelliJ Idea

import java.util.Scanner;
public class ReachabilityMatrix {
    public static void main(String[]args){
        int [][] a1 = null;
        int userChoice = 4;
        Scanner sc = new Scanner(System.in);
                /* ^^ setup objects ^^ */
        boolean dataisSet=false;        //flag to ensure that data has been entered
         //creates the matrix
        while(userChoice!=3){
            System.out.print("""

                ------MAIN MENU------
                1. Enter graph data
                2. Print outputs
                3. Exit program
                Enter option number:""");
            userChoice = sc.nextInt();      //takes in user input
            switch (userChoice){
                case 1:
                    System.out.println("Please enter the number of nodes in the graph:");
                    int numOfNodes = sc.nextInt();
                    while(numOfNodes<=1 || numOfNodes>5){
                        System.out.println("Please enter a size between 2 and 5.");         //ensures non-zero input for size
                        numOfNodes = sc.nextInt();
                    }
                    a1 = new int[numOfNodes][numOfNodes];
                    System.out.println();
                    for(int i=0;i<numOfNodes;i++){
                        for (int j=0;j<numOfNodes;j++){
                            System.out.print("Enter A1 [" + i + "," + j + "]: ");   //cycles through and takes input for each cell in the array
                            a1[i][j]=sc.nextInt();
                        }
                        System.out.println();
                    }
                    dataisSet=true;                                                 //sets flag as true
                    break;
                case 2:
                    if (dataisSet) {
                        System.out.println("\n\nInput Matrix: ");
                        printMatrix(a1);
                        printReachabilityMatrix(a1);
                        printInDegrees(a1);
                        printOutDegrees(a1);
                        printSelfLoops(a1);
                        maxLengthCycles(a1);
                        pathsLength1Edge(a1);                                           //print all necessary lines
                        pathsLengthN(a1);
                        pathsOneToN(a1);
                        cyclesLength1toN(a1);
                    }
                    else {
                        System.out.println("Please use Option 1 to enter data first!");
                    }

            }
        }
    }

    //below method simply loops though a 2d array and prints values
    public static void printMatrix(int [][] a1){

        for(int i=0;i<a1.length;i++){
            for(int j=0;j< a1.length;j++){
                System.out.print(a1[i][j] + "\t");      //prints the value at cell [i][j] and formats with tab
            }
            System.out.println();                       //<<endl
        }
    }

    //below method multiplies row of matrix a by column of matrix b for each position of the matrices to generate a final result matrix
    public static int [][] multiplyMatrices(int [][] firstMatrix, int [][] secondMatrix){
        int [][] result = new int[firstMatrix.length][firstMatrix.length];
        for(int i=0;i<firstMatrix.length;i++){                //row
            for(int j=0;j<firstMatrix.length;j++){            //column
                for(int k=0;k<firstMatrix.length;k++){        //does the actual work by moving down matrix a's column, multiplying it by matrix b's row, and cumulatively adding it to result[i][j]
                    result[i][j]+= firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    //below method adds the corresponding values of each matrix and stores the result into the corresponding cell of the result matrix
    public static int [][] addMatrices(int [][] a, int [][] b){
        int [][] result = new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j< a.length;j++){
                result[i][j] = a[i][j] + b[i][j];       //adds the corresponding cells together and stores them in the corresponding cell in result
            }
        }
        return result;
    }

    //prints the sum of each column to represent that nodes in-degree
    public static void printInDegrees(int [][] a1){
        System.out.println("\nIn-degrees: ");
        int temp=0;
        for(int i=0;i< a1.length;i++){
            for(int j=0;j< a1.length;j++){
                temp+= a1[j][i];                    //goes down each column and adds total value
            }
            System.out.println("Node " + (i+1) + " in-degree is " + temp);      //prints that value as the indegree of that node
            temp=0;                                 //resets counter back to 0 for next iteration

        }
    }

    //prints the sum of each row to represent that nodes out-degree
    public static void printOutDegrees(int [][] a1){
        System.out.println("\nOut-degrees: ");
        int temp=0;
        for(int i=0;i< a1.length;i++){
            for(int j=0;j< a1.length;j++){
                temp+= a1[i][j];                    //goes down each row and adds total value
            }
            System.out.println("Node " + (i+1) + " out-degree is " + temp);  //prints that value as the out-degree of that node
            temp=0;                                                         //resets counter back to 0 for next iteration

        }
    }

    //below method sums the diagonal of a given matrix to represent self loops
    public static void printSelfLoops(int [][] a1){
        int selfLoopsCount =0;
        for(int i=0;i< a1.length;i++){
            selfLoopsCount+=a1[i][i];           //adds the diagonal values (value at 0,0 + value at 1,1 + value at 2,2 etc)
        }
        System.out.println("\nTotal number of self-loops: " + selfLoopsCount); //prints total
    }

    //prints numer of loops of size n where n is the length of the matrix
    public static void maxLengthCycles(int [][]a1){
        int [][] largestPossible;   //placeholder for proper matrix (a1-a5)
        //calculates all 5 matrices (a1-a5)
        int[][] a2 = multiplyMatrices(a1,a1);
        int[][] a3 = multiplyMatrices(a1,a2);
        int[][] a4 =multiplyMatrices(a1,a3);
        int[][] a5 = multiplyMatrices(a1,a4);

        switch(a1.length){  //sets largestPossible matrix to proper matrix for calculation
            case 3: largestPossible = a3; break;
            case 4: largestPossible = a4; break;
            case 5: largestPossible = a5; break;
            default:largestPossible=a2;
        }
        int cyclesCount =0;
        for(int i=0;i< a1.length;i++){
            cyclesCount+=largestPossible[i][i];         //this block finds the diagnal of the correct matrix to represent the number of cycles of length n
        }
        System.out.println("Total number of cycles of length " + a1.length + " edges: " + cyclesCount);
    }

    //below method prints the number of paths of length 1 edge by adding all values in a1
    public static void pathsLength1Edge(int [][]a1){
        int count=0;
        for(int i=0;i< a1.length;i++){
            for(int j=0;j< a1.length;j++){
                count+=a1[i][j];
            }
        }
        System.out.println("Total number of paths of length 1 edge: " + count);
    }

    //below method prints out the number of paths of length n where n is the length of the array
    public static void pathsLengthN(int [][] a1){
        int [][] largestPossible;   //placeholder for proper matrix (a1-a5)
        //calculates all 5 matrices (a1-a5)
        int[][] a2 = multiplyMatrices(a1,a1);
        int[][] a3 = multiplyMatrices(a1,a2);
        int[][] a4 =multiplyMatrices(a1,a3);
        int[][] a5 = multiplyMatrices(a1,a4);

        switch(a1.length){  //sets largestPossible matrix to proper matrix for calculation
            case 3: largestPossible = a3; break;
            case 4: largestPossible = a4; break;
            case 5: largestPossible = a5; break;
            default:largestPossible=a2;
        }
        //at this point we have the correct matrix loaded into largestPossible, now add all cells together
        int count=0;
        for(int i=0;i< a1.length;i++){
            for(int j=0;j< a1.length;j++){
                count+=largestPossible[i][j];
            }
        }
        //finally print
        System.out.println("Total number of paths of length " + a1.length + " edges: " + count);
    }
    //below method returns the  number of paths from 1 to n length given n = length of matrix (number of nodes)
    public static void pathsOneToN(int [][] a1){
        int [][] result = getReachabilityMatrix(a1);    //gets reachability matrix
        int count =0;
        for(int i=0;i<a1.length;i++){
            for(int j=0;j<a1.length;j++){
                count+= result[i][j];               //adds all nodes together and stores them in count
            }
        }
        //finally print
        System.out.println("Total number of paths of length 1 to " + a1.length + " edges: " + count);
    }
    //below method print the number of total cycles of length 1 to n where n in the length of the matrix
    public static void cyclesLength1toN(int [][]a1){
        int [][] result = getReachabilityMatrix(a1);
        int count=0;
        for(int i=0;i<a1.length;i++){
            count+= result[i][i];               //adds the diganal of the reachability matrix to get the number of total cycles in the graph
        }
        System.out.println("Total number of paths of cycles of length 1 to " + a1.length + " edges: " + count);
    }
    //below method prints the reachability matrix
    public static void printReachabilityMatrix(int [][] a1){
          //calls method getReachabilityMatrix
        System.out.println("\nReachability Matrix: ");
        printMatrix(getReachabilityMatrix(a1));        // prints the resulting matrix in the right format using the predefined method
    }

    //below method generates the reachability matrix of a given passed in matrix by adding a1+a2....a(n), is seperated from printReachability matrix for calling in other methods where printng is not needed
    public static int [][] getReachabilityMatrix(int [][] a1){

        //calculates all 5 matrices (a1-a5)
        int[][] a2 = multiplyMatrices(a1,a1);
        int[][] a3 = multiplyMatrices(a1,a2);
        int[][] a4 =multiplyMatrices(a1,a3);
        int[][] a5 = multiplyMatrices(a1,a4);
        int [][] reachabilityMatrix = addMatrices(a1,a2);

        switch (a1.length){           //this switch allows for only the necessary matrices to be added to resulting reachability matrix
            case 5:reachabilityMatrix=addMatrices(reachabilityMatrix,a5);
            case 4:reachabilityMatrix= addMatrices(reachabilityMatrix,a4);
            case 3:reachabilityMatrix = addMatrices(reachabilityMatrix,a3);
        }
        return reachabilityMatrix;
    }

}
