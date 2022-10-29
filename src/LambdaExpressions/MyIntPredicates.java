package LambdaExpressions;
// Демонстрация использования ссылок на статические методы

// Функциональный интерфейс для числовых предикатов, которые
// воздействуют на целочисленные значения
interface IntPredicate {
    boolean test(int n);
}

// Данный класс определяет три статических метода, которые
// проверяют соответсвие целого числа определенным условиям
public class MyIntPredicates {

    // Статический метод, который возвращает true, если
    // заданное чилоа простое
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n / i; i++) {
            if ((n % i) == 0)
                return false;
        }
        return true;
    }

    // Статический метод, который возвращает true, если
    // заданное число четной
    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    // Статический метод, который возвращает true, если
    // заданное число положительное
    static boolean isPositive(int n) {
        return n > 0;
    }
}

class MethodRedDemo {

    // В данном методе типом первого параметра является
    // функциональный интерфейс. Следовательно, ему можно передать
    // ссылку на любой экземпляр этого интерфейса, в том числе и на
    // экземпляр, созданный посредством ссылки на метод
    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String[] args) {
        boolean result;

        result = numTest(MyIntPredicates::isPrime, 17);
        if(result)
            System.out.println("17 - is prime number");

        result = numTest(MyIntPredicates::isEven, 12);
        if(result)
            System.out.println("12 - is even number");

        result = numTest(MyIntPredicates::isPositive, 11);
        if(result)
            System.out.println("11 - is positive number");
    }
}
