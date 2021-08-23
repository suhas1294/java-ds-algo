package com.atreya._03_linkedlist.nodes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DoublyNode {
    private int value;
    private DoublyNode next;
    private DoublyNode prev;
}

