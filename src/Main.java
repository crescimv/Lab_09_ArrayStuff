import java.util.Random;
import java.util.Scanner;

public class Main {
    public static double getAverage(int values[]) {
        int sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        double average = sum / 100;
        return average;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        int dataPoints[] = new int[100];
        int sum = 0;
        double average = 0;
        int arraySifter = 0;
        int min = 0;
        int max = 0;

        for (int i=0;i<dataPoints.length;i++) {
            dataPoints[i] = rnd.nextInt(100) + 1; //random number between 1-100
            sum = sum + dataPoints[i]; //adds together all numbers in the array
            average = sum/100;//sum divided by 100(the length of the array)
        }
        for (int point : dataPoints) {
            System.out.printf("%d | ", point); //prints a line divider after each point
        }
        System.out.println("\nThe sum of all the numbers is "+sum);
        System.out.println("The average of all the numbers is "+average);

        /* Takes user input of integer from 1-100.
        * Compares user input to each point in the array.
        * Outputs amount of times it's found in the array */
        int userInput = SafeInput.getRangedInt(input, "Give a number in the range 1-100", 1, 100);
        for (int point : dataPoints) {
            if (point == userInput) {
                arraySifter++;
            }
        }
        System.out.println("The number you inputted: "+userInput+ ", was found "+ arraySifter +" time(s)");

        /* takes user input of integer from 1-100.
        * Compares user input to each point in the array.
        * Calculates position of point in array. */
        int userInput2 = SafeInput.getRangedInt(input, "Give another number in the range 1-100", 1,100);
        for (int point : dataPoints) {
            arraySifter++;
            if (point == userInput2) {
                int pointPosition = arraySifter - 1;
                System.out.println("The value: "+userInput2+" was found at array index position "+pointPosition);
                break;
            } else if (arraySifter == 100){
                System.out.println("The value: "+userInput2+" was not found in the array");
            }
        }
        //calculates min and max of points in the array
        for (int point : dataPoints) {
            if (point < min) {
                min = point;
            }
            if (min == 0) {
                min = min + 1;
            }
        }
        for (int point : dataPoints) {
            if (point > max) {
                max = point;
            }
        }
        System.out.println("The minimum of the array is "+min+" and the maximum of the array is "+max);
        System.out.println("Average of dataPoints is: "+ getAverage(dataPoints));
    }

}