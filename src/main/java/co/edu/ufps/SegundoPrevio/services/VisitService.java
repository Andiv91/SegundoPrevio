package co.edu.ufps.SegundoPrevio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Visit;
import co.edu.ufps.SegundoPrevio.repositories.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisitById(int id) {
        return visitRepository.findById(id);
    }

    public Visit createVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public Visit updateVisit(int id, Visit visitDetails) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visit not found with id " + id));

        visit.setDepartment_id(visitDetails.getDepartment_id());
        visit.setEmployee_id(visitDetails.getEmployee_id());

        return visitRepository.save(visit);
    }

    public void deleteVisit(int id) {
        visitRepository.deleteById(id);
    }
}