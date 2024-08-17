// package bank.manegement.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class login extends JFrame implements ActionListener{
   JButton enter,clear,newb;
   JTextField cnum1;
   JPasswordField pin1;
   login(){
      setTitle("Automated Teller Machine");
      setLayout(null);  //it is use to display dimention null
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img/logo.jpeg")); //it is use to import image
      Image i2=i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT); //edit image 
      ImageIcon i3=new ImageIcon(i2); //imporrt edited img
      JLabel label=new JLabel(i3); //create lable for put image
      label.setBounds(30, 30, 70, 70); //set image location
      add(label); //add image
      getContentPane().setBackground(Color.white);

      //for welcome to atm
      JLabel text=new JLabel("Welcome to ATM");
      text.setBounds(140,20,500,100);
      text.setFont(new Font("osward",Font.BOLD,38));
      add(text);

      //card number
      JLabel cnum=new JLabel("Card Number  :");
      cnum.setBounds(50,130,220,100);
      cnum.setFont(new Font("osward",Font.BOLD,28));
      add(cnum);
      //card text fild
       cnum1=new JTextField();
      cnum1.setBounds(290,170,220,30);
      cnum1.setFont(new Font("Arial",Font.BOLD,15));
      add(cnum1);

      //pin number
      JLabel pin=new JLabel("Pin Number    :");
      pin.setBounds(50,200,220,100);
      pin.setFont(new Font("osward",Font.BOLD,28));
      add(pin);
      //pin text fild
       pin1=new JPasswordField();
      pin1.setBounds(290,240,220,30);
      pin1.setFont(new Font("Arial",Font.BOLD,15));
      add(pin1);

      //buttens enter
       enter=new JButton("ENTER");
      enter.setBounds(100,310,150,40);
      enter.setBackground(Color.red);
      enter.setForeground(Color.white);
      enter.addActionListener(this); //for give action
      add(enter);
      //butten for clear;
       clear=new JButton("CLEAR");
      clear.setBounds(300,310,150,40);
      clear.setBackground(Color.red);
      clear.setForeground(Color.white);
      clear.addActionListener(this); //for give action
      add(clear);
      //button for creat new acount
       newb=new JButton("CREAT NEW ACCOUNT");
      newb.setBounds(100,400,350,40);
      newb.setBackground(Color.red);
      newb.setForeground(Color.white);
      newb.addActionListener(this);//for give action
      add(newb);


      setSize(580,540);
      setVisible(true);
      setLocation(650,250);
      
   }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==enter){
         String cnum=cnum1.getText();
         String pin=pin1.getText();
         connection c=new connection();
         String qurey="select * from Acountno where acount_number='"+cnum+"' and pin_number='"+pin+"';";
         try{
            ResultSet rs=c.s.executeQuery(qurey);
            if (rs.next()) {
               String que="select count from Acountno where pin_number='"+pin+"'and count='"+1+"';";
               ResultSet rs1=c.s.executeQuery(que);
               if(rs1.next()){
                  String updateBalanceQuery = "update Acountno set count = count + " + 1 + " where pin_number = '" + pin + "';";
                  c.s.executeUpdate(updateBalanceQuery);
                  setVisible(false);
                  new pinchange(pin).setVisible(true);
               }else{
                  String updateBalanceQuery = "update Acountno set count = count + " + 1 + " where pin_number = '" + pin + "';";
                  c.s.executeUpdate(updateBalanceQuery);
                  setVisible(false);
                  new atm(pin).setVisible(true);
               }
            }
            else{
               JOptionPane.showMessageDialog(null,"Invalid Account Number or Pin");
            }
         }catch(Exception e)
         {
            System.out.println(e);
         }

      }
      else if(ae.getSource()==clear){
         pin1.setText("");
         cnum1.setText("");
      }
      else if(ae.getSource()==newb){
         new newAcount().setVisible(true);
         setVisible(false);
      }
   }
   public static void main(String[] args) {
       new login();
   }
}