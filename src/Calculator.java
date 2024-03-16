import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    JButton b10, b11, b12, b13, b14, b15,b16, b17, b18,b19;
    JButton b[] = new JButton[10];

    int i;
    double n1, n2, r;

    JTextField res;
    String op;

    public Calculator() {
        super("Calculator");
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));
        for (int i = 0; i <= 9; i++) {
            b[i] = new JButton(i + "");
            p.add(b[i]);
            b[i].addActionListener(this);
        }
        b10 = new JButton("+");
        p.add(b10);
        b10.addActionListener(this);
        b10.setBackground(new java.awt.Color(163,228,215));

        b11 = new JButton("-");
        p.add(b11);
        b11.addActionListener(this);
        b11.setBackground(new java.awt.Color(163,228,215));

        b12 = new JButton("*");
        p.add(b12);
        b12.addActionListener(this);
        b12.setBackground(new java.awt.Color(163,228,215));

        b13 = new JButton("/");
        p.add(b13);
        b13.addActionListener(this);
        b13.setBackground(new java.awt.Color(163,228,215));


        b14 = new JButton("=");
        p.add(b14);
        b14.addActionListener(this);
        b14.setBackground(new java.awt.Color(52,152,219));

        b15 = new JButton("C");
        p.add(b15);
        b15.addActionListener(this);
        b15.setBackground(new java.awt.Color(231,76,60));

        b16 = new JButton("Cos");
        p.add(b16);
        b16.addActionListener(this);
        b16.setBackground(new java.awt.Color(241,196,15));

        b17 = new JButton("Sen");
        p.add(b17);
        b17.addActionListener(this);
        b17.setBackground(new java.awt.Color(241,196,15));

        b18 = new JButton("Tan");
        p.add(b18);
        b18.addActionListener(this);
        b18.setBackground(new java.awt.Color(241,196,15));

        b19 = new JButton(",");
        p.add(b19);
        b19.addActionListener(this);
        b19.setBackground(new java.awt.Color(133,146,158));


        res = new JTextField(10);
        res.setPreferredSize( new Dimension( 200, 40 ) );
        add(p, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(400, 400);
    }
    boolean ver;
    public void actionPerformed(ActionEvent ae) {

        JButton pb = (JButton) ae.getSource();
        if (pb == b15) {
            r = n1 = n2 = 0;
            res.setText("");
        } else if (pb == b14) {
            if(!ver){
                n2 = Double.parseDouble(res.getText());
            }
            eval();
            res.setText("" + r);
        } else {
            boolean opf = false;
            if (pb == b10) {
                op = "+";
                opf = true;
                ver=false;
            }
            if (pb == b11) {
                op = "-";
                opf = true;
                ver=false;
            }
            if (pb == b12) {
                op = "*";
                opf = true;
                ver=false;
            }
            if (pb == b13) {
                op = "/";
                opf = true;
                ver=false;
            }
            if(pb==b16){
                op = "cos";
                String t = res.getText();
                t = "Cos(" + t + ")";
                n1 = Double.parseDouble(res.getText());
                res.setText(t);
                ver=true;
            }
            if(pb==b17) {
                op = "sen";
                String t = res.getText();
                t = "Sen(" + t + ")";
                n1 = Double.parseDouble(res.getText());
                res.setText(t);
                ver = true;
            }
            if(pb==b18) {
                op = "tan";
                String t = res.getText();
                t = "Tan(" + t + ")";
                n1 = Double.parseDouble(res.getText());
                res.setText(t);
                ver = true;
            }
            if (pb == b19) {
                String t = res.getText();
                t += ".";
                res.setText(t);
            }

            if (opf == false) {
                for (i = 0; i < 10; i++) {
                    if (pb == b[i]) {
                        String t = res.getText();
                        t += i;
                        res.setText(t);
                    }
                }
            } else {
                n1 = Double.parseDouble(res.getText());
                res.setText("");
            }
        }
    }

    int eval() {
        switch (op) {
            case "+":
                r = n1 + n2;
                break;
            case "-":
                r = n1 - n2;
                break;
            case "*":
                r = n1 * n2;
                break;
            case "/":
                r = n1 / n2;
                break;
            case "cos":
                r = (Double)Math.cos(Math.toRadians(n1));
                break;
            case "sen":
                r = (Double)Math.sin(Math.toRadians(n1));
                break;
            case "tan":
                r = (Double)Math.tan(Math.toRadians(n1));
                break;
        }
        return 0;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}