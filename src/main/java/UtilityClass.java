import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilityClass {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");

            String query = "SELECT * FROM student_info";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");
                String gender = rs.getString("gender");

                System.out.println(id + " " + name + " " + age + " " + mobile + " " + email + " " + gender);
            }

            System.out.println("Data Retrieved Successfully.");

            ps.close();
            rs.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
