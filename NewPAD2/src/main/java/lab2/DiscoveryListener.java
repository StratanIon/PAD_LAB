package lab2;

import java.io.IOException;
import java.net.*;

import static lab2.Protocol.PROTOCOL_GROUP_ADDRESS;
import static lab2.Protocol.PROTOCOL_GROUP_PORT;
import static org.apache.commons.lang3.SerializationUtils.deserialize;
import static org.apache.commons.lang3.SerializationUtils.serialize;

public class DiscoveryListener extends Thread {
    InetSocketAddress dataServerAddress;

    public DiscoveryListener(InetSocketAddress dataServerAddress) {
        this.dataServerAddress = dataServerAddress;
    }

    @Override
    public void run() {
        sendDataServerLocation(
                receiveClientRequest(),
                new Location(dataServerAddress));
    }


    private Location receiveClientRequest() {
        Location clientLocation = null;
        try {
            MulticastSocket s = new MulticastSocket(PROTOCOL_GROUP_PORT);
            s.joinGroup(InetAddress.getByName(PROTOCOL_GROUP_ADDRESS));

            byte buf[] = new byte[2048];
            DatagramPacket pingPacket = new DatagramPacket(buf, buf.length);
            s.receive(pingPacket);

            clientLocation = deserialize(pingPacket.getData());

            System.out.println("[INFO] -----------------------------------------\n" +
                    "[INFO] Received location request...");

            s.leaveGroup(InetAddress.getByName(PROTOCOL_GROUP_ADDRESS));
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientLocation;
    }


    private void sendDataServerLocation(Location clientLocation, Location serverLocation) {
        try {
            byte[] sendDataServerAddress = serialize(serverLocation);
            DatagramSocket clientSocket = new DatagramSocket();

            DatagramPacket pongPacket = new DatagramPacket(sendDataServerAddress,
                    sendDataServerAddress.length,
                    clientLocation.getLocation());
            clientSocket.send(pongPacket);

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
