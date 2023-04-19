package graphNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GraphController implements ActionListener {
    private GraphView view;
    private int vertexNumber;
    private int edgeNumber;
    private List<Vertex> nodes;
    private List<Edge> edges;
    Random random = new Random();

    public GraphController(GraphView view) {
        this.view = view;
        view.getButtonGenerate().addActionListener(this);
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void excute() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < edgeNumber; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
            addLane("Node_" + i, random.nextInt(vertexNumber),random.nextInt(vertexNumber),random.nextInt());
        }
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }

    private boolean validateVertexNumber() {
        boolean isValid = false;
        try {
            if (!"".equals(view.getTextFieldV().getText())) {
                vertexNumber = Integer.parseInt(view.getTextFieldV().getText());
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(view, "Vertex number shouldn't be empty.");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Vertex number is illegal.");
        }
        return isValid;
    }

    private boolean validateEdgeNumber() {
        boolean isValid = false;
        try {
            if (!"".equals(view.getTextFieldE().getText())) {
                edgeNumber = Integer.parseInt(view.getTextFieldE().getText());
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(view, "Edge number shouldn't be empty.");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Edge number is illegal.");
        }
        return isValid;
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (validateVertexNumber() && validateEdgeNumber()) {

        } else {

        }
    }

    public GraphView getView() {
        return view;
    }

    public void setView(GraphView view) {
        this.view = view;
    }
}
