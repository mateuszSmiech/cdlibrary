package pl.dominisz.cdlibrary.track;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
@Getter
@AllArgsConstructor
public class Track {

    private String title;
    private int time;
    private String artist;
    private Genre genre;

    @Override
    public String toString() {
        return "Track: " +
                "title= " + title +
                ", time= " + time +
                ", artist= " + artist +
                ", genre= " + genre.getDescription() +'\n';
    }
}
