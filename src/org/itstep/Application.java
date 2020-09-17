package org.itstep;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 1. Побитовые операции: &, |, ^, ~, <<, >>, >>>
        /*
            Бинарное И (&)

            1 & 3 -> 1

              0001
            &
              0011
              ----
              0001
         */
        byte a = 1;
        byte b = 3;
        byte c = (byte) (a & b);
        System.out.println("a & b = " + a + " & " + b + " = " + c);
        System.out.println(bin(a));
        System.out.println("&");
        System.out.println(bin(b));
        System.out.println("--------");
        System.out.println(bin(c));

        /*
            Бинарное ИЛИ (|)

            1 | 3 -> 3

              0001
            |
              0011
              ----
              0011
         */
        c = (byte) (a | b);
        System.out.println("\na | b = " + a + " | " + b + " = " + c);
        System.out.println(bin(a));
        System.out.println("|");
        System.out.println(bin(b));
        System.out.println("--------");
        System.out.println(bin(c));

        /*
            Бинарное исключающее ИЛИ (^)

            1 ^ 3 -> 2

              0001
            ^
              0011
              ----
              0010
         */
        c = (byte) (a ^ b);
        System.out.println("\na ^ b = " + a + " ^ " + b + " = " + c);
        System.out.println(bin(a));
        System.out.println("^");
        System.out.println(bin(b));
        System.out.println("--------");
        System.out.println(bin(c));

        /*
            Инверсия бит (~)

            ~1 -> -2
         */
        c = (byte) (~a);
        System.out.println("\n~a = ~" + a + " = " + c);
        System.out.println("~" + bin(a) + " = " + bin(c));

        /*
            Смещение влево <<
            1 << 1 -> 2
            2 << 1 -> 4

            0001 << 1 -> 0010
            0010 << 1 -> 0100
         */
        c = (byte) (a << 1);
        System.out.println("a << 1 = " + a + " << 1 = " + c);
        System.out.println("a << 1 = " + bin(a) + " << 1 = " + bin(c));

        /*
            Смещение вправо >>
            4 >> 1 -> 2
            2 >> 1 -> 1
         */
        c = (byte) (2 >> 1);
        System.out.println("2 >> 1 = " + c);
        System.out.println("2 >> 1 = " + bin((byte) 2) + " >> 1 = " + bin(c));

        /*
           Сдвиг вправо с заполнением нулями

           -1 >>> 24 -> 255
         */
        System.out.println(Integer.toBinaryString(-1) + " >> 24 = " + Integer.toBinaryString(-1 >>> 24) + " = " + (-1 >>> 24));

        // 2. Логические операции: >, <, >=, <=, ==, !=
        //                         &&, ||, !
        System.out.println("\n\nЛогические операции");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a > b -> " + (a > b));
        System.out.println("a >= b -> " + (a >= b));
        System.out.println("a < b -> " + (a < b));
        System.out.println("a <= b -> " + (a <= b));
        System.out.println("a == b -> " + (a == b));
        System.out.println("a != b ->" + (a != b));

        boolean equals = a == b;
        int age = 12;
        boolean haveCinema = age >= 18;

        float weight = 3.3f;// | -1 | -> 1, | 1 | -> 1
        System.out.println(Math.abs(weight - 3.3) < 0.00001); // Math.abs(-1) -> 1

        /*
            Логическое И
            true  && true  -> true
            true  && false -> false
            false && false -> false

            Логическое ИЛИ
            true  || true  -> true
            true  || false -> true
            false || false -> false

            Логическое НЕ
            ! true  -> false
            ! false -> true
         */
        // work 9..18
        //
        //  --------- 9 ////////////////////// 18 ----------
        //                            ^15
        int hour = 19;
        boolean isWorkTime = (hour >= 9) && (hour <= 18);
        System.out.println("isWorkTime: " + isWorkTime);

        // not work 0 .. 9, 18 .. 24
        //
        //  //////////////// 9 ------------------- 18 ///////////////////
        //                                               ^19
        boolean isNotWorkTime = !isWorkTime;// (hour < 9) || (hour > 18);
        System.out.println("isNotWorkTime = " + isNotWorkTime);


        // 3. Условия:
        //      if, if..else, if .. else if ... else
        //      switch
        //age = 18;
        if (age >= 18) {
            System.out.println("Добро пожаловать в кино для взрослых");
        } else {
            System.out.println("У нас для вас есть интересные мультфильмы");
        }

        Random rnd = new Random();
        int r = rnd.nextInt(3); // 0..2
        Scanner scanner = new Scanner(System.in);
        System.out.print("Угадайте число [0..3): ");
        int guess = Integer.parseInt(scanner.nextLine());
        if (r < guess) {
            System.out.println("Загаданное число меньше");
        } else if (r > guess) {
            System.out.println("Загаданное число больше");
        } else {
            System.out.println("Ты угадал!");
        }

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        /*if(login.equals("admin")) {
            System.out.println("Добро пожаловать админ");
        } else if(login.equals("user")) {
            System.out.println("Добро пожаловать пользователь");
        } else if(login.equals("guess")) {
            System.out.println("Добро пожаловать гость");
        } else {
            System.out.println("Кто ты?");
        }*/
        switch (login) {
            case "admin":
                System.out.println("Добро пожаловать админ");
                break;
            case "user":
                System.out.println("Добро пожаловать пользователь");
                break;
            case "guess":
                System.out.println("Добро пожаловать гость");
                break;
            default:
                System.out.println("Кто ты?");
                break;
        }

        // 4. Тернарный оператор:
        //      <условие> ? <выражение 1> : <выражение 2>

        double sum = 1200;
        // t >= 1000 - скидка 10%, ИНАЧЕ - 5%
//        if(sum >= 1000) {
//            discount = sum * 0.1;
//        } else {
//            discount = sum * 0.05;
//        }
        double discount = (sum >= 1000) ? sum * 0.1 : sum * 0.05;
        System.out.println("Sum: " + (sum - discount));

    }

    static String bin(byte a) {
        return String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
    }
}
