import java.util.Scanner;

public class Main {
    // Вівести четные и нечетные числа
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Set numbers quantity: ");
        int num = in.nextInt();
        int[] numbers = new int[num];
        int counter = 0;
        while (counter < num){
            int val = in.nextInt();
            numbers[counter] = val;
            counter++;
        }

        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println("Even - " + number);
            }
            else{
                System.out.println("Odd - " + number);
            }

        }
    }
}