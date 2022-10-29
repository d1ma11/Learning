package Generics.Queue;

// Исключение, указывающее на переполнение
class QueueFullException extends Exception {
    int size;

    QueueFullException(int s) {
        size = s;
    }

    @Override
    public String toString() {
        return "Очередь заполнена. Максимальный размер очереди: " + size;
    }
}

// Исключение, указывающее на исчерпание очереди
class QueueEmptyException extends Exception {

    @Override
    public String toString() {
        return "\nОчередь пуста";
    }
}