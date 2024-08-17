import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pinchange extends JFrame implements ActionListener {
   String pin;
   JPasswordField new1, renew;
   JButton conform, back;

   pinchange(String pin) {
      this.pin = pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel img = new JLabel(i3);
      add(img);

      JLabel text = new JLabel("Change your pin number");
      text.setBounds(180, 260, 300, 30);
      text.setFont(new Font("osward", Font.BOLD, 20));
      text.setForeground(Color.white);
      img.add(text);

      JLabel text1 = new JLabel("Enter new pin      :");
      text1.setBounds(140, 300, 300, 30);
      text1.setFont(new Font("osward", Font.BOLD, 20));
      text1.setForeground(Color.white);
      img.add(text1);

      JLabel text2 = new JLabel("Re-enter new pin :");
      text2.setBounds(140, 340, 300, 30);
      text2.setFont(new Font("osward", Font.BOLD, 20));
      text2.setForeground(Color.white);
      img.add(text2);

      new1 = new JPasswordField();
      new1.setBounds(320, 300, 120, 30);
      new1.setFont(new Font("Arial", Font.BOLD, 15));
      img.add(new1);

      renew = new JPasswordField();
      renew.setBounds(320, 340, 120, 30);
      renew.setFont(new Font("Arial", Font.BOLD, 15));
      img.add(renew);

      conform = new JButton("CONFORM");
      conform.setBounds(340, 430, 100, 30);
      conform.setBackground(Color.gray);
      conform.setForeground(Color.white);
      conform.addActionListener(this);
      img.add(conform);

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
      if (ae.getSource() == conform) {
         String newpin = new1.getText();
         String renewpin = renew.getText();
         if (!newpin.equals(renewpin)) {
            JOptionPane.showMessageDialog(null, "Pin does not match");
         }
         if (newpin.equals("") || renewpin.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter new pin");
         }
         if (newpin.length() == 4) {
            try {
               connection c = new connection();
               String q1 = "update accounts set pin = '" + newpin + "' where pin='" + pin + "' ";
               c.s.executeUpdate(q1);
               String q2 = "update transactions set pin = '" + newpin + "' where pin='" + pin + "' ";
               c.s.executeUpdate(q2);
               String q3 = "update Acountno set pin_number = '" + newpin + "' where pin_number='" + pin + "' ";
               c.s.executeUpdate(q3);

               JOptionPane.showMessageDialog(null, "Pin changed successfully");

               setVisible(false);
               new atm(newpin).setVisible(true);

            } catch (Exception e) {
               System.out.println(e);
            }
         } else {
            JOptionPane.showMessageDialog(null, "Pin should be 4 digit");
         }

      } else if (ae.getSource() == back) {
         setVisible(false);
         new atm(pin).setVisible(true);
      }
   }

   public static void main(String[] args) {
      new pinchange("1234");
   }
}
