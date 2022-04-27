package demo.musicapp.catalogservice.domain;

public class TrackAlreadyExistsException extends RuntimeException {

    public TrackAlreadyExistsException(String trackId) {
        super("A track with id " + trackId + " already exists.");
    }

}