package lab2;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class NodeConnection {
    public static final ServerStatus Node1 = new ServerStatus(new InetSocketAddress("127.0.0.1", 6001));
    public static final ServerStatus Node2 = new ServerStatus(new InetSocketAddress("127.0.0.1",6002));
    public static final ServerStatus Node3 = new ServerStatus(new InetSocketAddress("127.0.0.1", 6003));
    public static final ServerStatus Node4 = new ServerStatus(new InetSocketAddress("127.0.0.1",6004));
    public static final ServerStatus Node5 = new ServerStatus(new InetSocketAddress("127.0.0.1",6005));
    public static final ServerStatus Node6 = new ServerStatus(new InetSocketAddress("127.0.0.1",6006));

    public static final List<Students> Node1_Students = new ArrayList<Students>(){{
        add(new Students("Markitan", "Jora", "TI141", 6987.2));
        add(new Students("Stinca", "Vasile", "TI141", 843.4));
    }};

    public static final List<Students> Node2_Students = new ArrayList<Students>(){{
        add(new Students("Saca", "Marin", "TI142", 2316.5));
        add(new Students("Talpa", "Victor", "TI142", 786.7));
    }};

    public static final List<Students> Node3_Students = new ArrayList<Students>(){{
        add(new Students("Dumbrava","Maria","TI143", 7564.34));
        add(new Students("Plugaru","Anastasia","TI143", 6548.42));
    }};

    public static final List<Students> Node4_Students = new ArrayList<Students>(){{
        add(new Students("Ciorici","Petru","TI144", 7658.56));
        add(new Students("Jaca","Victor","TI144", 894.54));
    }};

    public static final List<Students> Node5_Students = new ArrayList<Students>(){{
        add(new Students("Verbitchi","Adrian","TI145", 54.324));
        add(new Students("Guzun","Mihai","TI146", 98.54));
    }};

    public static final List<Students> Node6_Students = new ArrayList<Students>(){{
        add(new Students("Stratan","Pavel","TI146", 258.43));
        add(new Students("Burcal","Dumitru","TI146", 369.32));
    }};

    public static void connectedNodes(){
        List<ServerStatus> node1Connections = new ArrayList<>();
        node1Connections.add(Node2);

        List<ServerStatus> node2Connections = new ArrayList<>();
        node2Connections.add(Node1);
        node2Connections.add(Node3);

        List<ServerStatus> node3Connections = new ArrayList<>();
        node3Connections.add(Node2);
        node3Connections.add(Node4);

        List<ServerStatus> node4Connections = new ArrayList<>();
        node4Connections.add(Node3);

        List<ServerStatus> node5Connections = new ArrayList<>();
        node5Connections.add(Node2);
        node5Connections.add(Node6);

        List<ServerStatus> node6Connections = new ArrayList<>();
        node6Connections.add(Node5);

        Node1.setConnectedNodes(node1Connections);
        Node2.setConnectedNodes(node2Connections);
        Node3.setConnectedNodes(node3Connections);
        Node4.setConnectedNodes(node4Connections);
        Node5.setConnectedNodes(node5Connections);
        Node6.setConnectedNodes(node6Connections);

    }
}
