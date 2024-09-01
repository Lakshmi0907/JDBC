import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "rashi", "Rashi@123");
            PreparedStatement stat = conn.prepareStatement("select * from employee where id = ? and age = ?");
            for (int i = 0; i < 10; i++) {
                Scanner sc = new Scanner(System.in);
                String a = sc.nextLine();
                String b = sc.nextLine();
                stat.setInt(1, Integer.parseInt(a));
                stat.setInt(2, Integer.parseInt(b));
                ResultSet result = stat.executeQuery();
                while(result.next()){
                    System.out.println(result.getInt("id") + " " + result.getInt("age"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
