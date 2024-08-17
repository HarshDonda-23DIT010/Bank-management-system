import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class newAcount extends JFrame implements ActionListener {
   JTextField namet, fnamet, snamet, emailt, mot, addresst, cityt, statet, pnot;
   JButton next;
   JDateChooser date;
   JRadioButton male, female;
   int fnum;

   newAcount() {
      setTitle("Create a new account");
      setLayout(null);
      getContentPane().setBackground(Color.white);

      // Generate a random application number
      Random ren = new Random();
      fnum = ren.nextInt(9000) + 1000; // Ensure it's a 4-digit number
      JLabel formno = new JLabel("APPLICATION FORM NO. " + fnum);
      formno.setFont(new Font("Raleway", Font.BOLD, 38));
      formno.setBounds(140, 20, 600, 50);
      formno.setForeground(Color.red);
      add(formno);

      // Personal details label
      JLabel pdetail = new JLabel("Page 1: Personal Detail");
      pdetail.setFont(new Font("Raleway", Font.BOLD, 30));
      pdetail.setBounds(250, 80, 500, 50);
      add(pdetail);

      // Name field
      JLabel name = new JLabel("Name                :");
      name.setFont(new Font("Raleway", Font.BOLD, 26));
      name.setBounds(70, 170, 200, 30);
      add(name);
      namet = new JTextField();
      namet.setBounds(320, 170, 300, 30);
      namet.setFont(new Font("Arial", Font.BOLD, 15));
      add(namet);

      // Father's name field
      JLabel fname = new JLabel("Father's name :");
      fname.setFont(new Font("Raleway", Font.BOLD, 26));
      fname.setBounds(70, 220, 200, 30);
      add(fname);
      fnamet = new JTextField();
      fnamet.setBounds(320, 220, 300, 30);
      fnamet.setFont(new Font("Arial", Font.BOLD, 15));
      add(fnamet);

      // Surname field
      JLabel sname = new JLabel("Surname          :");
      sname.setFont(new Font("Raleway", Font.BOLD, 26));
      sname.setBounds(70, 270, 200, 30);
      add(sname);
      snamet = new JTextField();
      snamet.setBounds(320, 270, 300, 30);
      snamet.setFont(new Font("Arial", Font.BOLD, 15));
      add(snamet);

      // Date of birth field
      JLabel bdate = new JLabel("Date of birth    :");
      bdate.setFont(new Font("Raleway", Font.BOLD, 26));
      bdate.setBounds(70, 320, 200, 30);
      add(bdate);
      date = new JDateChooser();
      date.setBounds(320, 320, 300, 30);
      date.setFont(new Font("Arial", Font.BOLD, 15));
      add(date);

      // Gender selection
      JLabel gender = new JLabel("Gender             :");
      gender.setFont(new Font("Raleway", Font.BOLD, 26));
      gender.setBounds(70, 370, 200, 30);
      add(gender);
      male = new JRadioButton("Male");
      male.setBounds(320, 370, 100, 30);
      male.setBackground(Color.WHITE);
      add(male);
      female = new JRadioButton("Female");
      female.setBounds(450, 370, 100, 30);
      female.setBackground(Color.WHITE);
      add(female);
      ButtonGroup gendergroup = new ButtonGroup();
      gendergroup.add(male);
      gendergroup.add(female);

      // E-mail field
      JLabel email = new JLabel("E-mail              :");
      email.setFont(new Font("Raleway", Font.BOLD, 26));
      email.setBounds(70, 420, 200, 30);
      add(email);
      emailt = new JTextField();
      emailt.setBounds(320, 420, 300, 30);
      emailt.setFont(new Font("Arial", Font.BOLD, 15));
      add(emailt);

      // Mobile number field
      JLabel mo = new JLabel("Mobile No.         :");
      mo.setFont(new Font("Raleway", Font.BOLD, 26));
      mo.setBounds(70, 470, 200, 30);
      add(mo);
      mot = new JTextField();
      mot.setBounds(320, 470, 300, 30);
      mot.setFont(new Font("Arial", Font.BOLD, 15));
      add(mot);

      // Address field
      JLabel address = new JLabel("Address           :");
      address.setFont(new Font("Raleway", Font.BOLD, 26));
      address.setBounds(70, 520, 200, 30);
      add(address);
      addresst = new JTextField();
      addresst.setBounds(320, 520, 300, 30);
      addresst.setFont(new Font("Arial", Font.BOLD, 15));
      add(addresst);

      // City field
      JLabel city = new JLabel("City                  :");
      city.setFont(new Font("Raleway", Font.BOLD, 26));
      city.setBounds(70, 570, 200, 30);
      add(city);
      cityt = new JTextField();
      cityt.setBounds(320, 570, 300, 30);
      cityt.setFont(new Font("Arial", Font.BOLD, 15));
      add(cityt);

      // State field
      JLabel state = new JLabel("State                 :");
      state.setFont(new Font("Raleway", Font.BOLD, 26));
      state.setBounds(70, 620, 200, 30);
      add(state);
      statet = new JTextField();
      statet.setBounds(320, 620, 300, 30);
      statet.setFont(new Font("Arial", Font.BOLD, 15));
      add(statet);

      // Pin code field
      JLabel pno = new JLabel("Pin Code          :");
      pno.setFont(new Font("Raleway", Font.BOLD, 26));
      pno.setBounds(70, 670, 200, 30);
      add(pno);
      pnot = new JTextField();
      pnot.setBounds(320, 670, 300, 30);
      pnot.setFont(new Font("Arial", Font.BOLD, 15));
      add(pnot);

      // Next button
      next = new JButton("»»»");
      next.setBounds(700, 730, 100, 40);
      next.setBackground(Color.red);
      next.setForeground(Color.white);
      next.setFont(new Font("Arial", Font.BOLD, 25));
      next.addActionListener(this);
      add(next);

      // Frame settings
      setSize(850, 850);
      setLocation(550, 130);
      setUndecorated(true);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      String fnumber = "" + fnum;
      String name1 = namet.getText();
      String name2 = fnamet.getText();
      String name3 = snamet.getText();
      String mo1 = mot.getText();
      String email1 = emailt.getText();
      String address1 = addresst.getText();
      String city1 = cityt.getText();
      String state1 = statet.getText();
      String pin1 = pnot.getText();

      // Handling date conversion
      String date1 = "";
      if (date.getDate() != null) {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         date1 = sdf.format(date.getDate());
      }

      String gender1 = null;
      if (male.isSelected()) {
         gender1 = "Male";
      } else if (female.isSelected()) {
         gender1 = "Female";
      }

      try {
         // Validation checks
         if (name1.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your name");
         } else if (name2.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your father's name");
         } else if (name3.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your surname");
         } else if (mo1.length() != 10) {
            JOptionPane.showMessageDialog(null, "Enter your mobile number properly");
         } else if (!email1.contains("@")) {
            JOptionPane.showMessageDialog(null, "Enter your email properly");
         } else if (address1.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your address");
         } else if (city1.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your city name");
         } else if (state1.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your state name");
         } else if (pin1.length() != 6) {
            JOptionPane.showMessageDialog(null, "Enter your pin code");
         } else if (date1.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your birth date");
         } else if (gender1
== null) {
            JOptionPane.showMessageDialog(null, "Enter your gender type");
         } else {
            connection c = new connection();
            String qurey = "insert into acounts values('" + fnumber + "','" + name1 + "','" + name2 + "','" + name3
                  + "','" + mo1 + "','" + email1 + "','" + gender1 + "','" + date1 + "','" + address1 + "','" + city1
                  + "','" + state1 + "','" + pin1 + "')";
            c.s.executeUpdate(qurey);

            setVisible(false);
            new newpage2(fnumber).setVisible(true);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   public static void main(String[] args) {
      new newAcount();

   }
}
