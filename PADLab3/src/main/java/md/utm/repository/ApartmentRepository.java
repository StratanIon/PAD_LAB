package md.utm.repository;

import md.utm.model.Apartment;

import java.util.List;

public interface ApartmentRepository {
    void save(Apartment apartment);
    Apartment getApartment(int id);
    List<Apartment> getAllApartments();
}
