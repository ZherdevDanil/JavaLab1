package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 1505%2 = 1 => Операція О1 = "-"
 * 1505%3 = 2 => константа С = 2
 * 1505%5 = 0 => операція О2 = "*"
 * 1505%7 = 0 => тип індексів i та j "byte"
 * */

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double S = 0;
        final int C = 2;
        byte n, m , a , b;
        //цикл для отримання та переірки даних
        do {
            n = getValidByteVariable(scanner, "Enter n");

            m = getValidByteVariable(scanner, "Enter m");

            a = getValidByteVariable(scanner, "Enter a");

            b = getValidByteVariable(scanner, "Enter b");
        }while (!isInputDataValid(n,m,a,b,C));
        System.out.println("Data is correct");

        //Рохрахунок функції
        for (byte i = a; i <= n; i++){
            for (byte j = b; j <= m; j++) {
                S += (i * j) / (double)(i - C);
            }
        }
        System.out.println("value of S = " + S);
    }
    //Метод повертає валідне значення типу byte
    private static byte getValidByteVariable(Scanner scanner,String message){
        byte result =0;
        boolean isValid;
        //запуск циклу
        do {
            //вивід повідомлення
            System.out.println(message);
            try{
                //вводимо byte змінну, якщо вона валідна переходимо до while де while(!true) закінчує виконання циклу,
                // та метод повертає валідне byte result
                result = scanner.nextByte();
                isValid = true;

                //якщо виникає помилка
            }catch (InputMismatchException exception){
                //якщо result не валідний, виводиться повідомлення про помилку та while(!false) цикл продовжує працювати,
                //поки не буде введено коректне значення result
                System.out.println("Value must be in diapason from -127 to 128\nPlease change the value ");
                //scanner.next();
                isValid = false;
            }
        }while (!isValid);
        return result;
    }

    //Метод повертає boolean значення, чи валідні наші дані, відносно нашої задача,
    private static boolean isInputDataValid(byte n,byte m,byte a, byte b , int C){
        boolean isValid;
        if (a > n || b > m ) {
            System.out.println("Value n and m must be more than values of a and b\nPlease change the values");
            isValid = false;
        }else if(a<=C && n>=C) {
            System.out.println("ERROR! Division by zero");
            isValid = false;
        }
        else {
            isValid = true;
        }
        return isValid;
    }
}