package demo.musicapp.catalogservice.domain;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Iterable<Track> viewTrackList() {
        return trackRepository.findAll();
    }

    public Track viewTrackDetails(String trackId) {
        return trackRepository.findById(trackId).orElseThrow(() -> new TrackNotFoundException(trackId));
    }

    public Track addTrack(Track track) {
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistsException(track.getTrackId());
        }
        return trackRepository.save(track);
    }

    public void removeTrack(String trackId) {
        trackRepository.deleteByTrackId(trackId);
    }

    public Track editTrackDetails(String trackId, Track track) {
        Optional<Track> existingTrack = trackRepository.findById(trackId);
        if (existingTrack.isEmpty()) {
            return addTrack(track);
        }

        var trackToUpdate = existingTrack.get();
        trackToUpdate.setName(track.getName());
        trackToUpdate.setArtist(track.getArtist()); 
        trackToUpdate.setPrice(track.getPrice());

        return trackRepository.save(trackToUpdate);
    }
}
