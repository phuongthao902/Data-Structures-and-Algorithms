class Queue {
    private int maxSize;
    private String[] queueArray;
    private int front;
    private int rear;
    private int nItems;
    public Queue(int size) {
        maxSize = size;
        queueArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert(String j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = j;
        nItems++;
    }
    public String remove() {
        String temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }
    public boolean isFull() {
        return (nItems == maxSize);
    }
    public boolean isEmpty() {
        return (nItems == 0);
    }
}