import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    ImageIcon back = new ImageIcon("bus.jpeg");
    ImageIcon i1 = new ImageIcon("ticket.png");
    public static Color c = new Color(255, 158, 160);

    login() {

        Font f = new Font("Times New Roman", Font.BOLD, 20);
        l3 = new JLabel(back, JLabel.LEFT);
        l3.setBounds(0, 0, 1200, 500);
        l4 = new JLabel(i1, JLabel.CENTER);
        l4.setBounds(400, 180, 200, 200);
        setLayout(null);
        l1 = new JLabel("Username");
        l1.setFont(f);
        l2 = new JLabel("Password");
        l2.setFont(f);
        t1 = new JTextField(20);
        t1.setFont(f);
        t2 = new JPasswordField(20);
        t2.setFont(f);
        b1 = new JButton("Next");
        b1.setFont(f);
        b1.setBounds(170, 290, 100, 40);
        l1.setBounds(70, 200, 100, 20);
        t1.setBounds(170, 200, 200, 30);
        l2.setBounds(70, 240, 100, 20);
        t2.setBounds(170, 240, 200, 30);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(l4);
        add(l3);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (t1.getText().equals("1234") && t2.getText().equals("1234")) {
            this.setVisible(false);
            home h = new home();
            h.setVisible(true);
            h.setSize(800, 500);
            h.setTitle("Printing System");
        } else {
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        login l = new login();
        l.setSize(700, 500);
        l.setVisible(true);
        l.setTitle("Login..");
    }
}