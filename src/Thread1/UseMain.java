package Thread1;

import java.sql.SQLOutput;

//Управление осноным потоком
public class UseMain {
    public static void main(String[] args) {
        Thread thread;

        //Получить основной поток
        thread = Thread.currentThread();

        //Отобразить имя основного потока
        System.out.println("Имя основного потока: " + thread.getName());

        //Отобразить приоритет осноного потока
        System.out.println("Приоритет: " + thread.getPriority());

        System.out.println();

        //Установить имя и приоритет основного потока
        System.out.println("Установка имени и приоритета\n");
        thread.setName("Thread #1");
        thread.setPriority(Thread.NORM_PRIORITY+3);

        System.out.println("Новое имя основного потока: " + thread.getName());

        System.out.println("Новое значение приоритета: " + thread.getPriority());
    }
}
