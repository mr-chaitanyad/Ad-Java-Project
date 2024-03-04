import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class table extends JFrame implements ActionListener {
    JTextArea ja;
    JScrollPane js;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JButton b1, b2, b3;
    Font f = new Font("Times New Roman", Font.BOLD, 20);
    public static Color c = new Color(244, 214, 188);
    Container cnt;

    table() {
        cnt = getContentPane();
        cnt.setBackground(c);
        setLayout(null);
        l1 = new JLabel("Panssenger ID:");
        l1.setFont(f);
        l1.setBounds(50, 100, 180, 25);
        l2 = new JLabel("Panssenger Name:");
        l2.setFont(f);
        l2.setBounds(50, 150, 180, 25);
        l3 = new JLabel("Start:");
        l3.setFont(f);
        l3.setBounds(50, 200, 180, 25);
        l4 = new JLabel("Destination:");
        l4.setFont(f);
        l4.setBounds(50, 250, 180, 25);

        l5 = new JLabel();
        l5.setFont(f);
        l5.setBounds(270, 100, 180, 25);
        l6 = new JLabel();
        l6.setFont(f);
        l6.setBounds(270, 150, 180, 25);
        l7 = new JLabel();
        l7.setFont(f);
        l7.setBounds(270, 200, 180, 25);
        l8 = new JLabel();
        l8.setFont(f);
        l8.setBounds(270, 250, 180, 25);

        l9 = new JLabel("Ruppes");
        l9.setFont(f);
        l9.setBounds(50, 300, 180, 25);
        l10 = new JLabel();
        l10.setFont(f);
        l10.setBounds(270, 300, 180, 25);

        b1 = new JButton("Store");
        b1.setFont(f);
        b1.setBounds(30, 370, 100, 30);

        b2 = new JButton("Print");
        b2.setFont(f);
        b2.setBounds(140, 370, 100, 30);
        b3 = new JButton("<--Back");
        b3.setFont(f);
        b3.setBounds(250, 370, 105, 30);

        ja = new JTextArea(20, 20);
        js = new JScrollPane(ja);
        js.setBounds(400, 100, 310, 300);
        // String head[] = { "ID", "Name", "Start", "Destination" };
        add(l1);
        add(l5);
        add(l2);
        add(l6);
        add(l3);
        add(l7);
        add(l4);
        add(l8);
        add(l9);
        add(l10);
        add(b1);
        add(b2);
        add(b3);
        add(js);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            ja.setFont(new Font("Times New Roman", Font.BOLD, 15));
            ja.setText("  Chaitanya Dhayarkar System" + "\n\n" +
                    "  |============================|" + "\n" +
                    "  |++++++++++Bus Ticket++++++++++|" + "\n" +
                    "  |============================|" + "\n\n" +
                    "  Passenger ID:\t" + l5.getText() + "\n\n" +
                    "  Passenger Name:\t" + l6.getText() + "\n\n" +
                    "  Passenger Stop:\t" + l7.getText() + "\n\n" +
                    "  Passenger Destination:\t" + l8.getText() + "\n\n" +
                    "  Rupees:               \t" + "$" + l10.getText());
        }
        if (e.getSource() == b2) {
            try {
                File f1 = new File("c:\\Desktop\\Java Project\\abc.txt");
                FileWriter out = new FileWriter(f1);
                String str = ja.getText();
                out.write(str);
                out.close();
            } catch (IOException i) {
            }
        }
        if (e.getSource() == b3) {
            home h = new home();
            this.setVisible(false);
            h.setVisible(true);
            h.setTitle("Printing System");
            h.setSize(800, 500);
        }
    }

    public static void main(String[] args) {
        table t = new table();
        t.setVisible(true);
        t.setTitle("Print Ticket");
        t.setSize(760, 500);
    }
}
