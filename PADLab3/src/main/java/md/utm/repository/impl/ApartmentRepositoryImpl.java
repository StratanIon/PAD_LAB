package md.utm.repository.impl;

import md.utm.model.Apartment;
import md.utm.repository.ApartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    private List<Apartment> apartmentList = new ArrayList<Apartment>(Arrays.asList(
            new Apartment(atomicInteger.incrementAndGet(), "Stefan cel mare 1/1"),
            new Apartment(atomicInteger.incrementAndGet(), "Mircea cel batran 2")
    ));

    @Override
    public void save(Apartment apartment) {
        apartmentList.add(apartment);
    }

    @Override
    public Apartment getApartment(int id) {
        return apartmentList.stream().filter(apartment -> apartment.getId() == id).findFirst().get();
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentList;
    }
}
