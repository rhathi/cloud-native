package demo.musicapp.catalogservice.domain;

public class TrackNotFoundException extends RuntimeException {
    public TrackNotFoundException(String trackId) {
        super("The book with ISBN " + trackId + " was not found.");
    }
}
