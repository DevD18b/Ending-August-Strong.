package Implementations;

import java.util.*;
import java.util.LinkedList;

public class StackUsingQueue {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public StackUsingQueue() {
    }

    public void add(int data) {
        queue1.add(data);
    }

    public int pop() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.offer(queue1.remove());
        }
        int element = queue1.remove();
        for (int i = 0; i < size - 1; i++) {
            queue1.offer(queue2.remove());
        }
        return element;
    }

    public int peek() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.add(queue1.remove());
        }
        int element = queue1.peek();
        queue2.add(queue1.remove());

        for (int i = 0; i < size; i++) {
            queue1.offer((queue2.remove()));
        }
        return element;
    }

    public boolean isEmpty() {
        return queue1.size() == 0;
    }

}
