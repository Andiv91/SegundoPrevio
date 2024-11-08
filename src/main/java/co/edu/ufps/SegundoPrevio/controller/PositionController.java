package co.edu.ufps.SegundoPrevio.controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.SegundoPrevio.entities.Position;
import co.edu.ufps.SegundoPrevio.services.PositionService;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.listAllPositions();
    }

    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable Long id) {
        return positionService.findById(id);
    }

    @PostMapping
    public Position createPosition(@RequestBody Position position) {
        return positionService.createPosition(position);
    }

    @PutMapping("/{id}")
    public Position updatePosition(@PathVariable Long id, @RequestBody Position positionDetails) {
        return positionService.updatePosition(id, positionDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable Long id) {
        positionService.deletePosition(id);
    }
}