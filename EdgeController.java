package graphNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class EdgeController implements ActionListener {
    private GraphView view;
    private List<Vertex> nodes;
    private List<Edge> edges;
    private int edgeSource;
    private int edgeDestination;
    private int edgeWeight;
    private int edgeNumber;

    public EdgeController(GraphView view) {
        this.view = view;
        view.getButtonEgde().addActionListener(this);
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    private void resultListEdge() {
        edges = new ArrayList<>();
        for (int i = 0; i < edgeNumber; i++) {
            addLane("Edge_" + i, edgeSource, edgeDestination, edgeWeight);
        }
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

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (validateEdgeSource() && validateEdgeDestination() && validateEdgeWeight()) {
            resultListEdge();
            view.getResultEdge().setText(edges.toString());
        }
    }

    public GraphView getView() {
        return view;
    }

    public void setView(GraphView view) {
        this.view = view;
    }
}
