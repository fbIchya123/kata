import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().trim();
        String [] elements = string.split(" ");
        if(elements.length > 3 | elements.length < 3){
            throw new IllegalStateException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int numb1 = -1;
        int numb2 = -1;
        boolean rimTarg = false;
        int arabicResult;
        String result = "";
        String rimResult = "";




        Rim[] rims = Rim.values();
        int arRims[] = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] someRims = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
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

        try {
            if ((Integer.parseInt(elements[0]) < 1 || Integer.parseInt(elements[2]) < 1) || (Integer.parseInt(elements[0]) > 10 || Integer.parseInt(elements[2]) > 10)){
                throw new NumberFormatException("На вход принимаются числа от 1 до 10(от I до X) включительно");
            } else {
                numb1 = Integer.parseInt(elements[0].trim());
                numb2 = Integer.parseInt(elements[2].trim());
            }
        } catch (NumberFormatException e){

        }


        if (numb1 < 0 && numb2 < 0) {
            throw new NumberFormatException("Используются одновременно разные системы счисления");
        }


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

            for (int numb : arRims) {
                result += arabicResult / numb;
                arabicResult = arabicResult % numb;
            }



            int i = 0;
            for (String let : result.split("")) {
                int x = Integer.parseInt(let);
                rimResult += someRims[i].repeat(x);
                x %= arRims[i];
                i++;
            }
            System.out.print(rimResult);
        } else {
            System.out.println(arabicResult);
        }
    }
}
