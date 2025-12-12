package exceptions;

public class InvalidArgumentsException extends CommandException{
    public InvalidArgumentsException(){
       super();
       System.out.println("Invalid argument !");
    }
    public InvalidArgumentsException(String message){
        super();
        System.out.println("Invalid argument! : "+message);
    }
}
