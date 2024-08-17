import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class atm extends JFrame implements ActionListener {
   JButton deposit, withdrawl, fastcash, mini, pin, balance, exit;
   String p;

   atm(String p) {
      this.p = p;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel img = new JLabel(i3);
      add(img);

      JLabel text = new JLabel("Select Your Transaction");
      text.setBounds(180, 260, 300, 30);
      text.setFont(new Font("osward", Font.BOLD, 20));
      text.setForeground(Color.white);
      img.add(text);

      deposit = new JButton("DEPOSIT");
      deposit.setBounds(140, 350, 100, 30);
      deposit.setBackground(Color.gray);
      deposit.setForeground(Color.white);
      deposit.addActionListener(this);
      img.add(deposit);

      withdrawl = new JButton("CASH WITHDRAWL");
      withdrawl.setBounds(290, 350, 150, 30);
      withdrawl.setBackground(Color.gray);
      withdrawl.setForeground(Color.white);
      withdrawl.addActionListener(this);
      img.add(withdrawl);

      fastcash = new JButton("FAST CASH");
      fastcash.setBounds(140, 390, 100, 30);
      fastcash.setBackground(Color.gray);
      fastcash.setForeground(Color.white);
      fastcash.addActionListener(this);
      img.add(fastcash);

      mini = new JButton("MINI STATEMENT");
      mini.setBounds(290, 390, 150, 30);
      mini.setBackground(Color.gray);
      mini.setForeground(Color.white);
      mini.addActionListener(this);
      img.add(mini);

      pin = new JButton("PIN CHANGE");
      pin.setBounds(140, 430, 100, 30);
      pin.setBackground(Color.gray);
      pin.setForeground(Color.white);
      pin.addActionListener(this);
      img.add(pin);

      balance = new JButton("BALANCE ENQUIRY");
      balance.setBounds(290, 310, 150, 30);
      balance.setBackground(Color.gray);
      balance.setForeground(Color.white);
      balance.addActionListener(this);
      img.add(balance);

      exit = new JButton("EXIT");
      exit.setBounds(340, 430, 100, 30);
      exit.setBackground(Color.gray);
      exit.setForeground(Color.white);
      exit.addActionListener(this);
      img.add(exit);

      setSize(800, 800);
      setLocation(600, 0);
      setUndecorated(true);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == exit) {
         System.exit(0);
      } else if (ae.getSource() == deposit) {
         setVisible(false);
         new deposit(p).setVisible(true);
      } else if (ae.getSource() == withdrawl) {
         setVisible(false);
         new withdrawl(p).setVisible(true);
      } else if (ae.getSource() == fastcash) {
         setVisible(false);
         new fastcash(p).setVisible(true);
      } else if (ae.getSource() == pin) {
         setVisible(false);
         new pinchange(p).setVisible(true);
      } else if (ae.getSource() == mini) {
         setVisible(false);
         new mini(p).setVisible(true);
      } else if (ae.getSource() == balance) {
         setVisible(false);
         new balance(p).setVisible(true);
      }
   }

   public static void main(String[] args) {
      new atm("");
   }
}
