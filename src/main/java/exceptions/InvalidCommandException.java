package exceptions;

public class InvalidCommandException extends CommandException {

    public InvalidCommandException(){
        System.err.println("Invalid Command:");
    }
    public InvalidCommandException(String message){
        System.err.println("Invalid Command name ! : "+message);
    }
}
