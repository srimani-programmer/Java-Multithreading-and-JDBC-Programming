import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentIdCardInsertion {
    public static boolean convertImg(String inputImgPath,
                                     String outputImgPath,
                                     String formatType)

            throws IOException
    {

        // Creating an object of FileInputStream to read
        FileInputStream inputStream
                = new FileInputStream(inputImgPath);

        FileOutputStream outputStream = new FileOutputStream(outputImgPath);

        // Creating an object of FileOutputStream to write
//        ByteArrayOutputStream outputStream
//                = new ByteArrayOutputStream();

        // Reading the input image from file
        BufferedImage inputImage
                = ImageIO.read(inputStream);

        // Writing to the output image in specified format
        boolean result = ImageIO.write(
                inputImage, formatType, outputStream);

      //  ByteArrayInputStream bis = new ByteArrayInputStream(outputStream.toByteArray());

//        int value;
//        String output = "";
//
//        while ((value = bis.read()) != -1){
//            output+= (char) value;
//        }



        // Closing the streams in order to avoid read write
        // operations
        outputStream.close();
        inputStream.close();

        return result;
    }

    public static void imageDriver(){

            // Here, the local directories from machine
            // is passed as in strings

            // Creating a string to store the path of image
            // to be converted
            String inputImage
                    = "C:\\Development\\Java-Multithreading\\src\\main\\panda.jpg";

            // Creating a string to
            // store path of converted image
            String outputImage
                    = "new-panda.jpeg";
            // Creating another string that will be
            // store format of converted image

            // Simply creating creating just to hold the format
            // type
            String formatType = "JPEG";

            // Try block to check for exceptions
            try {
                // result will store boolean value whether image
                // is converted successfully or not

                boolean result = convertImg(
                        inputImage, outputImage, formatType);

                if (result) {

                    // Display message when image is converted
                    // successfully
                    System.out.println(
                            "Image converted to jpeg successfully.");
//                    System.out.println(result);
//                    return result;
                }
                else {

                    // Display message when image is not
                    // converted successfully
                    System.out.println(
                            "Could not convert image.");

//                    return null;
                }
            }

            // Catch block to handle the exceptions
            catch (IOException ex) {

                // Display message when exception is thrown
                System.out.println(
                        "Error during converting image.");

                // Print the line number
                // where the exception occured
                ex.printStackTrace();
            }
//        return null;
    }

    public static void main(String[] args) {
        try{

            imageDriver();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");

            String query = "Insert into student_id_profile1(student_idcard) VALUES (?)";

            File f1 = new File("new-panda.jpeg");
            FileInputStream f = new FileInputStream(f1);

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setBinaryStream(1, f, f.available());

            ps.executeUpdate();

            System.out.println("Data Written Successfully.");

            f.close();

            f1.deleteOnExit();

            ps.close();
            conn.close();

//            File f = new File("C:\\Development\\Java-Multithreading\\src\\main\\sample.txt");
//            FileReader fr = new FileReader(f);
//            String output = "";
//            int value;
//            while ((value = fr.read()) != -1){
//               output += (char) value;
//            }
//
//            System.out.println(output);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
