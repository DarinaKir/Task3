import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        int[] firstArray = creatArray(arraySize("first"));
        int[] secondArray = creatArray(arraySize("second"));
        System.out.println("The position (index) of the number whose level of proximity is the highest is : " + indexOfTheHighestLevelNumber(firstArray, secondArray));
    }
    public static int sumOfDigits (int number){
        int sum = 0;
        if (number<10){
            sum = number;
        }else {
            sum = (number%10) + sumOfDigits(number/10);
        }
        return sum;
    }
    public static int proximityLevel (int number, int [] array){
        int brothersNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if(sumOfDigits(number)==sumOfDigits(array[i])){
                brothersNumber++;
            }
        }
        return brothersNumber;
    }

    public static int indexOfTheHighestLevelNumber (int [] arr1, int [] arr2){
        int index =0;
        for (int i = 1; i < arr1.length; i++) {
            if (proximityLevel(arr1[index],arr2 ) < proximityLevel(arr1[i],arr2 )){
                index = i;
            }
        }
        return index;
    }

    public static int[] creatArray (int size){
        Scanner scanner = new Scanner(System.in);
        int [] array = new int[size];
        for (int i = 0; i < size; i++) {
            do {
                System.out.println("Type a positive number : (index = "+i+")" );
                array[i]= scanner.nextInt();
            }while (array[i]<0);
        }
        return array;
    }

    public static int arraySize (String arrayName){
        Scanner scanner = new Scanner(System.in);
        int size = -1;
        while (size<=0){
            System.out.println("How many numbers do you want to type in the "+arrayName+" array ? (a positive number)");
            size =scanner.nextInt();
        }
        return size;
    }
}
