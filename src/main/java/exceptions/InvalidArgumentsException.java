package exceptions;

public class InvalidArgumentsException extends CommandException{
    public InvalidArgumentsException(){
        System.err.println("Invalid argument:");
    }
    public InvalidArgumentsException(String message){
        System.err.println("Invalid argument! : "+message);
    }
}
