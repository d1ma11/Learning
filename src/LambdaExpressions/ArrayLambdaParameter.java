package LambdaExpressions;

/*
 * Функциональный интерфейс, который может использоваться
 * для применения некоторого преобразования к элементам массива
 */
interface MyTransform<T> {
    void transform(T[] a);
}

public class ArrayLambdaParameter {
    public static void main(String[] args) {

        Double[] values = {1.0, 2.0, 3.0, 4.0};

        /*
        Здесь типом параметра а метода transform() является тип Double[],
        поскольку при объявлениии лямбды sqrts для интерфейса MyTransform задан
        тип Double. Поэтому тип v в лямбда-выражении выводится как Double[].

        Использовать для этой цели запис v[] было бы не только излишне, но и неправильно
         */
        MyTransform<Double> sqrts = v -> {
            for (int i = 0; i < v.length; i++)
                v[i] = Math.sqrt(v[i]);
        };

        sqrts.transform(values);

        for (Double elem : values) {
            System.out.println(elem);
        };
    }
}
