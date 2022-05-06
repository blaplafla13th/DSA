package hw8_20001976;

import hw8_20001976.graph.DirectedWeightedGraph;
import hw8_20001976.graph.Edge;
import hw8_20001976.graph.Vertex;


public class DwgTest {
    public static void main(String[] args) {
        DirectedWeightedGraph<String, String> dwg = new DirectedWeightedGraph<>();
        Vertex<String> a = dwg.insertVertex("a");
        Vertex<String> b = dwg.insertVertex("b");
        Vertex<String> c = dwg.insertVertex("c");
        Vertex<String> d = dwg.insertVertex("d");
        Edge<String> ab = dwg.insertEdge(a, b, "ab");
        Edge<String> cd = dwg.insertEdge(c, d, "cd");
        Edge<String> ad = dwg.insertEdge(a, d, "ad");
        System.out.println("So dinh cua do thi la: " + dwg.numVertices());
        System.out.println("So canh cua do thi la: " + dwg.numEdges());
        System.out.println("Bac cua dinh a la: " + dwg.outDegree(a));
        System.out.println("Bac cua do thi la: " + dwg.deg());
        if (dwg.getEdge(a, b) != null)
            System.out.println("Ton tai canh noi dinh a va b");
        else System.out.println("Khong ton tai canh noi dinh a va b");
        if (dwg.getEdge(c, b) != null)
            System.out.println("Ton tai canh noi dinh c va b");
        else System.out.println("Khong ton tai canh noi dinh c va b");
        System.out.println("Cac canh ke dinh a:");
        for (Edge<String> edge : dwg.outgoingEdges(a)) {
            System.out.println("- " + edge.getValue());
        }
        System.out.println("Cac dinh ke dinh b:");
        for (Vertex<String> vertex : dwg.linked(b)) {
            System.out.println("- " + vertex.getValue());
        }
        System.out.println("Remove test a");
        dwg.removeVertex(a);
        try {
            System.out.println("Cac canh ke dinh a:");
            for (Edge<String> edge : dwg.outgoingEdges(a)) {
                System.out.println("- " + edge.getValue());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        dwg.removeEdge(cd);
        System.out.println("Remove test cd: " + dwg.getEdge(c, d));
    }
}
