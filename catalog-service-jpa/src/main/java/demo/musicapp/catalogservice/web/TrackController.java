package demo.musicapp.catalogservice.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.musicapp.catalogservice.domain.Track;
import demo.musicapp.catalogservice.domain.TrackService;

@RestController
@RequestMapping("tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public Iterable<Track> get() {
        return trackService.viewTrackList();
    }

    @GetMapping("{trackId}")
    public Track getById(@PathVariable String trackId) {
        return trackService.viewTrackDetails(trackId);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Track post(@Valid @RequestBody Track track) {
        return trackService.addTrack(track);
    }

    @DeleteMapping("{trackId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String trackId) {
        trackService.removeTrack(trackId);
    }

    @PutMapping("{trackId}")
    public Track put(@PathVariable String trackId, @Valid @RequestBody Track track) {
        return trackService.editTrackDetails(trackId, track);
    }
}
