import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class calculator extends Applet implements ActionListener {
    TextField t1 = new TextField(10);
    TextField t2 = new TextField(10);
    TextField t3 = new TextField(10);
    Label l1 = new Label("Enter a value:");
    Label l2 = new Label("Enter b value:");
    Label l3 = new Label("Result");
    Button b1 = new Button("Addition");
    Button b2 = new Button("Subtraction");
    Button b3 = new Button("Multiplication");
    Button b4 = new Button("Division");
    Button b5 = new Button("Clear");

    public void init() {
        setLayout(new GridLayout(6, 2));
        setBackground(Color.decode("#2e4053"));

        l1.setForeground(Color.decode("#ebedef"));
        l2.setForeground(Color.decode("#ebedef"));
        l3.setForeground(Color.decode("#ebedef"));
        t1.setBackground(Color.decode("#d6dbdf"));
        t2.setBackground(Color.decode("#d6dbdf"));
        t3.setBackground(Color.decode("#d6dbdf"));
        b1.setBackground(Color.decode("#aeb6bf"));
        b2.setBackground(Color.decode("#aeb6bf"));
        b3.setBackground(Color.decode("#aeb6bf"));
        b4.setBackground(Color.decode("#aeb6bf"));
        b5.setBackground(Color.decode("#d35400"));

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 24);

        l1.setFont(labelFont);
        l2.setFont(labelFont);
        l3.setFont(labelFont);

        t1.setFont(textFieldFont);
        t2.setFont(textFieldFont);
        t3.setFont(textFieldFont);

        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b3.setFont(buttonFont);
        b4.setFont(buttonFont);
        b5.setFont(buttonFont);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        
        Panel clearPanel = new Panel();
        clearPanel.setLayout(new BorderLayout());
        clearPanel.add(b5, BorderLayout.CENTER);
        add(clearPanel);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b5) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            return;
        }

        float a, b;

        try {
            a = Float.parseFloat(t1.getText());
            b = Float.parseFloat(t2.getText());
        } catch (NumberFormatException ex) {
            t3.setText("Invalid input");
            return;
        }

        if (e.getSource() == b1) {
            t3.setText(String.format("%.2f", a + b));
        } else if (e.getSource() == b2) {
            t3.setText(String.format("%.2f", a - b));
        } else if (e.getSource() == b3) {
            t3.setText(String.format("%.2f", a * b));
        } else if (e.getSource() == b4) {
            if (b == 0) {
                t3.setText("Error");
            } else {
                t3.setText(String.format("%.2f", a / b));
            }
        }
    }
}

/*<applet code="calculator.class" width=600 height=500></applet>*/
