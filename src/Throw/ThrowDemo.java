package Throw;

import java.nio.file.AtomicMoveNotSupportedException;

public class ThrowDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Before operator \"throw\"");
            throw new ArithmeticException();
        } catch (ArithmeticException exc) {
            //Intercept exception
            System.out.println("Exception was intercepted");
        }
        System.out.println("After the block try/catch");
    }
}
