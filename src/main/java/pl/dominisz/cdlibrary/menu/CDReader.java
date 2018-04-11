package pl.dominisz.cdlibrary.menu;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.cd.CDLibrary;
import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CDReader {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public CDReader(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void addNewCD() {
        System.out.println("Enter CD info");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Artist:");
        String author = scanner.nextLine();
        System.out.println("Release year:");
        int releaseYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Producer:");
        String producer = scanner.nextLine();
        Genre genre = readGenre();
        List<Track> tracks = readTracks();
        System.out.println("Is original (yes/no):");
        boolean original = "yes".equals(scanner.nextLine());
        System.out.println("Disc count:");
        int discCount = Integer.parseInt(scanner.nextLine());
        CD cd = new CDBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setReleaseYear(releaseYear)
                .setProducer(producer)
                .setGenre(genre)
                .setIsOriginal(original)
                .setDiscCount(discCount)
                .setTracks(tracks)
                .build();
        cdLibrary.add(cd);
    }

    private Genre readGenre() {
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + " " + genres[i].getDescription());
        }
        System.out.println("Choose number:");
        int number = Integer.parseInt(scanner.nextLine());
        return genres[number - 1];
    }

    private List<Track> readTracks() {
        System.out.println("Enter track count:");
        int count = Integer.parseInt(scanner.nextLine());
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tracks.add(readTrack());
        }
        return tracks;


    }

    private Track readTrack() {
        System.out.println("Enter track info:");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Time (in seconds):");
        int time = Integer.parseInt(scanner.nextLine());
        System.out.println("Artist:");
        String artist = scanner.nextLine();
        Genre genre = readGenre();
        return new TrackBuilder()
                .setTitle(title)
                .setTime(time)
                .setArtist(artist)
                .setGenre(genre)
                .build();
    }
}

