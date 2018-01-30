import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket ps = null;
    Protocole p = null;

    void Executer() {
        try {
            p = new Protocole();
            ps = new ServerSocket(4000);

            while (true) {
                Socket as = ps.accept();
                System.out.println("Connexion établie.");

                while (true) {

                    BufferedReader in = new BufferedReader(new InputStreamReader(as.getInputStream()));
                    DataOutputStream out = new DataOutputStream(as.getOutputStream());

                    String msg = in.readLine();
                    if (msg == null) {
                        System.out.println("Msg null, client surement deconnecter, reset de la pile");
                        p.resetPile();
                        break;
                    }

                    System.out.println("Message reçu : " + msg);
                    if (!msg.equals("exit")) {
                        int ret = p.Protocole(msg);
                        String response = ret + "\n";
                        out.writeBytes(response);
                        System.out.println("Réponse envoyée.");
                    } else {
                        System.out.println("Client deconnecter, Reset de la pile");
                        p.resetPile();
                        break;
                    }
                }

            }


        } catch (IOException ex) {
            System.exit(-1);
        } catch (ArithmeticException e) {
            System.out.println("Division par zero non possible !");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {

        Server s = new Server();
        s.Executer();
    }

}
