/*
 *  Авторо программы HomeWork_1.java, Son. Дата создания: 05.10.2016
 *  TODO: +Finished home work.
 */

class HomeWork_1 {
    public static void main (String[] args) {
        System.out.println("Hello World!");
        Find_rezult(2,2,8,2);
        Check_int(11,21);
        leapes_Year (840);
    }

    public static void simpl_Vars (String[] args) {
        byte b = 126;
        short sh = -32767;
        int in = 2111222333;
        long lo = 9111222333444555666L;
        float fl = 20.0f;
        double doub = 2020.00d;
        boolean bool = true;
        char ch = 'S';
        final double pi = 3.14d;
    }

    public static int Find_rezult (int a, int b, int c, int d ) {
        int rez = a * (b + (c / d));
        System.out.println("Find_rezult - a * (b + (c / d)) = " + rez);
        return rez;
    }

    public static boolean Check_int (int a, int b) {
        if ( 10 <= a && a <= 20 && 10 <= b && b <= 20 ) {
            System.out.println("a и b находятся в диапазоне 10-20 ");
            return true;
        } else {
            System.out.println("a и b выходят за рамки диапазона 10-20 ");
            return false;
        }

    }

    public static boolean leapes_Year (int year) {
        if ( year%4 == 0 ) {
            if (year%100 == 0) {
                if (year%400 == 0) {
                    System.out.println("Этот високосный год - " + year);
                    return true;
                } else {
                    System.out.println("Этот год не високосный - " + year);
                    return false;
                }
            } else {
                System.out.println("Этот високосный год - " + year);
                return true;
            }

        } else {
            System.out.println("Этот год не високосный - " + year);
            return false;
        }


    }
}
