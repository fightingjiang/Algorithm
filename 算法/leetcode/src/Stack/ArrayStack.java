package Stack;

class ArrayStack<T> {
    private Object[] stack;
    private int size;
    /** initialize your data structure here. */
    public ArrayStack() {
        stack = new Object[10];
    }

    public void push(T t) {
        stack[size]=t;
        size++;
    }

    public T pop() {
        T t = null;
        t=(T)stack[size-1];
        size--;
        return t;
    }

    public T top() {
        T t = null;
        t=(T)stack[size-1];
        return t;
    }

    public int getMin() {
        return  0;
    }
}