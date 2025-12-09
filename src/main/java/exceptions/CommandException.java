package exceptions ;


public class CommandException extends Exception{
    
    public CommandException(){
        System.out.println("Invalid Command");
    }
    public CommandException(String message ){
        System.out.println("Invalid Command : "+message);
    }
}
