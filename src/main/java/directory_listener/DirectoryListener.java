package directory_listener;

import directory_listener.exceptions.DirectoryDoesntExistException;

import java.io.File;
import java.util.Scanner;

public class DirectoryListener {

    public static void main(String[] args) {
        new DirectoryListener().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj ścieżkę folderu, który ma zostać zeskanowany: ");
        String directoryLocation = sc.nextLine();

        System.out.print("\nGdzie umieścić plik XML z wynikami: ");
        String xmlFileLocation = sc.nextLine();

        //check if directory even exist
        File dir = new File(directoryLocation);
        checkDirectoryExistence(directoryLocation, dir);
    }

    private void checkDirectoryExistence(String directoryLocation, File dir) {
        if (dir.exists()) {
            processDirectory();
        } else throw new DirectoryDoesntExistException(directoryLocation);
    }

    private void processDirectory() {
        //TODO - zrobić dodatkowe sprawdzanie czy katalog do umieszczenia XMLa istnieje
    }
}
