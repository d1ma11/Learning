package Generics;

public class Pair<T, V extends T> {
    T first;
    V second;

    Pair(T a, V b) {
        first = a;
        second = b;
    }

    //...
}

class PairDemo {
    // Эта строка кода верна, поскольку Т и V имеют тип Integer
    Pair<Integer, Integer> х = new Pair<Integer, Integer>(1, 2);

    // И эта строка кода верна, так как Integer - подкласс Number
    Pair<Number, Integer> у= new Pair<Number, Integer>(10.4, 12);
}
