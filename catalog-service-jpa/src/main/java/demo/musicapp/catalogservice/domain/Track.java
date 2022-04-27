package demo.musicapp.catalogservice.domain;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Track ID is mandatory")
    private String trackId;

    @Column(name = "title")
    @NotBlank(message = "Track name must be defined")
    private String name;

    @NotBlank(message = "Track artist must be defined")
    private String artist;

    @NotNull(message = "Track price must be defined")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Version
    private int version;

    public Track() {

    }

    public Track(Long id, String trackId, String name, String artist, Double price, Instant createdDate, Instant lastModifiedDate, int version) {
        this.id = id;
        this.trackId = trackId;
        this.name = name;
        this.artist = artist;
        this.price = price;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.version = version;
    }

    public static Track build(String trackId, String name, String artist, Double price) {
        return new Track(null, trackId, name, artist, price, null, null, 0);
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Track track = (Track) o;
        return version == track.version && id.equals(track.id) && trackId.equals(track.trackId)
                && name.equals(track.name) && artist.equals(track.artist) && price.equals(track.price)
                && createdDate.equals(track.createdDate) && lastModifiedDate.equals(track.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackId, name, artist, price, createdDate, lastModifiedDate, version);
    }

}
