import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class fastcash extends JFrame implements ActionListener {
   JButton withdrawl, back, so, bso, pso, hajar;
   String pin;
   String amount = null;

   fastcash(String pin) {
      this.pin = pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel img = new JLabel(i3);
      add(img);

      JLabel text = new JLabel("Select amount you");
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
      withdrawl.setBounds(340, 430, 100, 30);
      withdrawl.setBackground(Color.gray);
      withdrawl.setForeground(Color.white);
      withdrawl.addActionListener(this);
      img.add(withdrawl);

      back = new JButton("BACK");
      back.setBounds(140, 430, 100, 30);
      back.setBackground(Color.gray);
      back.setForeground(Color.white);
      back.addActionListener(this);
      img.add(back);

      so = new JButton("100");
      so.setBounds(140, 350, 100, 30);
      so.setBackground(Color.gray);
      so.setForeground(Color.white);
      so.addActionListener(this);
      img.add(so);

      bso = new JButton("200");
      bso.setBounds(340, 350, 100, 30);
      bso.setBackground(Color.gray);
      bso.setForeground(Color.white);
      bso.addActionListener(this);
      img.add(bso);

      pso = new JButton("500");
      pso.setBounds(140, 390, 100, 30);
      pso.setBackground(Color.gray);
      pso.setForeground(Color.white);
      pso.addActionListener(this);
      img.add(pso);

      hajar = new JButton("1000");
      hajar.setBounds(340, 390, 100, 30);
      hajar.setBackground(Color.gray);
      hajar.setForeground(Color.white);
      hajar.addActionListener(this);
      img.add(hajar);

      setSize(800, 800);
      setLocation(600, 0);
      setUndecorated(true);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == so) {
         amount = "100";
      } else if (ae.getSource() == bso) {
         amount = "200";
      } else if (ae.getSource() == pso) {
         amount = "500";
      } else if (ae.getSource() == hajar) {
         amount = "1000";
      }

      if (ae.getSource() == withdrawl) {
         if (amount == null) {
            JOptionPane.showMessageDialog(null, "Please select an amount to withdraw");
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

                  String updateQuery = "insert into transactions VALUES('" + pin + "','" + withdrawlAmount + "','withdrawl','" + formattedDate + "')";
                  c.s.executeUpdate(updateQuery);

                  String updateBalanceQuery = "update accounts set balance=balance-" + withdrawlAmount + " where pin='" + pin + "'";
                  c.s.executeUpdate(updateBalanceQuery);

                  JOptionPane.showMessageDialog(null, "Rs. " + withdrawlAmount + " withdrawn successfully");
                  setVisible(false);
                  new atm(pin).setVisible(true);
               } else {
                  JOptionPane.showMessageDialog(null, "Invalid PIN or account does not exist.");
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
      new fastcash("");
   }
}
