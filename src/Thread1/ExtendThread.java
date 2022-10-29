package Thread1;

public class ExtendThread extends Thread{
    // Создать новый поток
    ExtendThread(String name) {
        super(name); // присовить имя потоку
        start(); // запустить поток
    }

    // Начать выполнение нового потока
    @Override
    public void run() {
        System.out.println(getName() + " - запуск");
        try {
            for(int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("B " + getName() +
                        ", счетчик: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(getName() + " - прерван");
        }
        System.out.println(getName() + " - завершение");
    }
}

class UseExtendThread {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        ExtendThread mt = new ExtendThread("Thread #1");

        for(int i = 0;i<50;i++){
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
