// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ Idea
import java.util.Scanner;

public class MyTestBST {
    public static void main(String[]args){
        int userChoice=11; String dataType=""; boolean treeTypeInteger=false; boolean treeTypeSet=false;  BST<Integer> iTree = new BST<>();  BST<String> sTree = new BST<>();
        Scanner sc = new Scanner(System.in);
                                                /* ^Setup objects and variables^ */
        while(userChoice!=10){                  //while user has not selected exit
            System.out.println("""


                    0. Enter Tree Data Type (integer or string)
                    1. Insert Data Element
                    2. Delete Data Element
                    3. Search for Data Element
                    4. Print Tree Size
                    5. Path from Root to Data Element
                    6. Check if Empty Tree
                    7. Print Preorder Traversal
                    8. Print Inorder Traversal
                    9. Print Postorder Traversal
                    10. Exit program
                     Enter option number:""");
                    userChoice=sc.nextInt();                                 //reading users input

                    if(!treeTypeSet && userChoice>0 && userChoice!=10){
                        System.out.print("Please select option 0 first to set Tree Data Type");         //force to enter 0
                        userChoice=11;
                    }

                    switch(userChoice){                                                              //switchng user input
                        case 0: System.out.print("Enter DataType for tree: ('integer' or 'string') ");
                        sc.nextLine();
                        dataType = sc.nextLine();                                                   //setting data type for tree
                        if(!dataType.equals("string") && !dataType.equals("integer")) {             //checking if user entered either choice correctly
                            System.out.println("Invalid input, must type 'integer' or 'string'");
                        }
                        else {
                            if (dataType.equals("integer")) {                                  //checks if integer was enterd
                                treeTypeInteger = true;                                         //sets boolean to true
                            }
                            treeTypeSet=true;                                                         //if so, true, else false
                        }


                        break;

                        case 1:
                            System.out.print("Enter data element to add to tree:");
                            if(treeTypeInteger){                                          //checks if int or string, code block for int
                                int data = sc.nextInt(); sc.nextLine();

                                System.out.print("\nTesting method Insert Data Element (Option 1)\nBST before inserting " + data + " (Inorder):"); iTree.inorder();
                                iTree.insert(data);
                                System.out.print("\nBST after inserting "+data+" (Inorder): "); iTree.inorder();
                            }
                            else {                                                            //same block but for string
                                sc.nextLine();
                                String data = sc.nextLine();

                                System.out.print("\nTesting method Insert Data Element (Option 1)\nBST before inserting "+data+" (Inorder): "); sTree.inorder();
                                sTree.insert(data);
                                System.out.print("\nBST after inserting "+data+" (Inorder): "); sTree.inorder();
                            }


                        break;

                        case 2:

                                System.out.println("Enter the data element to be removed");
                                if (treeTypeInteger){                                                  //checks if int or string, code block for int
                                    int data = sc.nextInt();
                                    System.out.print("Testing method Delete Data Element (Option 2)\n" +
                                            "BST before deleting "+ data + " (Inorder): "); iTree.inorder();
                                            iTree.delete(data);
                                            System.out.print("\nBST after deleting "+data+" (Inorder): "); iTree.inorder();
                                }
                                else{
                                    sc.nextLine();                                                    //same block but for string
                                    String data = sc.nextLine();
                                    System.out.print("Testing method Delete Data Element (Option 2)\n" +
                                            "BST before deleting "+ data + " (Inorder): "); sTree.inorder();
                                    sTree.delete(data);
                                    System.out.print("\nBST after deleting "+data+" (Inorder): "); sTree.inorder();
                                }

                            break;

                        case 3:

                                System.out.println("Enter a value to search:");
                                if (treeTypeInteger) {                                               //checks if int or string, code block for int
                                    int data = sc.nextInt();
                                    System.out.print("Testing method Search for Data Element (Option 3)\n" +
                                            "Search for " + data + "? ");
                                    System.out.print(iTree.search(data));

                                } else {                                                                  //same block but for string
                                    sc.nextLine();
                                    String data = sc.nextLine();
                                    System.out.print("Testing method Search for Data Element (Option 3)\n" +
                                            "Search for " + data + "? ");
                                    System.out.print(sTree.search(data));
                                }

                            break;

                        case 4:
                                System.out.print("Testing method Tree size (Option 4)\n");                //checks if int or string, code block for int
                                    if(treeTypeInteger) {   System.out.print("Tree size: "+ iTree.size);}
                                    else{System.out.print("Tree size:  " + sTree.size);}


                            break;

                        case 5:
                            System.out.print("Enter data element to generate path for:  ");
                            if(treeTypeInteger){                                                      //checks if int or string, code block for int
                                int data = sc.nextInt();
                                System.out.print("Testing method Path from Root to Data Element (Option 5)\n" +
                                        "Path from root to "+data+": "); java.util.ArrayList<BST.TreeNode<Integer>> path = iTree.path(data);
                                for (int i = 0; path != null && i < path.size(); i++)
                                    System.out.print(path.get(i).element + " ");
                            }
                            else{sc.nextLine();                                                       //same block but for string
                                String data = sc.nextLine();
                                System.out.print("Testing method Path from Root to Data Element (Option 5)\n" +
                                        "Path from root to "+data+": ");
                                java.util.ArrayList<BST.TreeNode<String>> path = sTree.path(data);
                                for (int i = 0; path != null && i < path.size(); i++)                   //code from provided TestBST class
                                    System.out.print(path.get(i).element + " ");
                            }

                            break;

                        case 6:
                            System.out.print("Testing method Check if Empty Tree (Option 6)\n");
                            if(treeTypeInteger){                                                 //checks if int or string, code block for int
                                System.out.print("Is empty tree?  "+iTree.isEmpty());
                            }
                            else {                                                               //same block but for string
                                System.out.print("Is empty tree?"+ sTree.isEmpty());
                            }

                            break;

                        case 7:
                            System.out.print("Testing method Preorder Traversal (Option 7)\n");
                            System.out.print("Preorder: ");
                            if(treeTypeInteger){                                     //checks if int or string, code block for int
                                iTree.preorder();
                            }
                            else {                                                   //same block but for string
                                sTree.preorder();
                            }
                            break;

                        case 8:
                            System.out.print("Testing method Inorder Traversal (Option 8)\n");
                            System.out.print("Inorder:  ");
                            if(treeTypeInteger){                              //checks if int or string, code block for int
                                iTree.inorder();
                            }
                            else{                                            //same block but for string
                                sTree.inorder();
                            }
                            break;

                        case 9:
                            System.out.print("Testing method Postorder Traversal (Option 9)\n" +
                                    "Postorder:  ");
                            if(treeTypeInteger){                         //checks if int or string, code block for int
                                iTree.postorder();
                            }
                            else{                                                  //same block but for string
                                sTree.postorder();
                            }
                            break;
                    }

        }
    }

}
