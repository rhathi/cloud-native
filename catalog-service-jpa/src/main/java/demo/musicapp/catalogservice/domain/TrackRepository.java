package demo.musicapp.catalogservice.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TrackRepository extends CrudRepository<Track,Long>{
    Optional<Track> findById(String trackId);
    boolean existsById(String trackId);

    @Transactional
    void deleteByTrackId(String trackId);
}
