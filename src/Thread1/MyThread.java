package Thread1;

public class MyThread implements Runnable {
    String thrdName;

    MyThread(String name) {
        thrdName = name;
    }


    @Override
    public void run() {
        System.out.println(thrdName + " - запуск");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(1000);
                System.out.println("B " + thrdName +
                        ", счетчик: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + " - прерван");
        }
        System.out.println(thrdName + " - завершение");
    }
}

class UseThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        // Сначала создать объект типа MyThread
        MyThread mt = new MyThread("Child #1");

        // Затем сформировать поток на основе этого объекта
        Thread newThrd = new Thread(mt);

        // Начать выполнение потока
        newThrd.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(".");
            try {
                Thread.sleep(400);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");
    }
}
