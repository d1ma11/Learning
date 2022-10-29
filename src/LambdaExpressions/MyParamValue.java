package LambdaExpressions;

interface MyValue {
    double getValue();
}

interface MyParamValue {
    double getValue(double v);
}

class LambdaDemo {
    public static void main(String[] args) {
        MyValue myValue; // объявление ссылки на интерфейс

        /*
        Здесь лямбда-выражение - это просто константа.
        При его назначении переменной myValue создается
        экземпляр класса, в котором лямбда-выражение
        реализует метод getValue() интерфейса MyValue
         */
        myValue = () -> 98.6;

        //Вызвать метод getValue(), предоставляемый ранее
        // назначенным лямбда-выражением
        System.out.println("Постоянное значение: " + myValue.getValue());

        // Создать параметризованное лямбда-выражение и назначить его
        // ссылке на экземпляр MyParamValue. Это лямбда-выражение
        // возвращает обратную величину своего аргумента.
        MyParamValue myParamValue = (n) -> 1.0 / n;

        // Вызвать метод getValue(v) посредством ссылки myParamValue
        System.out.println("Обратная величина 4 равна " + myParamValue.getValue(4.0));
        System.out.println("Обратная величина 8 равна " + myParamValue.getValue(8.0));

        // Лямбда-выражение должно быть совместимым с методом,
        // который определяется функциональным интерфейсом. Поэтому
        // приведенные ниже два фрагмента кода не будут работать.
        // myVal = () -> "three"; // Ошибка! Тип String несовместим
        // с типом douЬle!
        // myParamValue = () -> Math.random(); // Ошибка! Требуется параметр!
        System.out.println(myParamValue.getValue(15.0));
    }
}