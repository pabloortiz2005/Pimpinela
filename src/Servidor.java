import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {

        DataInputStream in = null;
        DataOutputStream out = null;
        int puerto = 5000;
        Socket socket = null;
        ServerSocket serv;

        serv = new ServerSocket(puerto);
        System.out.println("Servidor iniciado");

        while (true) {
            socket = serv.accept();
            System.out.println("Cliente conectado");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


            String mensaje = in.readUTF();
            System.out.println("Cliente: " + mensaje);


            while (!"¿Quién es?".equals(mensaje)) {
                out.writeUTF("Error");
                mensaje = in.readUTF();
                System.out.println("Cliente: " + mensaje);
            }
            out.writeUTF("Soy yo");
            mensaje = in.readUTF();
            System.out.println("Cliente: " + mensaje);


            while (!"¿Qué vienes a buscar?".equals(mensaje)) {
                out.writeUTF("Error");
                mensaje = in.readUTF();
                System.out.println("Cliente: " + mensaje);
            }
            out.writeUTF("A ti");
            mensaje = in.readUTF();
            System.out.println("Cliente: " + mensaje);


            while (!"Ya es tarde".equals(mensaje)) {
                out.writeUTF("Error");
                mensaje = in.readUTF();
                System.out.println("Cliente: " + mensaje);
            }
            out.writeUTF("¿Por qué?");
            mensaje = in.readUTF();
            System.out.println("Cliente: " + mensaje);


            while (!"Porque ahora soy yo la que quiere estar sin ti".equals(mensaje)) {
                out.writeUTF("Error");
                mensaje = in.readUTF();
                System.out.println("Cliente: " + mensaje);
            }
            out.writeUTF("Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta");


            socket.close();
            System.out.println("Cliente desconectado");
        }
    }
}
