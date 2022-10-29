package Thread1;
//Использование синхронизированного блока
//для управления доступом к методу sumArray()
public class SumArray2 {
    private int sum;

    int sumArray(int[] nums) {
        sum = 0;

        for(int num : nums) {
            sum += num;
            System.out.println("Текущее значение суммы для " +
                    Thread.currentThread().getName() +
                    ": " + sum);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        }
        return sum;
    }
}

class MyThread2 implements Runnable {
    Thread thread;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    MyThread2(String name, int[] nums) {
        thread = new Thread(this,name);
        a = nums;
        thread.start();
    }

    public void run() {
        int sum;
        System.out.println(thread.getName() + " - запуск");

        synchronized (sa) {
            answer = sa.sumArray(a);
        }

        System.out.println(thread.getName() + " - завершение");

    }
}

class Sync2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        MyThread2 myThread1 = new MyThread2("Thread1",a);
        MyThread2 myThread2 = new MyThread2("Thread2",a);

        try {
            myThread1.thread.join();
            myThread2.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока");
        }
    }
}
