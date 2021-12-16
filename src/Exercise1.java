import java.util.Scanner;
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("How many numbers do you want to type?");
        int arraySize = typeAPositiveNumber();
        int [] numbersArray = new int[arraySize];
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println("( index =  "+i+" )");
            numbersArray[i]=typeAPositiveNumber();
        }
        System.out.println("Location (index) of a alternating number whose sum of digits is the smallest : "+ indexOfAlternatingNumber(numbersArray));
    }

    public static boolean isAlternatingNumber(int number){
        boolean alternatingNumber = false;
        if (number <= 10 && number>=0){
            alternatingNumber =true;
        }else if ( ( ((number%100)/10)+(number%10) )%2 != 0) {
            alternatingNumber = isAlternatingNumber(number / 10);
        }
        return alternatingNumber;
    }

    public static int indexOfAlternatingNumber (int [] numbersArray){
        int index = -1;
        int digitsSum = -1;
        for (int i = 0; i < numbersArray.length; i++) {
            if (isAlternatingNumber(numbersArray[i]) && (digitsSum > sumOfDigits(numbersArray[i]) || digitsSum==-1)) {
                digitsSum = sumOfDigits(numbersArray[i]);
                index = i;
            }
        }
        return index;
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

    public static int typeAPositiveNumber (){
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        do {
            System.out.println("Enter a positive number :");
            number = scanner.nextInt();
        }while (number<0);
        return number;
    }
}
