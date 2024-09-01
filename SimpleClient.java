import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8080)){
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             while(true) {
                 String a = sc.next();
                 out.println(a);
                 String response = in.readLine();
                 if (a.equalsIgnoreCase("quit"))
                 {
                     break;
                 }
                 System.out.println("Server says: " + response);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
