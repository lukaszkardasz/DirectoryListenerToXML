package directory_listener;

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


    }
}
