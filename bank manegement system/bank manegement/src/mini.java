import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class mini extends JFrame implements ActionListener {
    String pin;
    JTextArea transactionArea;
    JButton back;

    mini(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 800, 800);
        add(img);

        JLabel title = new JLabel("Mini Statement");
        title.setBounds(300, 200, 200, 30);
        title.setFont(new Font("osward", Font.BOLD, 20));
        title.setForeground(Color.white);
        img.add(title);

        // Text area to display transactions
        transactionArea = new JTextArea();
        transactionArea.setBounds(100, 250, 600, 300);
        transactionArea.setFont(new Font("osward", Font.BOLD, 15));
        transactionArea.setEditable(false);
        img.add(transactionArea);

        back = new JButton("BACK");
        back.setBounds(340, 600, 100, 30);
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        img.add(back);

        displayTransactions();

        setSize(800, 800);
        setLocation(600, 0);
        setUndecorated(true);
        setVisible(true);
    }

    private void displayTransactions() {

        ResultSet rs = null;

        try {

            connection c = new connection();

            String query = "SELECT * FROM transactions WHERE pin = '" + pin
                    + "' ORDER BY transaction_date DESC LIMIT 10";
            rs = c.s.executeQuery(query);

            StringBuilder transactions = new StringBuilder();
            transactions.append("Date\t\t\tAmount\tType\n");
            transactions.append("-------------------------------------------------\n");

            while (rs.next()) {
                String date = rs.getString("transaction_date");
                double amount = rs.getDouble("amount");
                String type = rs.getString("type_of_transaction");
                transactions.append(date + "\t" + amount + "\t" + type + "\n");
            }

            transactionArea.setText(transactions.toString());
        } catch (Exception e) {
            e.printStackTrace();
            transactionArea.setText("Error retrieving transactions.");
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new atm(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new mini("");
    }
}
