import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class newpage2 extends JFrame implements ActionListener{
   JTextField adhart,pant;
   JComboBox type;
   JButton submit;
   String fno;
   newpage2(String fno)
   {
      this.fno=fno;
      setTitle("Create a new account");
      setLayout(null);
      getContentPane().setBackground(Color.white);

      // for aditinal detail
      JLabel pdetail = new JLabel("page 2 : Additional Detail");
      pdetail.setFont(new Font("Raleway", Font.BOLD, 30));
      pdetail.setBounds(200, 30, 500, 50);
      add(pdetail);

      //adhar
      JLabel adhar = new JLabel("Adhar Number  :");
      adhar.setFont(new Font("Raleway", Font.BOLD, 26));
      adhar.setBounds(70, 150, 230, 30);
      add(adhar);
      adhart = new JTextField();
      adhart.setBounds(320, 150, 300, 30);
      adhart.setFont(new Font("Arial", Font.BOLD, 15));
      add(adhart);


      //pannumber
      JLabel pan = new JLabel("Pan Number      :");
      pan.setFont(new Font("Raleway", Font.BOLD, 26));
      pan.setBounds(70, 200, 230, 30);
      add(pan);
      pant = new JTextField();
      pant.setBounds(320, 200, 300, 30);
      pant.setFont(new Font("Arial", Font.BOLD, 15));
      add(pant);

      //acount type
      JLabel atype = new JLabel("Acount type      :");
      atype.setFont(new Font("Raleway", Font.BOLD, 26));
      atype.setBounds(70, 250, 230, 30);
      add(atype);
      String t[]={"Carent","Saving","Salary"};
      type=new JComboBox(t);
      type.setBounds(320, 250, 300, 30);
      add(type);
      
      //forthankyou
      JLabel thanks = new JLabel("🙏Thank you🙏");
      thanks.setFont(new Font("Raleway", Font.BOLD, 30));
      thanks.setBounds(250, 350, 500, 50);
      add(thanks);
      
      //button
      submit = new JButton("SUBMIT");
      submit.setBounds(70, 450, 550, 40);
      submit.setBackground(Color.red);
      submit.setForeground(Color.white);
      submit.setFont(new Font("Arial", Font.BOLD, 25));
      submit.addActionListener(this);
      add(submit);
      setSize(700, 750);
      setLocation(600, 130);
      setUndecorated(true);
      setVisible(true);
   }
   public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==submit) {
         String adharn = adhart.getText();
         String pann = pant.getText();
         String typ = (String) type.getSelectedItem();
         
          try{
            if (adharn.length() != 12) {
               JOptionPane.showMessageDialog(null, "Enter your adhar number properly");
            }
            if (pann.length() != 10) {
               JOptionPane.showMessageDialog(null, "Enter your pan number properly");
            }
            if (typ.equals("")) {
               JOptionPane.showMessageDialog(null, "Choose acount type");
            }
            else{
               String qurey="insert into AcountsAditionalDetail values('"+fno+"','"+adharn+"','"+pann+"','"+typ+"');";
               connection c = new connection();
               c.s.executeUpdate(qurey);

               setVisible(false);
               new finalAcount(fno).setVisible(true);
            }
         }catch(Exception e)       
         {
            System.out.println(e.getMessage());
         }
      }
   }
   public static void main(String[] args) {
       new newpage2("");
   }
}
