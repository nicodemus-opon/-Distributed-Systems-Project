package distributed_systems_assignment;

import java.net.*;
import java.io.*;

public class SocketClient {

    public static void main(String args[]) throws Exception {
        try (Socket s = new Socket("localhost", 5203)) {
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String out = "", str_in = "", str_out = "";
            while (!out.equals("exit")) {

                str_in = din.readUTF();
                if (str_in.matches("requesting : student_number,student_name,student_faculty,personal_code")) {
                    System.out.println("Server >>" + str_in);
                    System.out.println("Enter details separated by commas i.e \n 107057,Nicodemus Opon,SCES,Personal_Code");
                    System.out.print(":>");
                    out = br.readLine();
                    String[] details = {"student_number", "student_name", "student_faculty", "personal_code"};
                    String[] split_out = out.split(",");
                    // accessing each element of array
                    for (int i = 0; i < split_out.length; i++) {
                        str_out += details[i] + " - "+split_out[i]+"\n";
                        
                    }

                    System.out.println("sent to server");
                    dout.writeUTF(str_out);
                    dout.flush();
                }

                out = br.readLine();
            }
            dout.close();
        }
    }
}
