package com.csc;

class Chainlink<T> {
    private T data;
    private Chainlink<T> next;

    public Chainlink(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Chainlink<T> getNext() {
        return next;
    }

    public void setNext(Chainlink<T> next) {
        this.next = next;
    }
}

public class chain<T> {
    private Chainlink<T> head;

    public chain() {
        this.head = null;
    }

    public void append(T data) {
        Chainlink<T> newLink = new Chainlink<>(data);
        if (head == null) {
            head = newLink;
        } else {
            Chainlink<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newLink);
        }
    }

    public void prepend(T data) {
        Chainlink<T> newLink = new Chainlink<>(data);
        if (head == null) {
            head = newLink;
        } else {
            newLink.setNext(head);
            head = newLink;
        }
    }

    public T view(int index) {
        Chainlink<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.getData();
            }
            count++;
            current = current.getNext();
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public int countRemainingLinks(Chainlink<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        
        int count = 0;
        Chainlink<T> current = node.getNext();
        
        while (current != null) {
            count++;
            current = current.getNext();
        }
        
        return count;
    }
}
