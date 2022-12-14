import java.util.Scanner;

public class Main {

//    4. Осуществить сжатие английского текста, заменив каждую группу из двух или более рядом стоящих символов
//    на один символ, за которым следует количество его вхождений в группу.
//    К примеру, строка hellowoooorld должна сжиматься в hel2owo4rld.
//
//    5. Распаковать текст, сжатый по правилу из предыдущего задания.

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Set initial text: ");
        String text = in.nextLine();
        System.out.println(String.format("Length = %d symbols;", text.length()));

        System.out.println("\nZipped text:");
        String coded = zip(text);
        System.out.println(coded);
        System.out.println(String.format("Length = %d symbols;", coded.length()));
        String uncoded = unzip(coded);
        System.out.println("\nUnzipped text:");
        System.out.println(uncoded);
        System.out.println(String.format("Length = %d symbols;", uncoded.length()));
    }

    public static String unzip(String text){
        char[] result = text.toCharArray();
        StringBuilder newText = new StringBuilder();
        StringBuilder counter = new StringBuilder();
        char repeatedEl;
        for (int x = 0; x < result.length; x++){
            if (x==0){
                newText.append(result[x]);
            }
            else {
                if (!Character.isDigit(result[x])){
                    newText.append(result[x]);
                }
                else {
                    counter.append(result[x]);
                    if(x < result.length-1){
                        if (!Character.isDigit(result[x+1])){
                            int n = Integer.parseInt(counter.toString());
                            while (n > 1){
                                newText.append(result[x-counter.length()]);
                                n--;
                            }
                            counter.setLength(0);
                        }
                    }
                    else {
                        int n = Integer.parseInt(counter.toString());
                        while (n > 1){
                            newText.append(result[x-counter.length()]);
                            n--;
                        }
                        counter.setLength(0);
                    }
                }
            }
        }
        return newText.toString();
    }


    public static String zip(String text){
        char[] result = text.toCharArray();
        StringBuilder newText = new StringBuilder();
        int counter = 1;
        for (int x = 0; x < result.length; x++){
            if (x==0){
                newText.append(result[x]);
            }
            else {
                if(result[x]==result[x-1]){
                    counter += 1;
                }
                else if (result[x-1] != result[x] && counter > 1){
                    newText.append(counter);
                    newText.append(result[x]);
                    counter = 1;
                }
                else {
                    newText.append(result[x]);
                }
            }
        }
        if (counter > 1){
            newText.append(counter);
        }
        return newText.toString();
    }
}