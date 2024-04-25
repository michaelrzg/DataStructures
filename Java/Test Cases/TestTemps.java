
// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: IntelliJ Idea

import java.util.Scanner;

public class TestTemps
{
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);

        int [] temps = new int [7];

        for(int i=0;i<7;i++)
        {
            System.out.print("Please enter temperatures for day " +i+ " (Monday = 0;Sunday = 6) : " );
            temps[i] = sc.nextInt();
        }

        DailyTemps dailyTemps = new DailyTemps(temps);

        System.out.println("\nFunctionality Testing:\n" + "Testing method setTemp(1,40): (see below)" ); dailyTemps.setTemp(1,40);
        System.out.println("Testing method Freezing(): ");dailyTemps.Freezing();
        System.out.println("Testing method Warmest(): ");dailyTemps.Warmest();
        System.out.println("Testing method printTemps(): \n");dailyTemps.printTemps();


    }
}
