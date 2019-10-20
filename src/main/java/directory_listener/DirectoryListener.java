package directory_listener;

import directory_listener.exceptions.DirectoryDoesntExistException;
import org.jdom2.Document;
import org.jdom2.Element;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryListener {

    public static void main(String[] args) {

        new DirectoryListener().run();
    }


    private void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj ścieżkę folderu, który ma zostać zeskanowany: ");
        String directoryLocation = sc.nextLine();

        System.out.print("Gdzie umieścić plik XML z wynikami: ");
        String xmlFileLocation = sc.nextLine();

        //JDOM element
/*        Element fileCounter = new Element("file_counter");
        Document doc = new Document(fileCounter);
        doc.setRootElement(fileCounter);*/

        checkDirectoryExistence(directoryLocation, xmlFileLocation);
    }

    private void checkDirectoryExistence(String directoryLocation, String xmlFileLocation) {
        File dir = new File(directoryLocation);
        if (dir.exists()) {
            processDirectory(dir);
        } else throw new DirectoryDoesntExistException(directoryLocation);

        File outputDir = new File(xmlFileLocation);
        if (outputDir.exists()) {
            createOutputFile(xmlFileLocation);
        } else throw new DirectoryDoesntExistException(xmlFileLocation);
    }

    private void createOutputFile(String xmlFileLocation) {
        String pathWithFilename = xmlFileLocation.concat(File.separator).concat("output.xml");
        File outputFile = new File(pathWithFilename);
        outputFile.getParentFile().mkdirs();
        try {
            outputFile.createNewFile();

            //utwórz plik

            System.out.println("Plik utworzony pomyślnie!");
        } catch (IOException e) {
            System.err.println("File already exists: " + e.getMessage());
        }
    }


    private void processDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                processDirectory(file);
                String directoryName = file.getName(); //add to xml
                //print directory name
                System.out.println("\t" + directoryName);

            } else {
                String fileName = file.getName(); //add to xml
                //print files
                System.out.println(fileName);
                int numberOfFilesInDirectory = new File(file.getParent()).listFiles().length; //add to xml
                System.out.println("Number of files in dir: " + numberOfFilesInDirectory);
            }
        }

    }
}
