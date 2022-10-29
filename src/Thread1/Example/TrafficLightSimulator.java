package Example;// Имитация автоматизированного светофора с использованием
// перечисления

// Цвета светофора
enum TrafficLightColor {
    RED, GREEN, YELLOW
}

// Имитация автоматизированного светофора
public class TrafficLightSimulator implements Runnable{
    private final Thread thrd; // поток для имитации светофора
    private TrafficLightColor tlc; // текущий свет светофора
    boolean stop = false; // для остановки имитации установить в true
    boolean changed = false; // true, есди светофор переключился

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;

        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;

        thrd = new Thread(this);
        thrd.start();
    }

    // Запуск имитации автоматизированного светофора
    @Override
    public void run() {
        while(!stop) {
            try {
                switch (tlc) {
                    case GREEN -> Thread.sleep(10000);
                    case YELLOW -> Thread.sleep(2000);
                    case RED -> Thread.sleep(12000);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }
    }

    // переключение светофора
    synchronized void changeColor() {
        switch (tlc) {
            case RED -> tlc = TrafficLightColor.GREEN;
            case YELLOW -> tlc = TrafficLightColor.RED;
            case GREEN -> tlc = TrafficLightColor.YELLOW;
        }

        changed = true;
        notify(); // уведомить о переключении цвета светофора
    }

    // ожидание переключения светофора
    synchronized void waitForChange() {
        try {
            while(!changed)
                wait();
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    // возврат текущего цвета
    TrafficLightColor getColor() {
        return tlc;
    }

    // прекращение имитации светофора
    void cancel() {
        stop = true;
    }
}
