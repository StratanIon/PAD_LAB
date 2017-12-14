package lab2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import static org.apache.commons.lang3.SerializationUtils.serialize;

public class TransportListiner extends Thread {
    private int serverPort;
    private boolean isStopped;
    private boolean isAccepted;
    ServerSocket serverSocket;

    public boolean isStopped() {
        return isStopped;
    }

    public void setStopped(boolean isStopped) {
        this.isStopped = isStopped;
        if (!isAccepted) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TransportListiner(int serverPort) {
        this.serverPort = serverPort;
        isStopped = false;
    }

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(serverPort);
            while (!isStopped) {
                Socket socket = serverSocket.accept();  // Blocking call!
                // You can use non-blocking approach
                isAccepted = true;
                Students[] s = new Students[getStudents().size()];
                serialize((Students[]) getStudents().toArray(s), socket.getOutputStream());
                socket.close();
                isAccepted = false;
            }
        } catch (SocketException e) {
            System.out.println("[WARNING] ----------------------------------------- \n" +
                    "[WARNING] Waiting time expired... Socket is closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Students> getStudents() {
        return new ArrayList<Students>() {{
            add(new Students("Saca", "Marin", "TI142", 2316.5));
            add(new Students("Talpa", "Victor", "TI142", 786.7));
            add(new Students("Markitan", "Jora", "TI141", 6987.2));
            add(new Students("Stinca", "Vasile", "TI141", 843.4));
            add(new Students("Ciorici","Petru","TI144", 7658.56));
            add(new Students("Jaca","Victor","TI144", 894.54));
        }};
    }
}
