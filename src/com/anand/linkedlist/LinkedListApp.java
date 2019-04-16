package com.anand.linkedlist;

class Link {
    private int data;
    private Link next;

    int getData() {
        return data;
    }

    void setData(int data) {
        this.data = data;
    }

    Link getNext() {
        return next;
    }

    void setNext(Link next) {
        this.next = next;
    }
}

class LinkedList {
    private Link first;

    Link getFirst() {
        return first;
    }

    void setFirst(Link first) {
        this.first = first;
    }
}

public class LinkedListApp {

    private static LinkedList linkedList = new LinkedList();

    private static void insertInSortedList(int key) {
        Link newLink = new Link();
        newLink.setData(key);

        Link current = linkedList.getFirst();
        Link previous = null;

        while (current.getNext() != null && current.getData() <= key) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) { //means we're at the beginning of the list
            linkedList.setFirst(newLink); //in this case, current is the first reference
        } else {
            previous.setNext(newLink);
        }
        newLink.setNext(current);
        System.out.println("done");
    }

    static Link insertNodeAtPosition(int data, int position) {
        Link head = linkedList.getFirst();
        Link newNode = new Link();
        newNode.setData(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Link current = head, previous = null;
        int index = 0;
        while (index != position) {
            previous = current;
            current = current.getNext();
            index++;
        }
        if (previous == null) {
            head = newNode;
        } else {
            previous.setNext(newNode);
        }
        newNode.setNext(current);
        return head;
    }

    public static void main(String[] args) {
        Link firstNode = new Link();
        firstNode.setData(1);
        Link secondNode = new Link();
        secondNode.setData(5);

        firstNode.setNext(secondNode);

        linkedList.setFirst(firstNode);

        insertInSortedList(3);
        insertNodeAtPosition(4, 2);
    }
}
