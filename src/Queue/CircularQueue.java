package Queue;

//Кольцевая очередь
class CircularQueue implements ICharQ {
    private char[] q; //массив для хранения элементов очереди
    private int inputCharIndex, outputCharIndex; // индексы вставляемых и извлекаемых элементов

    //Создать пустую очередь заданного размера
    public CircularQueue(int size) {
        q = new char[size + 1]; // выделить память для очереди
        inputCharIndex = outputCharIndex = 0;
    }

    //Поместить символ в очередь
    @Override
    public void put(char ch) {
        /* Очередь считается полной, если индекс putloc на единицу
        меньше индекса getloc или если индекс putloc указывает
        на конец массива, а индекс getloc - на его начало */
        if (inputCharIndex + 1 == outputCharIndex |
                ((inputCharIndex == q.length - 1) && (outputCharIndex == 0))) {
            System.out.println(" - Очередь заполнена");
            return;
        }

        inputCharIndex++;
        if (inputCharIndex == q.length) inputCharIndex = 0; //перейти в начало массива
        q[inputCharIndex] = ch;
    }

    //Извлечь символ из очереди
    @Override
    public char get() {
        if (outputCharIndex == inputCharIndex) {
            System.out.println(" - Очередь пуста");
            return (char) 0;
        }

        outputCharIndex++;
        if (outputCharIndex == q.length) outputCharIndex = 0;//вернуться в начало очереди
        return q[outputCharIndex];
    }
}
//{'F','E',0}
//inputCharIndex = 1