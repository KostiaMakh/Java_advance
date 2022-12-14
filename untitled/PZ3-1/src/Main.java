import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
//    Определить класс Четырехугольник на плоскости. Определить площадь и периметр четырехугольника.
//    Создать массив/список/множество объектов и подсчитать количество четырехугольников разного типа
//    (квадрат, прямоугольник, ромб, произвольный).
//    Определить для каждой группы наибольший и наименьший по площади (периметру) объект.
    public static void main(String[] args) {
        Rectangle[] figures = new Rectangle[8];
        Rectangle sq1 = new Rectangle(
                10, 10, 10, 10,
                90, 90, 90, 90
        );
        figures[0] = sq1;
        Rectangle sq2 = new Rectangle(
                100, 100, 100, 100,
                90, 90, 90, 90
        );
        figures[1] = sq2;
        Rectangle rt1 = new Rectangle(
                100, 50, 100, 50,
                90, 90, 90, 90
        );
        figures[2] = rt1;
        Rectangle rt2 = new Rectangle(
                100, 500, 100, 500,
                90, 90, 90, 90
        );
        figures[3] = rt2;
        Rectangle rt3 = new Rectangle(100, 500, 100, 500,
                90, 90, 90, 90
        );
        figures[4] = rt3;
        Rectangle tr1 = new Rectangle(
                150, 80, 150, 80,
                120, 60, 120, 60
        );
        figures[5] = tr1;
        Rectangle pr1 = new Rectangle(
                150, 80, 110, 89,
                60, 120, 45, 135
        );
        figures[6] = pr1;
        Rectangle pr2 = new Rectangle(
                190, 50, 110, 843,
                60, 120, 45, 135
        );
        figures[7] = pr2;

        for (Rectangle figure: figures){
            System.out.println("Figure type = " + figure.get_type());
            System.out.println("Perimeter = " + figure.get_perimeter());
            System.out.println("Square = " + figure.get_square());
            System.out.println();
        }

        //  Group figures by type
        List<Rectangle> rums  = get_from_arr_by_type(figures, "Rum");
        List<Rectangle> rectangles = get_from_arr_by_type(figures, "Rectangle");
        List<Rectangle> squares = get_from_arr_by_type(figures, "Square");
        List<Rectangle> other = get_from_arr_by_type(figures, "Other type");

        System.out.println("Squares = " + squares.size());
        System.out.println("Rectangles = " + rectangles.size());
        System.out.println("Rums = " + rums.size());
        System.out.println("Other type = " + other.size());

        // Get min and max perimeter per each type

        System.out.println("\n PERIMETERS");

        Rectangle[] ordered_rectangle = sort_by_perimeter(rectangles);
        print_perimeters_range(ordered_rectangle);

        Rectangle[] ordered_rum = sort_by_perimeter(rums);
        print_perimeters_range(ordered_rum);

        Rectangle[] ordered_square = sort_by_perimeter(squares);
        print_perimeters_range(ordered_square);

        Rectangle[] ordered_other = sort_by_perimeter(other);
        print_perimeters_range(ordered_other);

        System.out.println("\n SQUARES");

        // Get min and max square per each type
        Rectangle[] ordered_rectangle_s = sort_by_square(rectangles);
        print_perimeters_range(ordered_rectangle_s);

        Rectangle[] ordered_rum_s = sort_by_square(rums);
        print_perimeters_range(ordered_rum_s);

        Rectangle[] ordered_square_s = sort_by_square(squares);
        print_perimeters_range(ordered_square_s);
    }

    public static void print_perimeters_range(Rectangle[] arr){
        System.out.println(arr[0].get_type() + " max = " + arr[0].get_perimeter() +
                "; min = " + arr[arr.length-1].get_perimeter());
    }

    public static List<Rectangle> get_from_arr_by_type(Rectangle[] arr, String type){
        List<Rectangle> filtered = new ArrayList<>();
        for (Rectangle figure: arr){
            if (Objects.equals(figure.get_type(), type)){
                filtered.add(figure);
            }
        }
        return filtered;
    }

    public static Rectangle[] sort_by_perimeter(List<Rectangle> arr_in){
        Rectangle[] arr = new Rectangle[arr_in.size()];
        for (int i = 0; i < arr_in.size(); i++) {
            arr[i] = arr_in.get(i);
        }
        int n = arr.length;
        Rectangle temp;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].get_perimeter() < arr[j].get_perimeter()) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static Rectangle[] sort_by_square(List<Rectangle> arr_in){
        Rectangle[] arr = new Rectangle[arr_in.size()];
        for (int i = 0; i < arr_in.size(); i++) {
            arr[i] = arr_in.get(i);
        }
        int n = arr.length;
        Rectangle temp;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].get_square() < arr[j].get_square()) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}