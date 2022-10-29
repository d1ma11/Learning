package LambdaExpressions;

@FunctionalInterface
interface StringFunc {
    String func(String str);
}

public class LambdaArgumentDemo {

    // В данном методе типом первого параметра является
    // функциональный интерфейс. Следовательно, ему можно передать
    // ссылку на любой экземпляр этого интерфейса, в том числе и на
    // экземпляр, созданный посредством лямбда-выражения. С помощью
    // второго параметра задается строка, подлежащая обработке.
    static String changeStr(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямда-выражения расширяют Java";
        String outStr;

        System.out.println("Входная строка: " + inStr);

        // Определите лямбда-выражение, располагающее содержимое
        // строки в обратном порядке, и присвойте его переменной,
        // ссылающейся на экземпляр StringFunc
        StringFunc reverse = (str) -> {
            StringBuilder result = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }

            return result.toString();
        };

        // Передайте reverse методу changeStr() в качестве
        // первого аргумента.
        // Передайте входную строку в качестве второго аргумент.
        outStr = changeStr(reverse, inStr);
        System.out.println("Обращенная строка: " + outStr);

        // Данное лямбда-выражение заменяет пробелы дефисами
        // Оно внедряется непосредственно в вызов метода changeStr()
        outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
        System.out.println("Строка с замененными пробелами: " + outStr);

        // Данное блочное лямбда-выражение обращает регистр
        // букв в строке. Оно также внедряется непосредственно
        // в вызов метода changeStr()
        outStr = changeStr((str) -> {
            StringBuilder result = new StringBuilder();
            char ch;

            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch))
                    result.append(Character.toLowerCase(ch));
                else
                    result.append(Character.toUpperCase(ch));
            }
            return result.toString();
        }, inStr);
        System.out.println("СТрока с обращенным регистром букв: " + outStr);
    }
}
