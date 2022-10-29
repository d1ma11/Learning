package Generics.Queue;

public class GenQueue<T> implements IGenQ<T> {
    // Массив для хранения элементов очереди
    private T[] q;
    //Индексы вставки и извлечения элементов очереди
    private int putloc, getloc;

    // Создание пустой очереди из заданного массива
    public GenQueue(T[] arrRef) {
        q = arrRef;
        putloc = getloc = 0;
    }

    // Поместить элемент в очередь
    @Override
    public void put(T obj) throws QueueFullException {
        if(putloc == q.length-1)
            throw new QueueFullException(q.length);
        q[putloc++] = obj;
    }

    // Извлечь элемент из очереди
    @Override
    public T get() throws QueueEmptyException {
        if(getloc == putloc)
            throw new QueueEmptyException();
        return q[getloc++];
    }
}
