package Exceptions;

public class InvalidCommandException extends Exception {

    public InvalidCommandException(){
        super();
        System.out.println("Invalid Command name ! ");
    }
    public InvalidCommandException(String message){
        super();
        System.out.println("Invalid Command name ! : "+message);
    }
}
