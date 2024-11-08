package co.edu.ufps.SegundoPrevio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Position;
import co.edu.ufps.SegundoPrevio.repositories.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Optional<Position> getPositionById(int id) {
        return positionRepository.findById(id);
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(int id, Position positionDetails) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found with id " + id));

        position.setName(positionDetails.getName());
        position.setSalary(positionDetails.getSalary());

        return positionRepository.save(position);
    }

    public void deletePosition(int id) {
        positionRepository.deleteById(id);
    }
}