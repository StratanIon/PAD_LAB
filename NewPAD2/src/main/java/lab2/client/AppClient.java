package lab2.client;

import lab2.DiscoveryClient;
import lab2.Location;
import lab2.Students;
import lab2.TransportClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


public class AppClient {
    public static void main(String[] args) {
        System.out.println("[INFO] -----------------------------------------\n" +
                "[INFO] Client is running...");

        try {
            Location location = new DiscoveryClient(
                    new InetSocketAddress("127.0.0.1", 33333))
                    .retrieveLocation();
            System.out.println("[INFO] -----------------------------------------\n" +
                    "[INFO] Discovered server: " + location);

            if (location != null) {
                showFiltered(
                        new TransportClient()
                                .getStudentsFrom(location));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showFiltered(ArrayList<Students> list) {
        System.out.println("[Result] -----------------------------------------\n" +
                "Discovered Students: " +
                list.stream()
                        .filter(e -> e.getBursa() > 500.0)
                        .sorted(Comparator.comparing(Students::getLastName))
                        .collect(Collectors.groupingBy(Students::getGrupa))
                        .toString()
        );
    }
}

