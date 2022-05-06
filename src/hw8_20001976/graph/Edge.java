package hw8_20001976.graph;

@SuppressWarnings("rawtypes")
public interface Edge<E> {

    E getValue();

    void setValue(E value);

    Vertex[] endVertices();

    @Override
    String toString();
}
