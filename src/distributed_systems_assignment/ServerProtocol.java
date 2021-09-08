package distributed_systems_assignment;


public class ServerProtocol {
    
    private int state = 0;
    

    public String processInput(String In) {
        String Out = null;

        switch (state) {
            case 0:
                Out = "waiting";
                state = 0;
                break;
            case 1:
                if (In.equalsIgnoreCase("details")) {
                    
                    state = 2;
                } else {
                    Out = "Ready!";
                }   break;
            case 2:
                if (In.equalsIgnoreCase("exit")) {
                    
                    Out = "Exiting app";
                    state = 4;
                }   break;
            default:
                break;
        }
        return Out;
    }
}
