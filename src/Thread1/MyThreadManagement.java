package Thread1;
// Приостановка, возобновление и остановка потока
public class MyThreadManagement implements Runnable {
    Thread thread;

    volatile boolean suspended;
    volatile boolean stopped;

    MyThreadManagement(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
        thread.start();
    }

    //Точка входа в поток
    @Override
    public void run() {
        System.out.println(thread.getName() + " - запуск");
        try {
            for(int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if((i%10)==0){
                    System.out.println();
                    Thread.sleep(100);
                }
                synchronized (this) {
                    while(suspended) {
                        wait();
                    }
                    if(stopped) break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " - прерван");
        }
        System.out.println(thread.getName() + " - выход");
    }

    //Остановить поток
    synchronized void myStop() {
        stopped = true;

        //Следующие операторы обеспечивают полную
        //остановку приостановленного потока
        suspended = false;
        notify();
    }

    //Приостановить поток
    synchronized void mySuspend(){
        suspended = true;
    }

    //Возобновить поток
    synchronized void myResume() {
        suspended = false;
        notify();
    }
}

class Suspend {
    public static void main(String[] args) {
        MyThreadManagement ob1 = new MyThreadManagement("My Thread");

        try {
            Thread.sleep(1000); // позволить потоку начать выполнение

            ob1.mySuspend();
            System.out.println("Приостановка потока");
            Thread.sleep(1000);

            ob1.myResume();
            System.out.println("Возобновление потока");
            Thread.sleep(1000);

            ob1.mySuspend();
            System.out.println("Приостановка потока");
            Thread.sleep(1000);

            ob1.myResume();
            System.out.println("Возобновление потока");
            Thread.sleep(1000);

            ob1.mySuspend();
            System.out.println("Остановка потока");
            ob1.myStop();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }

        //Ожидать завершение потока
        try {
            ob1.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }

        System.out.println("Выход из основного потока");
    }
}
//431