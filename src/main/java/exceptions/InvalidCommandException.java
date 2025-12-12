package exceptions;

public class InvalidCommandException extends CommandException {

    public InvalidCommandException(){}
    public InvalidCommandException(String message){
        System.out.println("Invalid Command name ! : "+message);
    }
}
