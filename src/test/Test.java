package test;
// создать конструктор который получает два целочисленных аргумента
// и добавляет их значения в свойства num1 и num2

// создать метод max, который возвращает максимальное из этих двух
public class Test {
    public int[] list;

    public Test(int[] list) {
        this.list = list;
    }

    public int max() {
        int result = this.list[0];
        for (int elem : this.list) {
            if (result < elem) {
                result = elem;
            }

            return elem;
        }
        // добавить метод min, который возвращает минимальное значение
        for (int elem : this.list) {
            if (result > elem) {
                result = elem;
            }
        }
        return result;
    }

    // создать метод get который если получает в качестве аргумента true возвращает максимальное
// а если false, то минимальное
    public int get(boolean type) {
        int result = this.list[0];
        for (int elem : this.list) {
            if (result < elem == type) {
                result = elem;
            }
        }
        return result;
    }

    public static int pow(int base, int exp) {
        if (exp == 1) {
            return base;
        }
        System.out.println(base);
        return base * pow(base * base, exp - 1);
    }


    // Homework 31
// 1. Напишите рекурсивный метод для вычисления суммы чисел от 1 до n. n надо получить через аргументы.
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    //  2.    Реализуйте метод, который умножает два числа с использованием рекурсии
    public static int multiplication(int a,int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return a + multiplication(a, b-1);
        }
    }

    //  3. Напишите рекурсивный метод для вычисления факториала числа.
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // 4.    Напишите рекурсивный метод для печати чисел от 1 до n. n надо получить через аргументы.
    public static void printing(int n) {
        if (n > 0) {
            printing(n - 1);
            System.out.println("Печать чисел от 1 до n" + " == " + n);
        }
    }

    //  5.   Напишите рекурсивный метод для печати чисел от n до 1. n надо получить через аргументы.
    public static void reversePrinting(int n) {
        if (n > 0) {
            System.out.println("Печать чисел от n до 1" + " == " + n);
            reversePrinting(n-1);

        }
    }
}








        

    
