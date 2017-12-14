package lab2;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.List;

public class ServerStatus implements Serializable {
    private InetSocketAddress address;
    private List<ServerStatus> connectedNodes;
    private boolean isMaven = false;

    public ServerStatus(InetSocketAddress address) {
        this.address = address;
    }

    public void setConnectedNodes(List<ServerStatus> connectedNodes) {
        this.connectedNodes = connectedNodes;
    }

    public InetSocketAddress getInetSocketAddress() {
        return address;
    }

    public List<ServerStatus> getConnectedNodes() {
        return connectedNodes;
    }

    public boolean isMaven() {
        return isMaven;
    }

    public void setMaven(boolean maven) {
        isMaven = maven;
    }

    @Override
    public String toString() {
        return address.toString();
    }

}
