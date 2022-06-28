package co.edu.poli.socketdb;

import co.edu.poli.socketdb.handler.ClientHandler;
import co.edu.poli.socketdb.util.DbUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class creates a Server with a serverSocket object and starts it.
 * @autor Paula Sanchez
 * @autor Diana Neira
 * @autor Ramon Barrios
 */
public class Server {

    private ServerSocket serverSocket;

    /**
     * Constructor for the Server Class
     * @param serverSocket  A server socket waits for requests to come in over the network
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Creates serverSocket object with the port where server will be listening
     * Creates a server object with the serverSocket created
     * Start the server
     *
     * @param args
     * @throws IOException to handle input or output errors
     */
    public static void main(String[] args) throws IOException, SQLException {
        try (Connection connection = DbUtil.getInstance().initDatabaseConnection()) {
            System.out.println("Esperando un cliente...");
            ServerSocket serverSocket = new ServerSocket(9999);
            Server server = new Server(serverSocket);
            server.startSocketServer();
        }
    }

    /**
     * Starts the server, it creates one {@link ClientHandler} per User in a separate {@link Thread}
     * does not return something (void)
     */
    public void startSocketServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException exception) {
            System.out.println("Error de conexión: " + exception.getMessage());
        }
    }

}
