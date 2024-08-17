import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class deposit extends JFrame implements ActionListener {
   JTextField deposit1;
   JButton deposit, back;
   String pin;

   deposit(String pin) {
      this.pin = pin;
      // Commenting out the image part for debugging
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel img = new JLabel(i3);  // Simple label
      add(img);

      JLabel text = new JLabel("Enter an amount you");
      text.setBounds(180, 260, 500, 30);
      text.setFont(new Font("osward", Font.BOLD, 20));
      text.setBackground(Color.gray);
      text.setForeground(Color.white);
      img.add(text);

      JLabel text1 = new JLabel("want to deposit.");
      text1.setBounds(200, 290, 500, 30);
      text1.setFont(new Font("osward", Font.BOLD, 20));
      text1.setBackground(Color.gray);
      text1.setForeground(Color.white);
      img.add(text1);

      deposit = new JButton("DEPOSIT");
      deposit.setBounds(340, 420, 100, 30);
      deposit.setBackground(Color.gray);
      deposit.setForeground(Color.white);
      deposit.addActionListener(this);
      img.add(deposit);

      back = new JButton("BACK");
      back.setBounds(140, 420, 100, 30);
      back.setBackground(Color.gray);
      back.setForeground(Color.white);
      back.addActionListener(this);
      img.add(back);

      deposit1 = new JTextField();
      deposit1.setBounds(180, 350, 200, 30);
      img.add(deposit1);

      setSize(800, 800);
      setLocation(600, 0);
      // Commenting out for testing
      // setUndecorated(true);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == deposit) {
         String amount = deposit1.getText();

         if (amount.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter an amount");
         } else {
            try {
               connection c = new connection();
               double depositAmount = Double.parseDouble(amount);

               String pinCheckQuery = "select * from accounts where pin = '" + pin + "'";
               ResultSet rs = c.s.executeQuery(pinCheckQuery);

               if (!rs.next()) {
                  String enter = "insert into accounts values('" + pin + "','" + amount + "');";
                  c.s.executeUpdate(enter);
               } else {
                  String updateBalanceQuery = "update accounts set balance = balance + " + depositAmount + " where pin = '" + pin + "';";
                  c.s.executeUpdate(updateBalanceQuery);
               }

               java.util.Date date = new java.util.Date();
               SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String formattedDate = formatter.format(date);

               String query = "insert into transactions VALUES('" + pin + "','" + depositAmount + "','deposit','" + formattedDate + "');";
               c.s.executeUpdate(query);

               JOptionPane.showMessageDialog(null, "Rs. " + amount + " deposited successfully");
               setVisible(false);
               new atm(pin).setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();  // Print the stack trace for debugging
            }
         }
      } else if (ae.getSource() == back) {
         setVisible(false);
         new atm(pin).setVisible(true);
      }
   }

   public static void main(String[] args) {
      new deposit("");
   }
}
