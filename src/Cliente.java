import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        String host = "localhost";
        DataInputStream in = null;
        DataOutputStream out = null;
        int puerto = 5000;
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket(host, puerto);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String mensajeCliente;
            String mensajeServidor;


            System.out.print("Escribe tu primer mensaje: ");
            mensajeCliente = scanner.nextLine();
            out.writeUTF(mensajeCliente);
            mensajeServidor = in.readUTF();
            System.out.println("Servidor: " + mensajeServidor);


            while (!"Soy yo".equals(mensajeServidor)) {
                System.out.println("Mensaje incorrecto, intenta de nuevo.");
                System.out.print("Escribe tu primer mensaje: ");
                mensajeCliente = scanner.nextLine();
                out.writeUTF(mensajeCliente);
                mensajeServidor = in.readUTF();
                System.out.println("Servidor: " + mensajeServidor);
            }


            System.out.print("Escribe tu segundo mensaje: ");
            mensajeCliente = scanner.nextLine();
            out.writeUTF(mensajeCliente);
            mensajeServidor = in.readUTF();
            System.out.println("Servidor: " + mensajeServidor);


            while (!"A ti".equals(mensajeServidor)) {
                System.out.println("Mensaje incorrecto, intenta de nuevo.");
                System.out.print("Escribe tu segundo mensaje: ");
                mensajeCliente = scanner.nextLine();
                out.writeUTF(mensajeCliente);
                mensajeServidor = in.readUTF();
                System.out.println("Servidor: " + mensajeServidor);
            }


            System.out.print("Escribe tu tercer mensaje: ");
            mensajeCliente = scanner.nextLine();
            out.writeUTF(mensajeCliente);
            mensajeServidor = in.readUTF();
            System.out.println("Servidor: " + mensajeServidor);


            while (!"¿Por qué?".equals(mensajeServidor)) {
                System.out.println("Mensaje incorrecto, intenta de nuevo.");
                System.out.print("Escribe tu tercer mensaje: ");
                mensajeCliente = scanner.nextLine();
                out.writeUTF(mensajeCliente);
                mensajeServidor = in.readUTF();
                System.out.println("Servidor: " + mensajeServidor);
            }


            System.out.print("Escribe tu cuarto mensaje: ");
            mensajeCliente = scanner.nextLine();
            out.writeUTF(mensajeCliente);
            mensajeServidor = in.readUTF();
            System.out.println("Servidor: " + mensajeServidor);


            while (!"Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta".equals(mensajeServidor)) {
                System.out.println("Mensaje incorrecto, intenta de nuevo.");
                System.out.print("Escribe tu cuarto mensaje: ");
                mensajeCliente = scanner.nextLine();
                out.writeUTF(mensajeCliente);
                mensajeServidor = in.readUTF();
                System.out.println("Servidor: " + mensajeServidor);
            }

            System.out.println("Conexión cerrada.");
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
