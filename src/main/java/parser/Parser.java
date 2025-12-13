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
        if (args==null || args.length==0)
            throw new InvalidCommandException();
        this.args= args;
        MainCommand= null;
        ParsedArguments= new ArrayList<String>(); 
    }




    //validating commands arguments  
    private void validAdd() throws InvalidArgumentsException {
        if (args.length != 2)
            throw new InvalidArgumentsException();
        ParsedArguments.add(args[1]);
    }
    private void validRm() throws InvalidArgumentsException {
        if (args.length != 2)
            throw new InvalidArgumentsException();
        int parsedId = Integer.parseInt(args[1]);
        if (parsedId < 0)
            throw new InvalidArgumentsException(args[1]);
        ParsedArguments.add(args[1]);
    }
    private void validLs() throws InvalidArgumentsException {
        switch (args.length) {
            case 1:
                return ;
            case 2 :
                switch (args[1]) {
                    case "-a":
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
    private void validMarkdone() throws InvalidArgumentsException {
        validRm();
    }
    private void validMarkinp() throws InvalidArgumentsException {
        validRm();
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
            case "markdone" :
                validMarkdone();
                break;
            case "markinp" : 
                validMarkinp();
                break;
            case "edit" :
                validEdit();
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
        CommandCheck(args[0]);
        validArguments(MainCommand.toString());
    }
    

    public List<String> getArgs(){return new ArrayList<>(ParsedArguments);}
    public Commands getCommand(){return MainCommand;}
    
}
