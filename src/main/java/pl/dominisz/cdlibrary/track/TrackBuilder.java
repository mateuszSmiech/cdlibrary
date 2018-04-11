package pl.dominisz.cdlibrary.track;

public class TrackBuilder {

    private String title;
    private int time;
    private String artist;
    private Genre genre;

    public TrackBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TrackBuilder setTime(int time) {
        this.time = time;
        return this;
    }

    public TrackBuilder setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public TrackBuilder setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Track build() {
        return new Track(title, time, artist, genre);
    }
}
