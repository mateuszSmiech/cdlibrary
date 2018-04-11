package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class CDTest {

    @Test
    void shouldReturnTotalTimeOfAllTracks() {
        Track track1 = new TrackBuilder()
                .setTime(100)
                .build();
        Track track2 = new TrackBuilder()
                .setTime(200)
                .build();
        CD cd = new CDBuilder()
                .setTrack(track1)
                .setTrack(track2)
                .build();
        int expectedTime = track1.getTime() + track2.getTime();
        assertEquals(expectedTime, cd.getTotalTime());
    }
}
