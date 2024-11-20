package com.csc;

class ChainLink {
    private String data;
    private ChainLink next;

    public ChainLink(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public ChainLink getNext() {
        return next;
    }

    public void setNext(ChainLink next) {
        this.next = next;
    }
}

public class chain {
    private ChainLink head;

    public chain() {
        this.head = null;
    }

    public void append(String data) {
        ChainLink newLink = new ChainLink(data);
        if (head == null) {
            head = newLink;
        } else {
            ChainLink current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newLink);
        }
    }

    public String view(int index) {
        ChainLink current = head;
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
}
