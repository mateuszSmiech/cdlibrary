package pl.dominisz.cdlibrary.cd;

import pl.dominisz.cdlibrary.track.Genre;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.script.ScriptEngine.FILENAME;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class CDLibrary {

    private List<CD> CDs = new ArrayList<>();


    public void add(CD cd) {
        CDs.add(cd);
    }

    public void saveToFile(String filename) {
        try {
            PrintWriter out = new PrintWriter(filename);
            out.println(CDs.size());
            for (CD cd:CDs) {
                saveCDToFile(out, cd);
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się zapisać pliku" + filename);

        }

    }

    private void saveCDToFile(PrintWriter out, CD cd) {
        out.println(cd.getTitle());
        out.println(cd.getArtist());
        out.println(cd.getReleaseYear());
        out.println(cd.getProducer());
        out.println(cd.getGenre());
        out.println(cd.isOriginal());
        out.println(cd.getDiscCount());
        out.println(cd.getTracks().size());
        for(Track track: cd.getTracks()) {
            saveTrackToFile(out, track);
        }
    }

    private void saveTrackToFile(PrintWriter out, Track track) {
        out.println(track.getTitle());
        out.println(track.getTime());
        out.println(track.getArtist());
        out.println(track.getGenre());
    }

    public void loadFromFile(String filename) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i <count ; i++) {
                loadCDfromFile(bufferedReader);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku "+ filename);
        }
    }

    private void loadCDfromFile(BufferedReader bufferedReader) throws IOException {
        CD cd = new CDBuilder()
                .setTitle(bufferedReader.readLine())
                .setAuthor(bufferedReader.readLine())
                .setReleaseYear(Integer.parseInt(bufferedReader.readLine()))
                .setProducer(bufferedReader.readLine())
                .setGenre(Genre.valueOf(bufferedReader.readLine()))
                .setIsOriginal(Boolean.valueOf(bufferedReader.readLine()))
                .setDiscCount(Integer.parseInt(bufferedReader.readLine()))
                .setTracks(readTracksFromFile(bufferedReader))
                .build();
        CDs.add(cd);
    }

    private List<Track> readTracksFromFile(BufferedReader bufferedReader) throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine());
        List<Track> trackList = new ArrayList<>();
        for (int i = 0; i <count ; i++) {
            trackList.add(createTrack(bufferedReader));

        }
        return trackList;
    }

    private Track createTrack(BufferedReader bufferedReader) throws IOException {

        return new TrackBuilder()
                .setTitle(bufferedReader.readLine())
                .setTime(Integer.parseInt(bufferedReader.readLine()))
                .setArtist(bufferedReader.readLine())
                .setGenre(Genre.valueOf(bufferedReader.readLine()))
                .build();
    }

    public List<CD> getCDs() {
        return CDs;
    }

    //znajduje płyty podanego artysty
    public List<CD> findByArtist(String artist) {
        String lowerCaseArtist = artist.toLowerCase();
        return CDs.stream().filter(s->s.getArtist().toLowerCase().contains(lowerCaseArtist)).collect(Collectors.toList());
    }

    public Set<String> findAllArtist() {
        return CDs.stream().map(CD::getArtist).collect(Collectors.toSet());
    }

    //znajduje płyty o tytule zawierającym podany tekst
    public List<CD> findCDByTitle(String title) {
        return CDs.stream().filter(s->s.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
        }

    public List<Track> findTrackByTitle(String title) {

        return CDs.stream().flatMap(cd -> cd.getTracks().stream().filter(s->s.getTitle().toLowerCase()
                .contains(title.toLowerCase()))).collect(Collectors.toList());

    }

    public List<CD> findCDByTrackTitle(String title) {

        return CDs.stream().filter(cd->cd.getTracks().stream().anyMatch(track->track.getTitle().toLowerCase()
                .contains(title.toLowerCase()))).collect(Collectors.toList());
    }

    //znajduje płyty
    public List<CD> findByGenre(Genre genre) {
        return CDs.stream().filter(cd->cd.getGenre().equals(genre)).collect(Collectors.toList());
    }

}
