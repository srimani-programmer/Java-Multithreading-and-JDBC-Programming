import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBDataInsert {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");

            String query = "Insert into student_info(name, age, mobile, email, gender) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "Alex");
            ps.setInt(2, 41);
            ps.setString(3, "+91093038984");
            ps.setString(4, "alex@alex.com");
            ps.setString(5, "Male");

            ps.executeUpdate();

            System.out.println("Data Inserted Successfully");
            ps.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
