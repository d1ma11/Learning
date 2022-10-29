package ThreadOrganization;

//Использование методов wait() и notify() для имитации часов
class TickTock {
    private String state; //содержит свдения о состоянии часов

    synchronized void tick(boolean running) {
        if (!running) { //остановить часы
            state = "ticked";
            notify(); //уведомить ожидающие потоки
            return;
        }

        System.out.print("Tick ");

        state = "ticked"; // установить текущее состояние после такта "тик"

        notify(); //позволить выполняться методу tock()
        try {
            while (!state.equals("tocked"))
                wait(); //ожидать до завершения метода tock()
        } catch (InterruptedException exc) {
            System.out.println("Прерывание потока");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) { //остановить часы
            state = "tocked";
            notify(); // уведомить ожидающие потоки
            return;
        }

        System.out.println("Tock");

        state = "tocked"; //установить текущее состояние после такта "так"

        notify(); //позволить выполняться методу tick()
        try {
            while (!state.equals("ticked"))
                wait(); //ожидать до завершения метода tick()
        } catch (InterruptedException exc) {
            System.out.println("Прерывание потока");
        }
    }
}

class MyThread implements Runnable {
    Thread thrd;
    TickTock ttOb;

    //Создать новый поток
    MyThread(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
        thrd.start();
    }

    //Начать выполнение нового потока
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++)
                ttOb.tick(true);
            ttOb.tick(false);

        } else {
            for (int i = 0; i < 5; i++)
                ttOb.tick(true);
            ttOb.tock(false);
        }
    }
}

class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread mt1 = new MyThread("Tick", tt);
        MyThread mt2 = new MyThread("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока");
        }
    }
}
