package test;

public class Main {
    public static void main(String[] args) {
        Test test = new Test(new int[]{12, 5, 3, 6,8, 4 ,2,4});
  //      System.out.println(Test.pow(2,4));
        System.out.println("Сумма двух чисел" + " = " + Test.sum(4));
        System.out.println("Произведение двух чисел" + " = " + Test.multiplication(5,6));
        System.out.println("Факториал числа  n = " + Test.factorial(4));
        Test.printing(4);
        System.out.println("========================");
        Test.reversePrinting(4);
 //       System.out.println(test.get(true));
    }
}
