package lab2.server;

import lab2.DiscoveryListener;
import lab2.TransportListiner;


import static java.util.concurrent.TimeUnit.SECONDS;
import java.net.InetSocketAddress;

public class AppServer {
    public static void main(String[] args) {
        int dataServerPort = 4444;
        if (args.length > 0) {
            dataServerPort = Integer.parseInt(args[0]);
        }

        InetSocketAddress serverLocation = new InetSocketAddress("127.0.0.1", dataServerPort);
        System.out.println("[INFO] -----------------------------------------\n" +
                "[INFO] Server is running... on " + dataServerPort);

        new DiscoveryListener(serverLocation)
                .start();

        TransportListiner transportListener = new TransportListiner(dataServerPort);
        transportListener.start();


        try {
            Thread.sleep(SECONDS.toMillis(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transportListener.setStopped(true);

    }
}

