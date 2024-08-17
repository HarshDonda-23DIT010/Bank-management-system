import java.sql.*;
public class connection {
   Connection c;
   Statement s;
   connection()
   {
      try{
         String url="jdbc:mysql://localhost:3306/bank";
         String user="root";
         String pass="Harsh#9665";
         c=DriverManager.getConnection(url,user,pass);
         System.out.println("Connected");
         s=c.createStatement();
         
      }
      catch(Exception e)
      {
         System.out.println("Not connected");
      }
   }
   public static void main(String[] args) throws ClassNotFoundException {
       new connection();
   }
}
