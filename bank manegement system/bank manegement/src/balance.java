import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class balance extends JFrame implements ActionListener {
   String pin;
   JButton exit,back;
   balance(String pin) {
      this.pin = pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel img = new JLabel(i3);
      add(img);

      JLabel text = new JLabel("Total amount in");
      text.setBounds(180, 260, 500, 30);
      text.setFont(new Font("osward", Font.BOLD, 20));
      text.setForeground(Color.white);
      img.add(text);

      JLabel text1 = new JLabel("your account is :");
      text1.setBounds(180, 310, 500, 30);
      text1.setFont(new Font("osward", Font.BOLD, 20));
      text1.setForeground(Color.white);
      img.add(text1);

      JLabel text2 = new JLabel();
      text2.setBounds(180, 360, 500, 30);
      text2.setFont(new Font("osward", Font.BOLD, 20));
      text2.setForeground(Color.white);
      img.add(text2);

      try {
         connection c = new connection();
         
         String query = "SELECT balance FROM accounts WHERE pin = '" + pin + "';";
         ResultSet rs = c.s.executeQuery(query);
         
         if (rs.next()) {
            double balance = rs.getDouble("balance");
            text2.setText("Rs. " + balance);
         } else {
            text2.setText("Account not found.");
         }
      } catch (Exception e) {
        System.out.println(e);
      }

      exit = new JButton("EXIT");
      exit.setBounds(340, 430, 100, 30);
      exit.setBackground(Color.gray);
      exit.setForeground(Color.white);
      exit.addActionListener(this);
      img.add(exit);

      back = new JButton("BACK");
      back.setBounds(140, 430, 100, 30);
      back.setBackground(Color.gray);
      back.setForeground(Color.white);
      back.addActionListener(this);
      img.add(back);

      setSize(800, 800);
      setLocation(600, 0);
      setUndecorated(true);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==exit){
         System.exit(0);
      }else if(ae.getSource()==back)
      {
         setVisible(false);
         new atm(pin).setVisible(true);
      }
   }

   public static void main(String[] args) {
      new balance("");
   }
}
