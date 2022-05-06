package hw8_20001976.graph;

import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class DirectedWeightedGraph<V, E extends Comparable<? super E>> implements Graph<V, E> {
    protected ArrayList<Vertex<V>> vertices;
    protected ArrayList<Edge<V>> edges;
    protected Edge<E>[][] link;

    public DirectedWeightedGraph() {
        this.link = new Edge[10][10];
        vertices = new ArrayList<>(10);
        edges = new ArrayList<>(50);
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return (Iterable<Vertex<V>>) vertices.iterator();
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return (Iterable<Edge<E>>) edges.iterator();
    }

    public int deg() {
        int count = 0;
        for (Edge[] edges : link) {
            int tempCount = 0;
            for (Edge edge : edges) {
                if (edge != null)
                    tempCount++;
            }
            if (count < tempCount)
                count = tempCount;
        }
        for (int i = 0; i < link[0].length; i++) {
            int tempCount = 0;
            for (Edge<E>[] edge : link) {
                if (edge[i] != null)
                    tempCount++;
            }
            if (count < tempCount)
                count = tempCount;
        }
        return count;
    }

    public Iterable<Vertex<V>> linked(Vertex<V> v) {
        if (v == null || !vertices.contains(v))
            throw new IllegalArgumentException("Unknown vertex");
        ArrayList<Vertex<V>> vertex = new ArrayList<>();
        for (Edge<E> edge : this.outgoingEdges(v)) {
            if (!vertex.contains(opposite(v, edge))) {
                vertex.add(opposite(v, edge));
            }
        }
        return vertex;
    }

    @Override
    public int outDegree(Vertex<V> v) throws IllegalArgumentException {
        if (v == null || !vertices.contains(v)) {
            throw new IllegalArgumentException("Unknown vertex");
        } else {
            int count = 0;
            for (Edge<E>[] edge : link) {
                if (edge[vertices.indexOf(v)] != null)
                    count++;
            }
            return count;
        }
    }

    @Override
    public int inDegree(Vertex<V> v) throws IllegalArgumentException {
        if (v == null || !vertices.contains(v)) {
            throw new IllegalArgumentException("Unknown vertex");
        } else {
            int count = 0;
            for (Edge edge : link[vertices.indexOf(v)]) {
                if (edge != null)
                    count++;
            }
            return count;
        } // undirected so out = in
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
        if (v == null || !vertices.contains(v)) {
            throw new IllegalArgumentException("Unknown vertex");
        } else {
            ArrayList<Edge<E>> edges = new ArrayList<>();
            for (Edge edge : link[vertices.indexOf(v)]) {
                if (edge != null)
                    edges.add(edge);
            }
            return edges;
        }
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
        if (v == null || !vertices.contains(v)) {
            throw new IllegalArgumentException("Unknown vertex");
        } else {
            ArrayList<Edge<E>> edges = new ArrayList<>();
            for (Edge<E>[] edge : link) {
                if (edge[vertices.indexOf(v)] != null)
                    edges.add(edge[vertices.indexOf(v)]);
            }
            return edges;
        }
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
        if (v == null || u == null || !vertices.contains(u) || !vertices.contains(v))
            throw new IllegalArgumentException("Unknown vertex");
        return link[vertices.indexOf(u)][vertices.indexOf(v)];
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException {
        if (!edges.contains(e))
            throw new IllegalArgumentException("Unknown Edge");
        return e.endVertices();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
        if (v == null || e == null || !edges.contains(e) || !vertices.contains(v))
            throw new IllegalArgumentException("Unknown vertex");
        Vertex<V>[] vertices = e.endVertices();
        if (vertices[0] == v)
            return vertices[1];
        else if (vertices[1] == v)
            return vertices[0];
        else
            throw new IllegalArgumentException("Edge doesn't connect that vertex");
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        Vertex<V> vertex = new Vertex<>(element);
        vertices.add(vertex);
        if (vertices.size() > link.length) {
            Edge<E>[][] edgesTemp = new Edge[vertices.size()][vertices.size()];
            for (int i = 0; i < link.length; i++) {
                System.arraycopy(link[i], 0, edgesTemp[i], 0, link[i].length);
            }
            link = edgesTemp;
        }
        return vertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
        if (v == null || u == null || !vertices.contains(u) || !vertices.contains(v))
            throw new IllegalArgumentException("Unknown vertex");
        int uIndex = vertices.indexOf(u);
        int vIndex = vertices.indexOf(v);
        link[uIndex][vIndex] = new WeightedEdge(u, v, element);
        edges.add((Edge<V>) link[uIndex][vIndex]);
        return link[uIndex][vIndex];
    }

    @Override
    public void removeVertex(Vertex<V> v) throws IllegalArgumentException {
        if (v == null || !vertices.contains(v))
            throw new IllegalArgumentException("Unknown vertex");
        int index = vertices.indexOf(v);
        vertices.remove(v);
        if (link.length - 1 - index >= 0)
            System.arraycopy(link, index + 1, link, index, link.length - 1 - index);
        link[link.length - 1] = null;
        for (int i = 0; i < link.length; i++) {
            if (link[i] != null) {
                edges.remove(link[i][index]);
                if (link[i].length - 1 - index >= 0)
                    System.arraycopy(link[i], index + 1, link[i], index, link[i].length - index - 1);
                link[i][link[i].length - 1] = null;
            }
        }
    }

    @Override
    public void removeEdge(Edge<E> e) throws IllegalArgumentException {
        if (e == null || !edges.contains(e))
            throw new IllegalArgumentException("Unknown vertex");
        Vertex[] point = e.endVertices();
        int uIndex = vertices.indexOf(point[0]);
        int vIndex = vertices.indexOf(point[1]);
        link[uIndex][vIndex] = null;
    }

    public class WeightedEdge implements Edge<E>, Comparable<Edge<E>> {
        final Vertex<V>[] endpoints;
        E element;

        public WeightedEdge(Vertex a, Vertex b, E element) {
            endpoints = new Vertex[]{a, b};
            this.element = element;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public void setValue(E value) {
            this.element = value;
        }

        @Override
        public Vertex[] endVertices() {
            return endpoints;
        }


        @Override
        public int compareTo(Edge<E> e) {
            return element.compareTo(e.getValue());
        }
    }

}