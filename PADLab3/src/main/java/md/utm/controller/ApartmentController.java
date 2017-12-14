package md.utm.controller;

import md.utm.model.Apartment;
import md.utm.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ApartmentController {

    private ApartmentRepository apartmentRepository;

    @Autowired
    public void setApartmentRepository(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @RequestMapping(value = "/apartments")
    public List<Apartment> getAllApartments() {
        return apartmentRepository.getAllApartments();
    }

    @RequestMapping(value = "/apartments/{id}")
    public Apartment getApartmentById(@PathVariable("id") int id) {
        return apartmentRepository.getApartment(id);
    }

    @RequestMapping(value = "/apartments", method = RequestMethod.POST)
    public void insertApartment(@RequestBody Apartment apartment) {
        apartmentRepository.save(apartment);
    }
}
