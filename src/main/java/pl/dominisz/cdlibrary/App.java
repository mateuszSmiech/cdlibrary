package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.cd.CDLibrary;
import pl.dominisz.cdlibrary.finder.Finder;
import pl.dominisz.cdlibrary.menu.CDDisplay;
import pl.dominisz.cdlibrary.menu.CDReader;

import java.util.Scanner;

public class App {
    private final static String FILENAME = "cdlibrary.txt";
    private CDLibrary cdLibrary =  new CDLibrary();
    private Scanner scanner = new Scanner(System.in);
    //private CDReader CDReader = new CDReader(cdLibrary, scanner);
    private Finder finder = new Finder(cdLibrary, scanner);


    public void showMainMenu() {
        cdLibrary.loadFromFile(FILENAME);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Find CD by artist.");
            System.out.println("4. Show all artist.");
            System.out.println("5. Show all CDs by title that contains.");
            System.out.println("6. Show all track by titla that contains.");
            System.out.println("7. Show all CDs by track title.");
            System.out.println("8. Show all CDs by genre.");
            System.out.println("K. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    CDReader CDReader = new CDReader(cdLibrary, scanner);
                    CDReader.addNewCD();
                    break;
                case 2:
                    CDDisplay display = new CDDisplay();
                    display.show(cdLibrary.getCDs());
                    break;
                case 3:
                    finder.findByArtist();
                    break;
                case 4:
                    finder.findAllArtists();
                    break;
                case 5:
                    finder.findCDThatContains();
                    break;
                case 6:
                    finder.findTrackbyTitleThatContains();
                    break;
                case 7:
                    finder.findCDByTrackTitle();
                    break;
                case 8:
                    finder.findCDByGenre();
                    break;
                default:
                    exit = true;
            }
        }
        cdLibrary.saveToFile(FILENAME);
    }


    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
