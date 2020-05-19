import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChessClient {

    final static int ServerPort = 1234;

    public static void main(String[] args) throws IOException {

        final Scanner scn = new Scanner(System.in);
        InetAddress ip = InetAddress.getByName("localhost");


        Socket socket = new Socket(ip, ServerPort);
        System.out.println("Connected to the server");
        //there's a new random comment here

        final DataInputStream in = new DataInputStream(socket.getInputStream());
        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        final Board board = new Board();
        board.displayBoard();
        if (board.isGameOver()) {
            System.out.println(" it is breaking at the top");
        }


        Thread sendMessage = new Thread(

                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            String msg = scn.nextLine();

                            try {
                                if (!board.isGameOver()) {
                                    board.move(
                                            msg.charAt(0),
                                            Integer.parseInt(Character.toString(msg.charAt(1))),
                                            msg.charAt(3),
                                            Integer.parseInt(Character.toString(msg.charAt(4)))

                                    );
                                    board.displayBoard();
                                    out.writeUTF(msg);
                                } else {
                                    board.displayBoard();
                                    System.out.println("Game is over!");
                                    out.writeUTF(msg);
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );


        Thread readMessage = new Thread(

                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                String msg = in.readUTF();
                                if (!board.isGameOver()) {
                                    board.move(
                                            msg.charAt(0),
                                            Integer.parseInt(Character.toString(msg.charAt(1))),
                                            msg.charAt(3),
                                            Integer.parseInt(Character.toString(msg.charAt(4)))

                                    );
                                    board.displayBoard();
                                    out.writeUTF(msg);
                                } else {
                                    board.displayBoard();
                                    System.out.println("Game is over!");
                                }


                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );


        sendMessage.start();
        readMessage.start();
        if (board.isGameOver()) {
            socket.close();
        }

    }
}
