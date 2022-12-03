import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().trim();
        String [] elements = string.split(" ");
        if(elements.length > 3 | elements.length < 3){
            throw new IllegalStateException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int numb1 = 0;
        int numb2 = 0;
        boolean rimTarg = false;
        int arabicResult;
        String rimResult = "o";

        try {
            numb1 = Integer.parseInt(elements[0].trim());
            numb2 = Integer.parseInt(elements[2].trim());
            } catch (NumberFormatException e){

            }

        Rim[] rims = Rim.values();
        for (Rim rim1 : rims) {
            if (rim1.toString().equals(elements[0])) {
                for (Rim rim2 : rims) {
                    if (rim2.toString().equals(elements[2])) {
                        numb1 = rim1.arabicValue();
                        numb2 = rim2.arabicValue();
                        rimTarg = true;
                    }
                }
            }
        }

//        System.out.println(numb1);
//        System.out.println(numb2);





        switch (elements[1]){
                case "+":
                arabicResult = numb1 + numb2;
                break;
            case "-":
                arabicResult = numb1 - numb2;
                break;
            case "/":

                arabicResult = numb1 / numb2;
                break;
            case "*":
                arabicResult = numb1 * numb2;
                break;
            default:
                throw new IllegalStateException("Неверный знак математического действия");
        }


        if (rimTarg) {
            if (arabicResult == 100) {
                rimResult = "C";
            } else if (arabicResult >= 50) {
                if (arabicResult % 10 >= 5 & arabicResult % 10 < 9) {
                    rimResult = "L" + "X".repeat(arabicResult % 50 / 10) + "V" + "I".repeat(arabicResult % 10 - 5);
                } else {
                    rimResult = "O";
                }
            }
            System.out.println(rimResult);
        } else {
            System.out.println(arabicResult);
        }
    }
}
