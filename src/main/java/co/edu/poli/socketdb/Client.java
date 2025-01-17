package co.edu.poli.socketdb;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * This class defines what a client does when a connection is established, listen and send messages
 *
 * @autor Paula Sanchez
 * @autor Diana Neira
 * @autor Ramon Barrios
 * @autor Andres Triana
 */
public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    /**
     * Constructor for the Class Client
     * Creates a new Client object with the attributes required
     *
     * @param socket   socket object for each client
     * @param username Identifies the logged user
     */
    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Closes the socket, and the bufferedReader and bufferedWriter
     * does not return something (void)
     *
     * @param socket
     * @param bufferedReader
     * @param bufferedWriter
     */
    public static void close(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a {@link Client} with a socket object and a username
     * the client will be listening and sending messages
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba su nombre: ");
        String username = scanner.nextLine();
        System.out.println("IP del Servidor: ");
        String IPServer = scanner.nextLine();
        System.out.println("Puerto de la conexión: ");
        int port = scanner.nextInt();
        Socket socket = new Socket(IPServer, port);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage();
    }

    /**
     * Send messages to {@link co.edu.poli.socketdb.handler.ClientHandler} while socket is connected
     * if something went wrong closeEverything method is called to close socket and buffers
     * does not return something (void)
     */
    public void sendMessage() {
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(messageToSend); // write command
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Listen for messages from the {@link co.edu.poli.socketdb.handler.ClientHandler} in separated threads
     * implements method run from {@link Runnable} interfaces which is the argument for {@link Thread} Class
     * if something went wrong  closeEverything method is called to close socket and buffers
     * does not return something (void)
     */
    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromServer;
                while (socket.isConnected()) {
                    try {
                        messageFromServer = bufferedReader.readLine();
                        if (messageFromServer == null || messageFromServer.equalsIgnoreCase(username + ": chao")) {
                            closeEverything(socket, bufferedReader, bufferedWriter);
                            exit(1);
                        }
                        System.out.println(messageFromServer);

                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    /**
     * calls the close method
     * does not return something (void)
     *
     * @param socket
     * @param bufferedReader
     * @param bufferedWriter
     */
    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        close(socket, bufferedReader, bufferedWriter);
    }
}
