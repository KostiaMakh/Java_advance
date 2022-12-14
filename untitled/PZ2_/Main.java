import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        //Ввести с консоли n-размерность матрицы а [п][п].
        // Задать значения элементов матрицы в интервале значений от -п до п с помощью датчика случайных чисел.
        // Task: Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы значения их характеристик убывали.

        Scanner in = new Scanner(System.in);
        System.out.print("Set matrix size: ");
        int matrix_size = in.nextInt();

        if (matrix_size < 2 | matrix_size > 20){
            System.err.println("Wrong matrix size! Matrix size may be in range 2-20");
        }
        int[][] matrix = buildMatrix(matrix_size);

        System.out.println("Initial matrix");
        printMatrix(matrix);
        HashMap<Integer, Integer> columns_weight;
        columns_weight = calcMatrixColumns(matrix);
        int [] sorted_columns_weight;
        sorted_columns_weight = sortArray(columns_weight);

        int[][] sorted_matrix = new int[matrix_size][matrix_size];
        sorted_matrix = sortMatrix(columns_weight, matrix, sorted_columns_weight);

        System.out.println("\nSorted matrix");
        printMatrix(sorted_matrix);
    }

    public static HashMap<Integer, Integer> calcMatrixColumns(int[][] matrix){
        HashMap<Integer, Integer> columns_weight = new HashMap<>();
        int [] columns_values = new int[matrix.length];
        for (int col = 0; col < matrix.length; col++) {
            int sum = 0;
            for (int row = 0; row < matrix[col].length; row++) {
                sum += matrix[row][col];
            }
            columns_values[col] = sum;
            columns_weight.put(sum, col);
        }

        System.out.println("\nColumns weight");
        printRow(columns_values);

        return columns_weight;
    }

    public static void printMatrix(int[][] array){
        for (int[] ints : array) {
            printRow(ints);
        }
    }

    public static void printRow(int[] row){
        System.out.print('[');
        for (int col = 0; col < row.length; col++){
            if (col == 0){
                String el_str = String.valueOf(row[col]);
                System.out.printf("%5s" , el_str + ",");
            }
            else if (col == row.length-1){
                System.out.printf("%6s%-1s" , row[col], "");
            }
            else{
                String el_str = String.valueOf(row[col]);
                System.out.printf("%6s" , el_str + ",");
            }
        }
        System.out.println(']');
    }

    public static int[][] buildMatrix(int size){
        int counter = 0;
        int[][] matrix = new int[size][size];
        while (counter < size){
            int row_el = 0;
            while (row_el < size){
                matrix[counter][row_el] = ThreadLocalRandom.current().nextInt(-size, size);
                row_el++;
            }
            counter++;
        }

        return matrix;
    }

    public static int[] sortArray(HashMap<Integer, Integer> arr_in) {
        int[] arr = arr_in.keySet().stream().mapToInt(i -> i).toArray();
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        System.out.println("\nSorted columns weight");
        printRow(arr);

        return arr;
    }

    public static int[][] sortMatrix(
            HashMap<Integer, Integer> ordering_map,
            int[][] matrix,
            int[] ordering_list
            ){
        int matrix_size = ordering_list.length;
        int [][] ordered_matrix = new int[matrix_size][matrix_size];
        for (int col = 0; col < matrix_size; col++){
            int col_sum = ordering_list[col];
            int col_number = ordering_map.get(col_sum);
            for (int row = 0; row < matrix_size; row++){
                ordered_matrix[row][col] = matrix[row][col_number];
            }
        }
        return ordered_matrix;
    }
    }
