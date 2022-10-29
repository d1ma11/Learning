package Thread1;

public class SumArray {
    private int sum;

    synchronized int sumArray(int[] nums) {
        sum = 0;

        for (int num : nums) {
            sum += num;
            System.out.println("Текущее значение суммы для " +
                    Thread.currentThread().getName() +
                    ": " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        }
        return sum;
    }
}

class MyThreadSynchronized implements Runnable {
    Thread thread;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    MyThreadSynchronized(String name, int[] nums) {
        thread = new Thread(this, name);
        a = nums;
        thread.start();
    }

    public void run() {
        int sum;

        System.out.println(thread.getName() + " - запуск");

        answer = sa.sumArray(a);
        System.out.println("СУММА для " + thread.getName() +
                ": " + answer);

        System.out.println(thread.getName() + " - завершение");
    }
}

class Sync {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        MyThreadSynchronized myThread1 = new MyThreadSynchronized("Child #1", a);
        MyThreadSynchronized myThread2 = new MyThreadSynchronized("Child #2", a);
    }
}
