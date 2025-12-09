package exceptions;

public class InvalidCommandException extends CommandException {

    public InvalidCommandException(){
        super();
        System.out.println("Invalid Command name ! ");
    }
    public InvalidCommandException(String message){
        super();
        System.out.println("Invalid Command name ! : "+message);
    }
}
