package directory_listener.exceptions;

public class DirectoryDoesntExistException extends RuntimeException{
    public DirectoryDoesntExistException(String directory){
        super("Directory not found: " + directory);
    }
}
