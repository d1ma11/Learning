package LambdaExpressions;

import java.io.*;

interface MyIOAction {
    boolean ioAction(Reader rdr) throws IOException;
}

public class LambdaExceptionDemo {
    public static void main(String[] args) {
        double[] values = {1.0, 2.0, 3.0, 4.0};

        // Данное блочное лябмда-выражение может генерировать
        // исключение IOException. Следовательно, это исключение
        // должно быть указано в операторе throws метода
        // ioAction() функционального интерфейса MyIOAction
        MyIOAction myIO = rdr -> {
            int ch = rdr.read(); // может генерировать исключение IOException

            //...
            return true;
        };
    }
}
