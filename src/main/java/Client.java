import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    Socket as = null;

    void Executer() {

        try {
            as = new Socket(InetAddress.getLocalHost(), 4000);
            System.out.println("Client: Connexion établie");

            while (true) {
                DataOutputStream out = new DataOutputStream(as.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(as.getInputStream()));
                BufferedReader line = new BufferedReader(new InputStreamReader(System.in));

                String sentence = line.readLine() + "\n";
                if (sentence.equals("exit\n")) {
                    System.out.println("Client Exit");
                    out.writeBytes("exit");
                    as.close();
                    return;
                } else {
                    out.writeBytes(sentence);
                    System.out.println("Message envoyé");
                    String response = in.readLine();
                    if (response != null) {
                        System.out.println("Message reçu : " + response);
                    }else{
                        System.out.println("Message null");
                        as.close();
                        return;
                    }
                }

            }
        } catch (UnknownHostException ex) {
            System.exit(-1);
        } catch (IOException ex) {
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.Executer();
    }

}
