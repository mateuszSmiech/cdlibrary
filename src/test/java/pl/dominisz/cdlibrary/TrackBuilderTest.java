package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class TrackBuilderTest {

    @Test
    void testTrackBuilder() {
        String title = "title";
        int time = 100;
        String artist = "artist";
        Genre genre = Genre.AFRICAN_HEAVY_METAL;

        Track track = new TrackBuilder()
                .setArtist(artist)
                .setTime(time)
                .setGenre(genre)
                .setTitle(title)
                .build();

        assertEquals(artist, track.getArtist());
        assertEquals(time, track.getTime());
        assertEquals(title, track.getTitle());
        assertEquals(genre, track.getGenre());
    }

}
