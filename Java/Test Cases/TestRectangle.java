
// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: IntelliJ Idea

import java.util.Scanner;

public class TestRectangle {
    public static void main(String[]args)
    {

        Rectangle myRectangle = new Rectangle();
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter a width for your rectangle: ");
        double width = sc.nextDouble();
        System.out.print("Please enter a height for your rectangle: ");
        double height = sc.nextDouble();

        Rectangle yourRectangle = new Rectangle(width,height);

        System.out.println("\n" +
                "myRectangle:\n" +
                "------------\n" +
                "Width:\t\t"+myRectangle.getWidth()+"\n" +
                "Height:\t\t"+myRectangle.getHeight()+"\n" +
                "Area:\t\t"+myRectangle.getArea()+"\n" +
                "Perimeter:\t"+myRectangle.getPerimeter()+"\n");
        myRectangle.printRectangle("myRectangle");

        System.out.println();



        System.out.println("" +
                "yourRectangle:\n" +
                "------------\n" +
                "Width:\t\t" + yourRectangle.getWidth() +"\n" +
                "Height:\t\t"+yourRectangle.getHeight()+"\n" +
                "Area:\t\t"+yourRectangle.getArea()+ "\n" +
                "Perimeter:\t"+yourRectangle.getPerimeter()+"\n");
        yourRectangle.printRectangle("yourRectangle");

        System.out.println();

        System.out.println("Testing functionality: \n" +
                "Testing method getWidth() on yourRectangle object: " + yourRectangle.getWidth()+"\n" +
                "Testing method getHeight() on yourRectangle object: " + yourRectangle.getHeight()+"\n" +
                "Testing method getArea() on yourRectangle object: " + yourRectangle.getArea()+"\n" +
                "Testing method getPerimeter() on yourRectangle object: " + yourRectangle.getPerimeter()+"\n" +
                "Testing method printRectangle(\"Steve\") on yourRectangle object: " ); yourRectangle.printRectangle("Steve");


    }




}
