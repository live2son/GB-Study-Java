/**
 * Авторо программы - HomeWork_2, СергейЯ. Дата создания: 10.10.16г
 */

import java.util.Arrays;
import java.util.Scanner;

class HomeWork_2 {

    public static void main(String args[]){
        InversNums(Arreay_example());
        FillArray ();
        UpLowSix ();
        FindMinMax ();
        SimpleCalc ();

    }

    static int[] Arreay_example () {
        int arr[] = { 0, 1, 0, 0, 1, 0, 1, 1, 0, 1 };
        return arr;
    }

    static void InversNums (int[] arr) {
        System.out.println("Массив до обработки -\t\t"+Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) arr[i] = ( arr[i] == 0 ) ? 1 : 0 ;
        System.out.println("Массив полсе обработки -\t"+Arrays.toString(arr));
    }

    static void FillArray () {
        int FillArr[] = new int[8];
        for ( int i=0, j=1; i < 8; i++, j+=3)  FillArr[i] = j;
        System.out.println("Массив заполнен -\t"+Arrays.toString(FillArr));
    }

    static void UpLowSix () {
        int arr[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i] ;
        System.out.println("Элементы меньше 6 найдены и помножены на 2 -\t"+Arrays.toString(arr));
    }

    static void FindMinMax () {
        int arr[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int Min,Max;
        Min=Max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Min < arr[i]) Min = arr[i];
            if (Max > arr[i]) Max = arr[i];
        }
        System.out.println("Найдены максимум/минимум масива -\t" + Max + " / " + Min);
    }

    static void SimpleCalc () {
        System.out.println("Простой калькулятор, поддерживающий операции - +,-,*,/. \n Введите арифметическое выражение с элеметами разделенными пробелами, пример - 1 + 1 ");
        Scanner sc = new Scanner(System.in); // создание сканера
        int a = sc.nextInt();                // чтение целого числа(int)
        String Oper = sc.next();               // чтение вида операции
        int b = sc.nextInt();                // чтение целого числа(int)
        switch (Oper) {
            case "-":  System.out.println(" Результат : " + (a - b));
                break;
            case "+":  System.out.println(" Результат : " + (a + b));
                break;
            case "*":  System.out.println(" Результат : " + (a * b));
                break;
            case "/":  System.out.println(" Результат : " + (a / b));
                break;
            default:   System.out.println(" Ошибка выбора операции!");
        }
    }
    
}
