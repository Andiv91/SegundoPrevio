package co.edu.ufps.SegundoPrevio.controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.SegundoPrevio.entities.Visit;
import co.edu.ufps.SegundoPrevio.services.VisitService;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return visitService.createVisit(visit);
    }
}