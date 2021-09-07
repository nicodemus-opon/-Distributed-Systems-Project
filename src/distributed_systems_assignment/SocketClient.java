package distributed_systems_assignment;

import java.net.*;
import java.io.*;

public class SocketClient {

    public static void main(String args[]) throws Exception {
        try (Socket s = new Socket("localhost", 5203)) {
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str2 = "", str_out = "";
            while (!str.equals("stop")) {

                str2 = din.readUTF();
                if (str2.matches("requesting : student_number,student_name,student_faculty,personal_code")) {
                    str_out = "student_number:107057,student_name: Nicodemus Opon,student_faculty: FIT,personal_code:D5t6hb70Y";
                    dout.writeUTF(str_out);
                    dout.flush();
                }
                System.out.println("Server >>" + str2);
                str = br.readLine();
            }
            dout.close();
        }
    }
}
