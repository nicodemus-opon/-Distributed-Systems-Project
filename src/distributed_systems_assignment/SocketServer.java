package distributed_systems_assignment;

import java.net.*;
import java.io.*;

public class SocketServer {

    public static void main(String args[]) throws Exception {
        try (ServerSocket ss = new ServerSocket(5203)) {
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Server running....");
            String str = "", str2 = "",request_str="requesting : student_number,student_name,student_faculty,personal_code";
            while (!str.equals("stop")) {
                
                
                System.out.println(request_str);
                dout.writeUTF(request_str);
                dout.flush();
                str = din.readUTF();
                System.out.println("client >>" + str);
                System.out.println("communication sucessful");
                str = br.readLine();
            }   din.close();
            s.close();
        }
    }
}
