import java.util.Arrays;

public class midtermPractice {

    public static void main(String[]args){

        int [] array = {5,7,3,9,34,8,6,45,65,7,87,3};  //12 elements
        int [] array2 = {12, 27, 41, 45, 49, 62, 66, 70, 72, 80, 81, 99};  //12 elements
        int [] array3 = { 56, 59, 55, 46, 96, 70, 13, 63, 69, 17, 72, 28};  //12 elements
       insertionSort(array3) ;
        System.out.println(Arrays.toString(array3));
    }

    public static int[] bubbleSort(int [] array){
        int counter =0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                counter++;
                if(array[j] > array[j+1]){
                    int temp = array[j];  counter++;
                    array[j]= array[j+1];  counter++;
                    array[j+1] = temp;  counter++;
                }
            }
        }
        System.out.println("total runs = " + counter);
        return array;
    }

    public static int[] selectionSort(int [] array){
        int counter =0;
        int smallestIndex=0;counter++;
        for(int i=0;i<array.length;i++){
            smallestIndex=i;
            for(int j=i;j<array.length;j++){

                counter++;
                if(array[smallestIndex]>array[j]){
                    smallestIndex=j;  counter++;
                }
            }
            int temp = array[i];  counter++;
            array[i] = array[smallestIndex];  counter++;
            array[smallestIndex] = temp;  counter++;
        }
        System.out.println("total runs = " +counter);
        return array;
    }
    public static int[] insertionSort(int [] array){
       int counter=0;
        for(int j=1;j<array.length;j++){
            for(int i=0;i<j;i++){
                counter++;
                if(array[i] > array[j]){
                    int temp = array[i];counter++;
                    array[i] = array[j];counter++;
                    array[j] = temp;counter++;
                }
            }
        }
        System.out.println("total runs = " +counter);
        return array;

    }
}
