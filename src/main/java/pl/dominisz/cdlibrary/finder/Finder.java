package pl.dominisz.cdlibrary.finder;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDLibrary;
import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Finder {
    private CDLibrary cdLibrary;
    private Scanner scanner;


    public Finder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void findByArtist() {
        System.out.println("Enter artist to find.");
        String artist = scanner.nextLine();
        List<CD> artistList = cdLibrary.findByArtist(artist);
        for (CD cdList: artistList) {
            System.out.println(cdList);
        }
    }

    public void findAllArtists() {
        System.out.println("All artists.");
        Set<String> allArtistList = cdLibrary.findAllArtist();
        for (String cdList : allArtistList) {
            System.out.println(cdList);
        }
    }

    public void findCDThatContains() {
        System.out.println("Enter part of the Cds title.");
        String title = scanner.nextLine();
        List<CD> cdsList = cdLibrary.findCDByTitle(title);
        for (CD cdList: cdsList) {
            System.out.println(cdList);
        }
    }

    public void findTrackbyTitleThatContains() {
        System.out.println("Enter part of the Track");
        String trackTitle = scanner.nextLine();
        List<Track> trackList = cdLibrary.findTrackByTitle(trackTitle);
        for(Track tracks: trackList) {
            System.out.println(tracks);
        }
    }

    public void findCDByTrackTitle() {
        System.out.println("Enter Track title");
        String trackTitle = scanner.nextLine();
        List<CD> cdList = cdLibrary.findCDByTrackTitle(trackTitle);
        for(CD cd: cdList) {
            System.out.println(cd);
        }
    }

    public void findCDByGenre() {
        System.out.println("Enter Genre: ");
        String genreString = scanner.nextLine();
        Genre genre = Genre.valueOf(genreString);
        List<CD> cdList = cdLibrary.findByGenre(genre);
        for (CD list: cdList) {
            System.out.println(list);
        }
    }

}
