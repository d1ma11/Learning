package Generics.Queue;

public class GenQDemo {
    public static void main(String[] args) {
        // Создать очередь хранения целых чисел
        Integer[] iStore = new Integer[10];
        GenQueue<Integer> queue = new GenQueue<>(iStore);

        Integer iVal;

        System.out.println("Демонстрация очереди чисел типа Integer");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Добавление " + i + " в очередь q");
                queue.put(i); // добавить целочисленное значение в очередь q
            }
        } catch (QueueFullException exception) {
            System.out.println(exception);
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Получение следующего числа типа Integer из очереди queue: ");
                iVal = queue.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exception) {
            System.out.println(exception);
        }
        System.out.println();

        // Создать очередь для хранения чисел с плавающей точкой
        Double dStore[] = new Double[10];
        GenQueue<Double> queue1 = new GenQueue<>(dStore);

        Double dVal;
        System.out.println("Демонстрация очереди чисел типа Double");
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("Добавление " + (double) i / 2 + " в очередь queue1");
                queue1.put((double) i / 2);
            }
        } catch (QueueFullException exception) {
            System.out.println(exception);
        }
        System.out.println();

        try {
            for (int i = 0; i < 12; i++) {
                System.out.print("Получение следующего числа типа Double из очереди queue1: ");
                dVal = queue1.get();
                System.out.println(dVal);
            }
        } catch (QueueEmptyException exception) {
            System.out.println(exception);
        }
    }
}
