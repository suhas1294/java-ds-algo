package com.atreya._11_graph._06_mst._01_kruskal;

import com.atreya._10_disjoint_set.DisjointSet;
import com.atreya._11_graph._04_sssp._00_nodes.WeightedNode;
import com.atreya._11_graph._06_mst.UndirectedEdge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }


    // Kruskal algo
    void kruskal() {
        // make disjoint sets for each node
        DisjointSet.makeSet(nodeList);

        // sort the edges in ascending order
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };
        Collections.sort(edgeList, comparator);

        int cost = 0;
        for (UndirectedEdge edge : edgeList) {
            WeightedNode first = edge.getFirst();
            WeightedNode second = edge.getSecond();
            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.union(first, second);
                cost += edge.getWeight();
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("\nTotal cost of MST: " + cost);
    }


    // add a weighted undirected edge between two nodes
    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex - 1), nodeList.get(secondIndex - 1), weight);
        WeightedNode first = edge.getFirst();
        WeightedNode second = edge.getSecond();
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
        first.getWeightMap().put(second, weight);
        second.getWeightMap().put(first, weight);
        edgeList.add(edge);
    }
}