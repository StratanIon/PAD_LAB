package lab2;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static org.apache.commons.lang3.SerializationUtils.deserialize;

public class TransportClient {
    public ArrayList<Students> getStudentsFrom(Location location) throws IOException {
        Socket socket = new Socket();
        socket.connect(location.getLocation());
        Students[] students = (Students[]) deserialize(socket.getInputStream());
        socket.close();
        return new ArrayList<Students>(Arrays.asList(students));
    }
}
