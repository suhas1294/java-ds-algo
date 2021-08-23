package com.atreya._100_practice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;

public class DoublyLinkedListFP {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedListFP(){
        Node node = new Node();
        node.next = null;
        head = node;
        tail = node;
    }

    @NoArgsConstructor
    class Node{
        int value;
        Node prev;
        Node next;

        public Node(int data){
            this.value = data;
        }
    }

    public void initEmptyLLWithData(Node newNode){
        newNode.prev = null;
        newNode.next = null;
        head = newNode;
        tail = newNode;
    }

    public void addToStart(int data){
        Node newNode = new Node(data);
        if(this.size == 0){
            initEmptyLLWithData(newNode);
        }else{
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    public void addToEnd(int data){
        Node newNode = new Node(data);
        if(this.size == 0){
            initEmptyLLWithData(newNode);
        }else{
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    public void addElement(int data, int index){
        if(index == 0){
            addToStart(data);
        }else if(index == this.size){
            addToEnd(data);
        }else if(index> this.size+1 || index < 0){
            throw new RuntimeException("invalid index");
        }else{
            Node newNode = new Node(data);
            Node curent = this.head;
            for (int i = 0; i < index-1; i++) {
                curent = curent.next;
            }
            newNode.next = curent.next;
            curent.next.prev = newNode;
            newNode.prev = curent;
            curent.next = newNode;
            this.size++;
        }
    }

    public void printDoublyLL(){
        Node current = this.head;
        if (current == null) throw new RuntimeException("Linked list not found/deleted!");
        for (int i = 0; i < this.size; i++) {
            System.out.print(current.value + "\t");
            if(current.next != null) System.out.print("<-->\t");
            current = current.next;
        }
        System.out.println();
    }

    public int search(int targetElement) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> forwardResult =  service.submit(() -> {
            Node current = this.head;
            for (int i = 0; i < this.size/2; i++) {
                if (current.value == targetElement)return i;
                current = current.next;
            }
            return null;
        });
        Future<Integer> backwardResult =  service.submit(() -> {
            Node current = this.tail;
            for (int i = this.size; i > this.size/2 ; i--) {
                if(current.value == targetElement) return i;
                current = current.prev;
            }
            return null;
        });
        Integer result1 = forwardResult.get();
        Integer result2 = backwardResult.get();
        service.shutdown();
        if (result1 == null && result2 == null) return -1;
        return Optional.ofNullable(result1).orElse(result2);
    }

    public static DoublyLinkedListFP listFactory(){
        DoublyLinkedListFP list = new DoublyLinkedListFP();
        for (int i = 0; i < 100; i++) {
            list.addToStart(new Random().nextInt(100));
        }
        list.printDoublyLL();
        return list;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DoublyLinkedListFP list = new DoublyLinkedListFP();
        list.addToStart(30);
        list.addToStart(40);
        list.addToStart(50);
        list.printDoublyLL();
        list.addToEnd(100);
        list.printDoublyLL();
        list.addElement(777, 2);
        list.printDoublyLL();

        int searchIndex = listFactory().search(34);
        if(searchIndex == -1) throw new RuntimeException("Result not found");
        System.out.printf("Result found at index position: %d", searchIndex);
    }

}
