package hw8_20001976;

import hw8_20001976.graph.Edge;
import hw8_20001976.graph.UndirectedUnweightedGraph;
import hw8_20001976.graph.Vertex;


public class UugTest {
    public static void main(String[] args) {
        UndirectedUnweightedGraph<String, String> uug = new UndirectedUnweightedGraph<>();
        Vertex<String> a = uug.insertVertex("a");
        Vertex<String> b = uug.insertVertex("b");
        Vertex<String> c = uug.insertVertex("c");
        Vertex<String> d = uug.insertVertex("d");
        Edge<String> ab = uug.insertEdge(a, b, "ab");
        Edge<String> cd = uug.insertEdge(c, d, "cd");
        Edge<String> ad = uug.insertEdge(a, d, "ad");
        System.out.println("So dinh cua do thi la: " + uug.numVertices());
        System.out.println("So canh cua do thi la: " + uug.numEdges());
        System.out.println("Bac cua dinh a la: " + uug.outDegree(a));
        System.out.println("Bac cua do thi la: " + uug.deg());
        if (uug.getEdge(a, b) != null)
            System.out.println("Ton tai canh noi dinh a va b");
        else System.out.println("Khong ton tai canh noi dinh a va b");
        if (uug.getEdge(c, b) != null)
            System.out.println("Ton tai canh noi dinh c va b");
        else System.out.println("Khong ton tai canh noi dinh c va b");
        System.out.println("Cac canh ke dinh a:");
        for (Edge<String> edge : uug.outgoingEdges(a)) {
            System.out.println("- " + edge.getValue());
        }
        System.out.println("Cac dinh ke dinh a:");
        for (Vertex<String> vertex : uug.linked(a)) {
            System.out.println("- " + vertex.getValue());
        }
        System.out.println("Remove test a");
        uug.removeVertex(a);
        try {
            System.out.println("Cac canh ke dinh a:");
            for (Edge<String> edge : uug.outgoingEdges(a)) {
                System.out.println("- " + edge.getValue());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        uug.removeEdge(cd);
        System.out.println("Remove test cd: " + uug.getEdge(c, d));
    }
}
