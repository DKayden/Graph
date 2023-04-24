package graphNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GenerateController implements ActionListener {
    private GraphView view;
    private int vertexNumber;
    private int edgeNumber;
    private List<Vertex> nodes;
    private int edgeSource;
    private int edgeDestination;
    private int edgeWeight;
    private List<Edge> edges;
    private Random random;

    public GenerateController(GraphView view) {
        this.view = view;
            view.getButtonGenerate().addActionListener(this);
            view.getButtonEgde().addActionListener(this);
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

//    public void excute() {
//        nodes = resultListVertex();
//        edges = resultListEdge();
//        Graph graph = new Graph(nodes, edges);
//        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
//        dijkstra.execute(nodes.get(0));
//        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));
//
//        for (Vertex vertex : path) {
//            System.out.println(vertex);
//        }
//    }

    private void resultListVertex() {
        nodes = new ArrayList<>();
        for (int i = 0; i < vertexNumber; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
    }

    private void resultListEdge() {
        edges = new ArrayList<>();
        for (int i = 1; i <= edgeNumber; i++) {
            Edge lane = addLane("Edge_" + i, edgeSource, edgeDestination, edgeWeight);
            edges.add(lane);
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

    private boolean validateEdgeSource() {
        boolean isValid = false;
        try {
            if (!"".equals(view.getTextFieldSource().getText())) {
                edgeSource = Integer.parseInt(view.getTextFieldSource().getText());
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(view, "Edge source shouldn't be empty.");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Edge source is illegal.");
        }
        return isValid;
    }

    private boolean validateEdgeDestination() {
        boolean isValid = false;
        try {
            if (!"".equals(view.getTextFieldDestination().getText())) {
                edgeDestination = Integer.parseInt(view.getTextFieldDestination().getText());
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(view, "Edge destination shouldn't be empty.");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Edge destination is illegal.");
        }
        return isValid;
    }

    private boolean validateEdgeWeight() {
        boolean isValid = false;
        try {
            if (!"".equals(view.getTextFieldWeight().getText())) {
                edgeWeight = Integer.parseInt(view.getTextFieldWeight().getText());
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(view, "Edge destination shouldn't be empty.");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Edge destination is illegal.");
        }
        return isValid;
    }

    private Edge addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        return new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getButtonGenerate()) {
            if (validateVertexNumber() && validateEdgeNumber()) {
                view.generateEdgeLink(edgeNumber);
                resultListVertex();
                view.getResultVertex().setText(nodes.toString());
            }
        }
        if (e.getSource() == view.getButtonEgde()) {
            System.out.println(edgeSource);
            System.out.println(edgeDestination);
            System.out.println(edgeWeight);
            if (validateEdgeSource() && validateEdgeDestination() && validateEdgeWeight()) {
                resultListEdge();
                view.getResultEdge().setText(edges.toString());
            }
        }
    }

    public GraphView getView() {
        return view;
    }

    public void setView(GraphView view) {
        this.view = view;
    }
}
