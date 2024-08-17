import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class finalAcount extends JFrame implements ActionListener {
   String fno;
   Random r;
   int pin;
   JButton canform;
   long cnum;

   finalAcount(String fno) {
      this.fno = fno;
      setTitle("Create a new account");
      setLayout(null);
      getContentPane().setBackground(Color.white);

      // Page detail
      JLabel pdetail = new JLabel("page 3 : Final Step");
      pdetail.setFont(new Font("Raleway", Font.BOLD, 30));
      pdetail.setBounds(200, 30, 500, 50);
      add(pdetail);

      r = new Random();
      pin = r.nextInt(1000, 9999); // Assign to the instance variable
      cnum = 100000000000L + (long) (r.nextDouble() * (999999999999L - 100000000000L)); // Assign to the instance variable

      JLabel cardnumber = new JLabel("Card Number :- " + cnum);
      cardnumber.setFont(new Font("Raleway", Font.BOLD, 26));
      cardnumber.setBounds(150, 100, 500, 50);
      add(cardnumber);

      JLabel pinnumber = new JLabel("Pin Number   :- " + pin);
      pinnumber.setFont(new Font("Raleway", Font.BOLD, 26));
      pinnumber.setBounds(150, 150, 500, 50);
      add(pinnumber);

      canform = new JButton("CANFORM");
      canform.setBounds(220, 250, 200, 40);
      canform.setBackground(Color.red);
      canform.setForeground(Color.white);
      canform.setFont(new Font("Arial", Font.BOLD, 25));
      canform.addActionListener(this);
      add(canform);

      setSize(700, 750);
      setLocation(600, 130);
      setUndecorated(true);
      setVisible(true);
   }
                  
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == canform) {
         try {
            String cnum1 = Long.toString(cnum);
            String pin1 = Integer.toString(pin);
            String query = "insert into Acountno values('" + fno + "','" + cnum1 + "','" + pin1 + "','1');";
            connection c = new connection(); 
            c.s.executeUpdate(query);
            setVisible(false);
            new deposit(pin1).setVisible(true);
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }
   }
          
   public static void main(String[] args) {
      new finalAcount("");
   }
}
