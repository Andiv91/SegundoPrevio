package co.edu.ufps.SegundoPrevio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.SegundoPrevio.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}