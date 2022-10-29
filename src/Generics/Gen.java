package Generics;

/**
 * Простой обобщенный класс.
 * Здесь Т - это параметр типа, вместо которого
 * при создании объекта класса Gen будет подставляться
 * реально существующий тип
 * @param <T>
 */
class Gen<T> {
    T ob; // объявить объект типа Т

    // Передать конструктору ссылку на объект типа Т
    Gen(T o) {
        ob = o;
    }

    // Вернуть объект ob из метода
    T getOb() {
        return ob;
    }

    //Отобразить тип Т
    void showType() {
        System.out.println("Тип Т - это " + ob.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        //Создать ссылку на объект типа Gen<Integer>
        Gen<Integer> iOb;

        //Создать объект типа Gen<Integer> и присвоить ссылку на
        //него переменной iOb. Обратите внимание на автоупаковку при
        //инкапсуляции значения 88 в объекте типа Integer
        iOb = new Gen<Integer>(88);

        //Отобразить тип данных, используемых в объекте iOb
        iOb.showType();

        //Получить значения из объекта iOb. Обратите внимание
        //на то, что приведение типов здесь не требуется
        int v = iOb.getOb();
        System.out.println("Значение: " + v);

        System.out.println();

        //Создать объект типа en ля строк
        Gen<String> strOb = new Gen<String>("Тестирование обобщений");

        //Отобразить тип данных, используемых в объекте strOb
        strOb.showType();

        //Получить значение из объекта strOb
        //Заметьте, что приведение типов здесь также не требуется
        String str = strOb.getOb();
        System.out.println("Значение: " + str);
    }
}
