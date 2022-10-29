package Generics;

/**
 * Класс NumericFns как пример неудачной попытки создать
 * обобщенный класс для выполнения различных математических
 * опереаций, включая получение обратной величины или
 * извлечение дробной части числовых значений любого типа
 * Решение:
 * Аргументов типа, заменяющим параметр типа Т, должен стать класс Number
 * или производный от него подкласс, как показано ниже
 */
public class NumericFns<T extends Number> {
    T num;

    // Передать конструктору ссылку на числовой объект
    NumericFns(T n) {
        num = n;
    }

    // Вернуть обратную величину
    double reciprocal() {
        return 1 / num.doubleValue();
    }

    // Вернуть дробную часть
    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    // Проверить равенство абсолютных значений двух объектов
    boolean absEqual(NumericFns<?> ob) {
        return Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue());
    }
}

class BoundsDemo {
    public static void main(String[] args) {
        NumericFns<Integer> iOb = new NumericFns<>(5);

        System.out.println("Обратная величина iOb - " + iOb.reciprocal());
        System.out.println("Дробная часть iOb - " + iOb.fraction());
        System.out.println();

        NumericFns<Double> dOb = new NumericFns<>(5.25);

        System.out.println("Обратная величина dOb - " + dOb.reciprocal());
        System.out.println("Дробная часть dOb - " + dOb.fraction());

    }
}

class WildcardDemo {
    public static void main(String[] args) {
        NumericFns<Integer> iOb = new NumericFns<>(6);

        NumericFns<Double> dOb = new NumericFns<>(-6.0);

        NumericFns<Long> lOb = new NumericFns<>(-5L);

        System.out.println("Сравнение iOb и dOb");
        if(iOb.absEqual(dOb))
            System.out.println("Абсолютные значения совпадают");
        else
            System.out.println("Абсолютные значения отличаются");

        System.out.println();

        System.out.println("Сравнение iOb и lOb");
        if(iOb.absEqual(lOb))
            System.out.println("Абсолютные значения совпадают");
        else
            System.out.println("Абсолютные значения отличаются");
    }
}