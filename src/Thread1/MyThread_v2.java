package Thread1;

class MyThread_v2 implements Runnable {
    private final Thread trhd;

    MyThread_v2(String name) {
        trhd = new Thread(this, name);
        trhd.start();
    }


    @Override
    public void run() {
        System.out.println(trhd.getName() + " - запуск");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(1000);
                System.out.println("B " + trhd.getName() +
                        ", счетчик: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(trhd.getName() + " - прерван");
        }
        System.out.println(trhd.getName() + " - завершение");
    }
}

class UseThreadsImproved {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        // Создание объекта типа MyThread, формирование потока на основе этого
        // объекта и запуск этого потока
        MyThread_v2 mt = new MyThread_v2("Child #1");

        for (int i = 0; i < 110; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");
    }
}
