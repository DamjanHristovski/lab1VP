package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Optional<Event> findAllByLocation_id(Long location_id);
    @Query("SELECT e FROM Event e WHERE e.name LIKE %:word%")
    List<Event> findAllByWord(@Param("word") String word);
    @Query("SELECT e FROM Event e WHERE e.name LIKE %:word% OR e.description LIKE %:word%")
    List<Event> searchEvents(@Param("word") String word);
}
