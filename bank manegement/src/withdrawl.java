import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class withdrawl extends JFrame implements ActionListener {
   JTextField withdrawl1;
   JButton withdrawl, back;
   String pin;

   withdrawl(String pin) {
      this.pin = pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel img = new JLabel(i3);
      add(img);

      JLabel text = new JLabel("Enter an amount you");
      text.setBounds(180, 260, 500, 30);
      text.setFont(new Font("osward", Font.BOLD, 20));
      text.setForeground(Color.white);
      img.add(text);

      JLabel text1 = new JLabel("want to withdraw.");
      text1.setBounds(200, 290, 500, 30);
      text1.setFont(new Font("osward", Font.BOLD, 20));
      text1.setForeground(Color.white);
      img.add(text1);

      withdrawl = new JButton("WITHDRAW");
      withdrawl.setBounds(340, 420, 100, 30);
      withdrawl.setBackground(Color.gray);
      withdrawl.setForeground(Color.white);
      withdrawl.addActionListener(this);
      img.add(withdrawl);

      back = new JButton("BACK");
      back.setBounds(140, 420, 100, 30);
      back.setBackground(Color.gray);
      back.setForeground(Color.white);
      back.addActionListener(this);
      img.add(back);

      withdrawl1 = new JTextField();
      withdrawl1.setBounds(180, 350, 200, 30);
      img.add(withdrawl1);

      setSize(800, 800);
      setLocation(600, 0);
      setUndecorated(true);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == withdrawl) {
         String amount = withdrawl1.getText();

         if (amount.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter an amount");
         } else {
            try {
               connection c = new connection();
               String query = "select balance from accounts where pin='" + pin + "'";
               ResultSet rs = c.s.executeQuery(query);
               if (rs.next()) {
                  double balance = rs.getDouble("balance");
                  double withdrawlAmount = Double.parseDouble(amount);

                  if (balance < withdrawlAmount) {
                     JOptionPane.showMessageDialog(null, "Insufficient balance");
                     return;
                  }

                  // Get the current date and format it using java.util.Date
                  java.util.Date date = new java.util.Date();
                  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  String formattedDate = formatter.format(date);

                  String updateQuery = "insert into transactions  VALUES('" + pin + "','" + withdrawlAmount + "','withdrawl','" + formattedDate + "')";
                  c.s.executeUpdate(updateQuery);

                  String updateBalanceQuery = "update accounts set balance=balance-" + withdrawlAmount + " where pin='" + pin + "'";
                  c.s.executeUpdate(updateBalanceQuery);

                  JOptionPane.showMessageDialog(null, "Rs. " + withdrawlAmount + " withdrawn successfully");
                  setVisible(false);
                  new atm(pin).setVisible(true);
               }
            } catch (Exception e) {
               System.out.println(e);
            }
         }
      } else if (ae.getSource() == back) {
         setVisible(false);
         new atm(pin).setVisible(true);
      }
   }

   public static void main(String[] args) {
      new withdrawl("");
   }
}
