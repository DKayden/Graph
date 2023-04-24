package graphNode;

import javax.swing.*;

public class GraphView extends JFrame {
    private JTextField textFieldV;
    private JTextField textFieldE;
    private JButton buttonGenerate;
    private JTextArea resultVertex;
    private JTextArea resultEdge;
    private JTextField textFieldSource;
    private JTextField textFieldDestination;
    private JTextField textFieldWeight;
    private JLabel labelV;
    private JLabel labelE;
    private JLabel labelES;
    private JLabel labelED;
    private JLabel labelEW;
    private JButton buttonEgde;
    private JLabel labelVL;

    public GraphView() {

        labelV = new JLabel("Vertex: "); // Tạo trường nhãn thông số điểm
        labelV.setBounds(10,28,50,20);// trục x , y , width, height

        textFieldV = new JTextField(); // Tạo trường nhập thông tin số điểm
        textFieldV.setBounds(55,30,40,20);

        labelE = new JLabel("Edge: "); // Tạo trường nhãn thông số điểm
        labelE.setBounds(10,52,50,20);

        textFieldE = new JTextField(); // Tạo trường nhập thông tin số cạnh
        textFieldE.setBounds(55,55,40,20);

        buttonGenerate = new JButton("Generate");// tạo thể hiện của JButton
        buttonGenerate.setBounds(10, 80, 90, 30);
        buttonGenerate.setActionCommand(Actions.Generate.name());

        buttonEgde = new JButton("Edge");
        buttonEgde.setBounds(110, 80, 90, 30);
        buttonEgde.setActionCommand(Actions.Edge.name());

        labelVL = new JLabel("List Vertex");
        labelVL.setBounds(150,10,200,20);

        resultVertex = new JTextArea();
        resultVertex.setBounds(100,30,200,40);
        resultVertex.setLineWrap(true);
        resultVertex.setWrapStyleWord(true);

        setTitle("Graph Node");
        add(buttonGenerate);// thêm button vào JFrame
        add(textFieldV); // thêm text field nhập số điểm vào JFrame
        add(labelV); // thêm label điểm vào JFrame
        add(textFieldE); // thêm text field nhập số cạnh vào JFrame
        add(labelE); // thêm label cạnh vào JFrame
        add(resultVertex);// thêm ô để chứa kết quả trả ra của các đỉnh
        add(labelVL);
        add(buttonEgde);

        setSize(500, 500);// thiết lập kích thước cho của sổ
        setLayout(null);// không sử dụng trình quản lý bố cục
        setVisible(true);// hiển thị cửa sổ
    }

    public void generateEdgeLink(int edgeNumber) {
        labelES = new JLabel("Source");
        labelES.setBounds(30,110,90,30);
        labelED = new JLabel("Destination");
        labelED.setBounds(80,110,90,30);
        labelEW = new JLabel("Weight");
        labelEW.setBounds(150,110,90,30);
        resultEdge = new JTextArea();
        resultEdge.setBounds(200, 120, 200,200);
        resultEdge.setLineWrap(true);
        resultEdge.setWrapStyleWord(true);
        add(labelES);
        add(labelED);
        add(labelEW);
        add(resultEdge);
            for (int j = 0; j < edgeNumber; j++) {
                textFieldSource = new JTextField();// Tạo trường nhập thông tin điểm của đường
                textFieldSource.setBounds(30,135+30*j,40,20);
                textFieldDestination = new JTextField();// Tạo trường nhập thông tin điểm của đường
                textFieldDestination.setBounds(90,135+30*j,40,20);
                textFieldWeight = new JTextField();// Tạo trường nhập thông tin điểm của đường
                textFieldWeight.setBounds(150,135+30*j,40,20);
                add(textFieldSource);
                add(textFieldDestination);
                add(textFieldWeight);
            }
    }

    public JTextField getTextFieldV() {
        return textFieldV;
    }

    public void setTextFieldV(JTextField textFieldV) {
        this.textFieldV = textFieldV;
    }

    public JTextField getTextFieldE() {
        return textFieldE;
    }

    public void setTextFieldE(JTextField textFieldE) {
        this.textFieldE = textFieldE;
    }

    public JButton getButtonGenerate() {
        return buttonGenerate;
    }

    public void setButtonGenerate(JButton buttonGenerate) {
        this.buttonGenerate = buttonGenerate;
    }

    public JTextArea getResultVertex() {
        return resultVertex;
    }

    public void setResultVertex(JTextArea resultVertex) {
        this.resultVertex = resultVertex;
    }

    public JTextField getTextFieldSource() {
        return textFieldSource;
    }

    public void setTextFieldSource(JTextField textFieldSource) {
        this.textFieldSource = textFieldSource;
    }

    public JTextField getTextFieldDestination() {
        return textFieldDestination;
    }

    public void setTextFieldDestination(JTextField textFieldDestination) {
        this.textFieldDestination = textFieldDestination;
    }

    public JTextField getTextFieldWeight() {
        return textFieldWeight;
    }

    public void setTextFieldWeight(JTextField textFieldWeight) {
        this.textFieldWeight = textFieldWeight;
    }

    public JButton getButtonEgde() {
        return buttonEgde;
    }

    public void setButtonEgde(JButton buttonEgde) {
        this.buttonEgde = buttonEgde;
    }

    public JTextArea getResultEdge() {
        return resultEdge;
    }

    public void setResultEdge(JTextArea resultEdge) {
        this.resultEdge = resultEdge;
    }
}
