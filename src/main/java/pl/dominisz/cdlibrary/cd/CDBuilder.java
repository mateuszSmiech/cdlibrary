package pl.dominisz.cdlibrary.cd;

import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class CDBuilder {

    private String title;
    private String author;
    private int releaseYear;
    private String producer;
    private Genre genre;
    private boolean isOriginal;
    private int discCount;
    private List<Track> tracks = new ArrayList<>();

    public CDBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public CDBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public CDBuilder setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public CDBuilder setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public CDBuilder setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public CDBuilder setIsOriginal(boolean isOriginal) {
        this.isOriginal = isOriginal;
        return this;
    }

    public CDBuilder setDiscCount(int discCount) {
        this.discCount = discCount;
        return this;
    }

    public CDBuilder setTrack(Track track) {
        this.tracks.add(track);
        return this;
    }

    public CDBuilder setTracks(List<Track> tracks) {
            this.tracks.addAll(tracks);
        return this;
    }

    public CD build() {
        return new CD(title, author, releaseYear, producer, genre, tracks, isOriginal, discCount);
    }
}
