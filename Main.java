package graphNode;

public class Main {
    public static void main(String[] args) {
        GraphView view = new GraphView();
        GraphController controller = new GraphController(view);
        controller.excute();
    }
}
