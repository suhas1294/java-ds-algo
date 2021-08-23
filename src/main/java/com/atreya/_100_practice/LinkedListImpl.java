package com.atreya._100_practice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LinkedListImpl {
    Node head;
    Node tail;
    int size;

    @Setter
    @Getter
    @NoArgsConstructor
    class Node{
        int value;
        Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public LinkedListImpl(){
        Node node = new Node();
        node.setNext(null);
        head = node;
        tail = node;
    }

    public LinkedListImpl(int data){
        Node current = new Node(data);
        current.setNext(null);
        this.head = current;
        this.tail = current;
        this.size = this.getSize()+1;
    }

    public void addToStart(int data){
        Node newNode = new Node(data);
        // if node is being added to empty linked list
        if(this.size == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        this.setSize(this.getSize()+1);
    }

    public void addToEnd(int data){
        Node newNode = new Node(data);
        if(this.size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
        }
        this.setSize(this.getSize()+1);
    }

    public void addToPosition(int data, int index){
        if (index < 0 || index > this.getSize()) throw new RuntimeException("Index out of bound");
        if (index == this.getSize()){
            addToEnd(data);
            return;
        }else if(index == 0){
            addToStart(data);
            return;
        }else{
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            this.setSize(this.getSize()+1);
        }
    }

    public int searchForElement(int targetElement){
        Node current = head;
        for (int i = 0; i < this.getSize(); i++) {
            if (current.getValue() == targetElement) return i;
            current = current.getNext();
        }
        return -1;
    }

    public void deleteElement(int targetNumber){
        int targetElementIndex = searchForElement(targetNumber);
        if(targetElementIndex == -1) throw new RuntimeException("No such element found");
        Node current = head;
        for (int i = 0; i < targetElementIndex - 1; i++) {
            current = current.getNext();
        }
        System.out.printf("Warning! deleting %d in list\n", current.getNext().getValue());
        current.setNext(current.getNext().getNext());
        this.setSize(this.getSize()-1);
    }

    public void deleteByIndex(int targetNumberIndex){
        if (targetNumberIndex < 0 || targetNumberIndex > this.getSize()) throw new RuntimeException("invalid index");
        Node current = head;
        for (int i = 0; i < targetNumberIndex - 1; i++) {
            current = current.getNext();
        }
        System.out.printf("[delete by index] Warning! deleting index %d in list\n", targetNumberIndex);
        current.setNext(current.getNext().getNext());
        this.setSize(this.getSize()-1);
    }

    public void deleteEntireLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void printLL(){
        Node current = this.getHead();
        if (current == null) throw new RuntimeException("Linked list not found/deleted!");
        for (int i = 0; i < this.getSize(); i++) {
            System.out.print(current.getValue() + "\t");
            if(current.getNext() != null) System.out.print("->\t");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl(30);
        /*LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addToStart(30);*/
        linkedList.printLL();

        linkedList.addToStart(40);
        linkedList.addToStart(50);
        linkedList.printLL();

        linkedList.addToEnd(100);
        linkedList.printLL();

        linkedList.addToPosition(777, 2);
        linkedList.printLL();

        linkedList.addToPosition(33, linkedList.getSize());
        linkedList.printLL();

        int resultIndex = linkedList.searchForElement(30);
        System.out.printf("Result found in index no %d\n", resultIndex);

        linkedList.deleteElement(30);
        linkedList.printLL();

        linkedList.deleteByIndex(3);
        linkedList.printLL();

        linkedList.deleteEntireLinkedList();
        //linkedList.printLL();
    }
}