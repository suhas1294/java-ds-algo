package com.atreya._10_disjoint_set;

import com.atreya._11_graph._04_sssp._00_nodes.WeightedNode;

import java.util.ArrayList;

public class DisjointSetMain {

    public static void main(String[] args) {

        // Constructor for ArrayList
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        // create 10 nodes: 1-10
        for (int i = 0; i < 10; i++) {
            nodeList.add(new WeightedNode("" + (char) (65 + i)));
        }

        // Calling DisjointSet
        DisjointSet.driver(nodeList);

    }// end of method
}