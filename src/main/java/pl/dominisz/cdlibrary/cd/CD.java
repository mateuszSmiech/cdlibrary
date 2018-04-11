package pl.dominisz.cdlibrary.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.dominisz.cdlibrary.TimeUtils;
import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;

import java.util.List;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
@Getter
@AllArgsConstructor
public class CD {

    private String title;
    private String artist;
    private int releaseYear;
    private String producer;
    private Genre genre;
    private List<Track> tracks;
    private boolean original;
    private int discCount;

    public int getTotalTime() {
        if (tracks != null) {
            return tracks.stream()
                    .mapToInt(Track::getTime)
                    .sum();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String result =  "CD:" +'\n'+
                "title= " + title + '\n' +
                "artist= " + artist + '\n' +
                "releaseYear= " + releaseYear + '\n' +
                "producer= " + producer + '\n' +
                "genre= " + genre + '\n';
                for(int i =0;i<tracks.size();i++) {
                    result += (i+1)+ ". "+ tracks.get(i).toString();
                }
                result +=((original) ? "CD is original" : "CD is not original") +'\n'+
                        "total Time= " + TimeUtils.intTimeToString(getTotalTime())+ '\n'+
                "discCount= " + discCount + '\n';

        return result;
    }
}

