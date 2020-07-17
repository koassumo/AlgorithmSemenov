package lesson7;

public class Main7 {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 7);
        graph.addEdge(1, 9);
        graph.addEdge(3, 7);
        graph.addEdge(3, 9);
        graph.addEdge(4, 7);

        graph.widthTraverse();
    }
}
