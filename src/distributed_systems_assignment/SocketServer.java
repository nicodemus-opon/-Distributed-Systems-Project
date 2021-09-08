package distributed_systems_assignment;

import java.net.*;
import java.io.*;

public class SocketServer {

    public static void main(String args[]) throws Exception {
        try (ServerSocket ss = new ServerSocket(5203)) {
            System.out.println("Server running....waiting for client to connect");
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client connected....");
            String out = "", request_str = "requesting : student_number,student_name,student_faculty,personal_code";
            while (!out.equals("exit")) {

                System.out.println(request_str);
                dout.writeUTF(request_str);
                dout.flush();
                out = din.readUTF();
                System.out.println("client >>" + out);
                System.out.println("communication sucessful");
                out = br.readLine();
            }
            din.close();
            s.close();
        }
    }
}
