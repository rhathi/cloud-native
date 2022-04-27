package demo.musicapp.catalogservice.demo;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import demo.musicapp.catalogservice.domain.Track;
import demo.musicapp.catalogservice.domain.TrackRepository;

@Component
@Profile("testdata")
public class TrackDataLoader {

    private final TrackRepository trackRepository;

    public TrackDataLoader(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
	public void loadTrackTestData() {
		var track1 = Track.build("t001", "Timeframe", "Iman Fandi", 1.90);
		var track2 = Track.build("t002", "Positions", "Ariana Grande", 1.90);
		trackRepository.save(track1);
		trackRepository.saveAll(List.of(track1, track2));
	}
}
