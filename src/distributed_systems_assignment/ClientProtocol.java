/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_systems_assignment;

public class ClientProtocol {

    private int state = 0;
    

    public String processInput(String In) {
        String Out = null;

        if (state == 0) {
            Out = "waiting";
            state = 0;
        } else if (state == 1) {
            if (In.equalsIgnoreCase("details")) {

                state = 2;
            } else {
                Out = "Ready!";
            }
        } else if (state == 2) {
            if (In.equalsIgnoreCase("exit")) {
                
                Out = "Exiting app";
                state = 3;
            }
        }
        return Out;
    }
}
