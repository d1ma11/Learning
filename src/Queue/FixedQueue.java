package Queue;

//Класс, реализующий очередь фиксированного размера
//для хранения символов
class FixedQueue implements ICharQ {
    private char[] q; //массив для хранения очереди
    private int putloc, getloc; //индексы вставляемых и извлекаемых элементов

    //Создать пустую очередь заданного размера
    public FixedQueue(int size) {
        q = new char[size + 1]; //выделить память для очереди
        putloc = getloc = 0;
    }

    @Override
    //Поместить символ в очередь
    public void put(char ch) {
        if (putloc == q.length - 1) {
            System.out.println(" - Очередь заполнена");
            return;
        }
        putloc++;
        q[putloc] = ch;
    }

    @Override
    //Извлечь символ из очереди
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста");
            return (char) 0;
        }
        getloc++;
        return q[getloc];
    }
}