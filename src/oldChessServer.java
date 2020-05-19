public class oldChessServer {

}

/**
 * import java.net.*;
 * import java.io.*;
 * import java.util.*;
 *
 * public class ChessServer {
 *
 *     static Vector<ClientHandler> ar = new Vector<ClientHandler>();
 *     static int i = 0;
 *
 *     public static void main(String[] args) throws IOException{
 *         ServerSocket ss = new ServerSocket(1234);
 *         Socket s;
 *         while(true){
 *             s = ss.accept();
 *             System.out.println("New client request received : " + s);
 *
 *             DataInputStream dis = new DataInputStream(s.getInputStream());
 *             DataOutputStream dos = new DataOutputStream(s.getOutputStream());
 *             ClientHandler ntch = new ClientHandler(s, "client" + i, dis, dos);
 *             Thread t = new Thread(ntch);
 *             System.out.println("Adding this client to active client list");
 *
 *             ar.add(ntch);
 *             t.start();
 *             i++;
 *         }
 *     }
 * }
 *
 * class ClientHandler implements Runnable{
 *     private String name;
 *     final DataInputStream dis;
 *     final DataOutputStream dos;
 *     Socket s;
 *     boolean isloggedin;
 *
 *     public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos){
 *         this.dis = dis;
 *         this.dos = dos;
 *         this.name = name;
 *         this.s = s;
 *         this.isloggedin = true;
 *     }
 *
 *     @Override
 *     public void run(){
 *         String received;
 *         while (true){
 *             try{
 *                 received = dis.readUTF();
 *                 System.out.println(received);
 *                 if(received.equals("logout")){
 *                     this.isloggedin = false;
 *                     this.s.close();
 *                     break;
 *                 }
 *
 *                 for(ClientHandler mc : ChessServer.ar) {
 *                     if (mc.isloggedin == true && !mc.name.equals(this.name)) {
 *                         mc.dos.writeUTF(received);
 *                         break;
 *                     }
 *                 }
 *             } catch (IOException e){
 *                 e.printStackTrace();
 *             }
 *         }
 *
 *         try{
 *             this.dis.close();
 *             this.dos.close();
 *         } catch(IOException e){
 *             e.printStackTrace();
 *         }
 *     }
 * }
 */
