package exceptions;

public class InvalidArgumentsException extends CommandException{
    public InvalidArgumentsException(){}
    public InvalidArgumentsException(String message){
        System.out.println("Invalid argument! : "+message);
    }
}
