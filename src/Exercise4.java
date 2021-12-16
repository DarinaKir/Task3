import java.util.Scanner;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = -1;
        while (size<=0){
            System.out.println("How many numbers do you want to type in the array ? (a positive number)");
            size =scanner.nextInt();
        }
        int [] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Type a positive number : (index = "+i+")" );
            array[i]= scanner.nextInt();
        }
        System.out.println("Is the array full ? => "+isFullArray(array));
    }

    public static boolean isFullArray (int[] array){
        boolean arrayIsFull = !areThereDuplicates(array);
        if (arrayIsFull){
            for (int i = 1; i < array.length; i++) {
                int numberToChek = array[i];
                for (int j = 0; j < i; j++) {
                    if (array[j] < numberToChek){
                        int number = array[j];
                        array[j] = numberToChek;
                        numberToChek = number;
                    }
                }
                array[i] = numberToChek;
            }
            arrayIsFull=isFullArrayIfOrganized(array);
        }
        return arrayIsFull;
    }

    public static boolean isFullArrayIfOrganized (int[] organizedArray){
        boolean isFull = true;
        for (int i = 0; i < organizedArray.length-1; i++) {
            if (organizedArray[i]-1 != organizedArray[i+1]){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public static boolean areThereDuplicates (int [] array){
        boolean isDuplicates = false;
        for (int i = 0; i < array.length && !(isDuplicates); i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (array[i]==array[j]){
                    isDuplicates = true;
                    break;
                }
            }
        }
        return isDuplicates;
    }
}
