package graphNode;

import javax.swing.*;

public class GraphView extends JFrame {
    private JTextField textFieldV;
    private JTextField textFieldE;
    private JButton buttonGenerate;

    public GraphView() {

        JLabel labelV = new JLabel("Vertex: "); // Tạo trường nhãn thông số điểm
        labelV.setBounds(10,28,50,20);// trục x , y , width, height

        textFieldV = new JTextField(); // Tạo trường nhập thông tin số điểm
        textFieldV.setBounds(55,30,40,20);

        JLabel labelE = new JLabel("Edge: "); // Tạo trường nhãn thông số điểm
        labelE.setBounds(10,52,50,20);

        textFieldE = new JTextField(); // Tạo trường nhập thông tin số cạnh
        textFieldE.setBounds(55,55,40,20);

        buttonGenerate = new JButton("Generate");// tạo thể hiện của JButton
        buttonGenerate.setBounds(10, 80, 90, 30);

        setTitle("Graph Node");
        add(buttonGenerate);// thêm button vào JFrame
        add(textFieldV); // thêm text field nhập số điểm vào JFrame
        add(labelV); // thêm label điểm vào JFrame
        add(textFieldE); // thêm text field nhập số cạnh vào JFrame
        add(labelE); // thêm label cạnh vào JFrame

        setSize(400, 200);// thiết lập kích thước cho của sổ
        setLayout(null);// không sử dụng trình quản lý bố cục
        setVisible(true);// hiển thị cửa sổ


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
}
