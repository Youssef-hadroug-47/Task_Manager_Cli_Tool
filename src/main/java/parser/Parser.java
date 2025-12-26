package parser;

import commands.Commands;
import java.util.List;
import java.util.ArrayList;
import exceptions.*;

public class Parser {
    
    private String[] args ;
    private Commands MainCommand;
    private List<String> ParsedArguments ;

    //Constructor 
    public Parser(String[] args) throws InvalidCommandException{
        if (args==null)
            throw new InvalidCommandException();
        this.args= args;
        MainCommand= null;
        ParsedArguments= new ArrayList<String>(); 
    }




    //validating commands arguments  
    private void validAdd() throws InvalidArgumentsException, NumberFormatException {
        for (int i =1 ;i<args.length ;i++)
            ParsedArguments.add(args[i]);
    }
    private void validRm() throws InvalidArgumentsException {
        if ( args[1].equals( "--all" )){
            if (args.length != 2)
                throw new InvalidArgumentsException();
            ParsedArguments.add("--all");
            return ;
        }
        try {
            for ( int i =1; i<args.length ; i++){
                int parsedId = Integer.parseInt(args[i]);

                if (parsedId < 0)
                    throw new InvalidArgumentsException(args[i]);
                ParsedArguments.add(args[i]);
            }
        }
        catch (NumberFormatException e){
            throw new InvalidArgumentsException();
        }
         
    }
    private void validLs() throws InvalidArgumentsException {
        switch (args.length) {
            case 1:
                return ;
            case 2 :
                switch (args[1]) {
                    case "--format=box": case "--format=badge" : case "--format=mini":
                        ParsedArguments.add(args[1]);
                        break;
                    default:
                        throw new InvalidArgumentsException();
                } 
                break;
            default:
                throw new InvalidArgumentsException();
        }
    }
    private void validMark() throws InvalidArgumentsException {
        if (args.length != 3)
            throw new InvalidArgumentsException();
        int parsedId = Integer.parseInt(args[1]);
        if (parsedId < 0)
            throw new InvalidArgumentsException(args[1]);
        ParsedArguments.add(args[1]);
        switch (args[2]) {
            case "Todo" :
            case "Done" :
            case "InProgress" :
                ParsedArguments.add(args[2]);
                break;
            default :
                throw new InvalidArgumentsException(args[2]);
        }
    }
    private void validEdit() throws InvalidArgumentsException {
        if (args.length!=3)
            throw new InvalidArgumentsException();
        int parsedId = Integer.parseInt(args[1]);
        if (parsedId < 0)
            throw new InvalidArgumentsException(args[1]);
        ParsedArguments.add(args[1]);
        ParsedArguments.add(args[2]);
    }
    private void validHelp() throws InvalidArgumentsException{
        if (args.length!=1)
            throw new InvalidArgumentsException();
    }



    private void validArguments(String cmd) throws InvalidArgumentsException{
        switch (cmd) {
            case "add" :
                validAdd();
                break;
            case "rm" :
                validRm();
                break;
            case "ls" :
                validLs();
                break;
            case "mark" :
                validMark();
                break;
            case "edit" :
                validEdit();
                break;
            case "help" :
                validHelp();
                break;
        }
    }
    private void CommandCheck(String command) throws InvalidCommandException{
        for (Commands arg : Commands.values())
            if (arg.toString().equals(command)){
                MainCommand = arg;
                return ;
            }

        throw new InvalidCommandException();
    }
    
    public void parse() throws CommandException {
        if (args.length == 0 )
            return ;
        CommandCheck(args[0]);
        validArguments(MainCommand.toString());
    }
    

    public List<String> getArgs(){return new ArrayList<>(ParsedArguments);}
    public Commands getCommand(){return MainCommand;}
    
}
