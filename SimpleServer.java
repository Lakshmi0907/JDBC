import java.io.*;
import java.net.*;
import java.sql.SQLOutput;

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("New client connected");

                PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

                String message = in.readLine();
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }
                System.out.println("Client says: " + message);
                out.println(message);
            }
            this.clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");
            int i = 0;
            while (true) {
                Socket clientSocket = serverSocket.accept();
//                (new Thread(() -> {
//                    System.out.println("new client connected");
//                })).start();
                (new Thread(new ClientHandler(clientSocket))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
