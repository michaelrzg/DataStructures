public class AVLTree {
    private class Node{
        int data;
        int balanceFactor=0;
        Node Left;
        Node Right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    public void printTree()
    {
        if(root==null){
            System.out.println("Tree in Empty!!");
        }
        else{
        printTree(root);
        }
    }
    private void printTree(Node Current){
        if(Current!=null) {
            printTree(Current.Left);
            System.out.println(Current.data+ "\t" + "Balance Factor: " + getBalanceFactor(Current));
            printTree(Current.Right);
        }


    }

    public void insertNode(int data){
        if(root==null){
            root = new Node(data);
        }
        else{
            insertNode(root,data);
        }

    }
    private void insertNode(Node current,int data) {
       if(current.data>data){
           if(current.Left==null) {
               current.Left = new Node(data);
           }
           else {
               insertNode(current.Left,data);
           }
       }
       else if(current.data<data){
           if(current.Right==null){
               current.Right=new Node(data);
           }
           else {
               insertNode(current.Right,data);
           }
       }
       balanceTree();

    }
    public void balanceTree(){
        balanceTree(root);
    }
    private void balanceTree(Node current){

        if(current!=null){
            switch (getBalanceFactor(current)){
                case -2:
                    if(current.Right!=null){
                        if(getBalanceFactor(current.Right)>=0){
                            RL(current);
                        }
                        else {
                            LL(current);
                        }
                    }
                    break;
                case 2:
                    if(current.Left!=null){
                        if(getBalanceFactor(current.Left) <=-1){
                            LR(current);
                        }
                        else{
                            RR(current);
                        }
                    }
                    break;
            }

        }
        if(current!=null) {
            balanceTree(current.Left);
            balanceTree(current.Right);
        }
    }
    private int getBalanceFactor(Node N){
        return getHeight(N.Left) - getHeight(N.Right);
    }
    private int getHeight(Node n){
        if(n!=null){
           return 1 + Math.max(getHeight(n.Left) , getHeight(n.Right));
        }
        return -1;
    }
    public void LL(Node n){
    Node temp = n.Right;
    if(n.Left!=null) {
        n.Left.Left = new Node(n.data);
    }
    else {
        n.Left = new Node(n.data);
    }
    n.Left.data=n.data;
    n.data = temp.data;
    n.Right = temp.Right;
    if(temp.Left!=null){
        insertNode(temp.Left.data);
    }

    }
    public void RR(Node n){
        Node temp = n.Left;
        if(n.Right!=null) {
            n.Right.Right = new Node(n.data);
        }
        else {
            n.Right = new Node(n.data);
        }
        n.Right.data=n.data;
        n.data = temp.data;
        n.Left = temp.Left;
        if(temp.Right!=null){
            insertNode(temp.Right.data);
        }

    }
    public void RL(Node n){

    }
    public void LR(Node n){
        Node temp = new Node(n.data); Node temp2=null; Node temp3=null; Node temp4=null;

        n.data = n.Left.Right.data;

        if(n.Right!=null){
            temp2=new Node(n.Right.data);
        }

        n.Right=new Node(temp.data);

        if(n.Left.Right.Left!=null){
            temp3= new Node(n.Left.Right.Left.data);
        }
        if(n.Left.Right.Right!=null){
            temp4= new Node(n.Left.Right.Right.data);
        }

        n.Left.Right= null;

        if(temp2!=null){insertNode(temp2.data);}
        if(temp3!=null){insertNode(temp3.data);}
        if(temp4!=null){insertNode(temp4.data);}
    }
}
