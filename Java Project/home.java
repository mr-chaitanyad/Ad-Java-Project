import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class home extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, lhead, l6, l7;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    JComboBox j1, j2;
    Font f = new Font("Times New Roman", Font.BOLD, 20);
    Color c1 = new Color(244, 214, 188);
    ImageIcon i1 = new ImageIcon("bus2.png");

    home() {
        Container cnt = getContentPane();
        cnt.setLayout(null);
        cnt.setBackground(c1);
        lhead = new JLabel("Bus Ticket Printing System");
        lhead.setFont(new Font("Times New Roman", Font.BOLD, 35));
        lhead.setBounds(150, 10, 1000, 100);
        l1 = new JLabel("Passenger ID");
        l1.setFont(f);
        l1.setBounds(50, 100, 150, 30);
        l2 = new JLabel("Passenger Name");
        l2.setFont(f);
        l2.setBounds(50, 160, 150, 30);
        l3 = new JLabel("Start");
        l3.setFont(f);
        l3.setBounds(50, 220, 150, 30);
        l4 = new JLabel("Destination");
        l4.setFont(f);
        l4.setBounds(50, 280, 150, 30);

        l5 = new JLabel("Rupees");
        l5.setFont(f);
        l5.setBounds(50, 340, 150, 30);
        l6 = new JLabel("Insert Ticket Record Here");
        l6.setFont(f);
        l6.setBounds(130, 400, 250, 30);
        t1 = new JTextField(20);
        t1.setFont(f);
        t1.setBounds(230, 100, 200, 30);
        t2 = new JTextField(20);
        t2.setFont(f);
        t2.setBounds(230, 160, 200, 30);

        String str[] = { "Stop 1", "Stop 2", "Stop 3", "Stop 5", "Stop 6", "Stop 7", "Stop 8" };
        j1 = new JComboBox<>(str);
        j1.setFont(f);
        j1.setBounds(230, 220, 200, 30);

        String str1[] = { "Stop 1", "Stop 2", "Stop 3", "Stop 5", "Stop 6", "Stop 7", "Stop 8" };
        j2 = new JComboBox<>(str1);
        j2.setFont(f);
        j2.setBounds(230, 280, 200, 30);
        t3 = new JTextField(50);
        t3.setFont(f);
        t3.setBounds(230, 340, 200, 30);
        b1 = new JButton("Submit");
        b1.setFont(f);
        b1.setBounds(460, 150, 200, 30);
        b2 = new JButton("Export Ticket");
        b2.setFont(f);
        b2.setBounds(460, 200, 200, 30);
        l7 = new JLabel(i1);
        l7.setBounds(460, 240, 240, 200);
        add(l7);
        add(lhead);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(j1);
        add(l4);
        add(j2);
        add(l5);
        add(t3);
        add(l6);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered");
        } catch (Exception e1) {
            System.out.println("Driver Error");
        }
        try {
            if (e.getSource() == b1) {
                int pid = Integer.parseInt(t1.getText());
                String pname = t2.getText();
                String start = j1.getSelectedItem().toString();
                String des = j2.getSelectedItem().toString();
                int rupee = Integer.parseInt(t3.getText());
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
                        "root123");
                PreparedStatement pst = con.prepareStatement("Insert into ticket values(?,?,?,?,?)");

                pst.setInt(1, pid);
                pst.setString(2, pname);
                pst.setString(3, start);
                pst.setString(4, des);
                pst.setInt(5, rupee);
                pst.executeUpdate();
                l6.setText("Record added Successfully");
                // clearFields();
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
        if (e.getSource() == b2) {
            table t = new table();
            this.setVisible(false);
            t.setSize(760, 500);
            t.setTitle("Print Ticket");
            t.l5.setText(t1.getText());
            t.l6.setText(t2.getText());
            t.l7.setText(j1.getSelectedItem().toString());
            t.l8.setText(j2.getSelectedItem().toString());
            t.l10.setText(t3.getText());
            t.setVisible(true);

        }
    }

    public static void main(String[] args) {
        home h = new home();
        h.setVisible(true);
        h.setTitle("Printing System");
        h.setSize(800, 500);
    }
}