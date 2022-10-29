package Generics;
//Простой обобщенный класс с двумя параметрами

public class TwoGen<T, V> {
    T ob1;
    V ob2;

    //Передать конструктору класса ссылки на объекты типов T и V
    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    //Отобразить типы T и V
    void showTypes() {
        System.out.println("Тип Т - это " + ob1.getClass().getName());
        System.out.println("Тип V - это " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

//Демонстрация класса TwoGen
class SimpGen {
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj = new TwoGen<Integer,String>(99,"Generics");

        tgObj.showTypes();

        int v = tgObj.getOb1();
        System.out.println("Значение: " + v);
        String str = tgObj.getOb2();
        System.out.println("Значение: " + str);
    }
}
