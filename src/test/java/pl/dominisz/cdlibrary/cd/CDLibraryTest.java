package pl.dominisz.cdlibrary.cd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CDLibraryTest {
    private CDLibrary cdLibrary;

    @BeforeEach
    void setup() {
        Track track1 = new TrackBuilder()
                .setTitle("TTitle1")
                .setArtist("TArtist1")
                .setTime(22)
                .setGenre(Genre.CLASSICAL)
                .build();
        Track track2 = new TrackBuilder()
                .setTitle("TTitle2")
                .setArtist("TArtist2")
                .setTime(23)
                .setGenre(Genre.CLASSICAL)
                .build();
        List<Track> trackList = new ArrayList<>();
        List<Track> trackList2 = new ArrayList<>();
        trackList.add(track1);
        trackList2.add(track2);
        cdLibrary = new CDLibrary();
        cdLibrary.add(new CDBuilder()
                .setTitle("Title")
                .setAuthor("Author1")
                .setDiscCount(1)
                .setTracks(trackList)
                .setIsOriginal(true)
                .setProducer("Prod1")
                .setReleaseYear(2001)
                .setGenre(Genre.CLASSICAL)
                .build());
        cdLibrary.add(new CDBuilder()
                .setTitle("Title")
                .setAuthor("Author1")
                .setDiscCount(1)
                .setTracks(trackList2)
                .setIsOriginal(true)
                .setProducer("Prod1")
                .setReleaseYear(2001)
                .setGenre(Genre.BENGA)
                .build());
    }

    @Test
    void shouldFindCDByTrackTitle() {
        String title = "title1";
        List<CD> cdList = cdLibrary.findCDByTrackTitle(title);
        assertEquals(1, cdList.size());
        assertTrue(cdList.get(0).getTracks().stream().anyMatch(t->t.getTitle().toLowerCase().contains(title.toLowerCase())));

    }

    @Test
    void shouldFindByGenre() {
        List<CD> cdList = cdLibrary.findByGenre(Genre.CLASSICAL);

        assertEquals(1, cdList.size());
        assertEquals(cdList.get(0).getGenre(), Genre.CLASSICAL);
    }

    @Test
    void findElementByTrackTitleShouldReturnEmptyList() {
        assertTrue(cdLibrary.findCDByTrackTitle("none").isEmpty());
    }

    @Test
    void shoudFindTrackByTitle() {
        String title = "tle2";
        List<Track> actualTracks = cdLibrary.findTrackByTitle(title);

        assertEquals(1, actualTracks.size());
        assertTrue(actualTracks.get(0).getTitle().contains(title));

    }
}