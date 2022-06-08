import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadImageFileData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");

            String query = "SELECT * FROM student_id_profile1 WHERE id=2";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            InputStream is = null;
            String os = "C:\\Development\\Java-Multithreading\\src\\main\\";
            int i=0;
            while (rs.next()){
                is = rs.getBinaryStream("student_idcard");
                System.out.println(is);
                BufferedImage inputImage = ImageIO.read(is);
                FileOutputStream outputStream = new FileOutputStream(os + "image-" + i +".jpeg");
                boolean result = ImageIO.write(inputImage, "JPEG", outputStream);
                if(result) System.out.println("Image Read and created Successfully");
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
