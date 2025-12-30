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
        switch (args.length){
            case 1 :
                throw new InvalidArgumentsException();
            case 2 :
                if ( args[1].equals( "--all" )){
                    ParsedArguments.add(args[1]);
                    return ;
                }
            case 3 :
                // Store possible wrong argument to print it 
                String wrong_argument = null;
                try {
                    for ( int i =1; i<args.length ; i++){
                        wrong_argument = args[i];
                        int parsedId = Integer.parseInt(args[i]);
                        
                        if (parsedId < 0)
                            throw new InvalidArgumentsException(args[i]);
                        ParsedArguments.add(args[i]);
                    }
                }
                catch (NumberFormatException e){
                    throw new InvalidArgumentsException(wrong_argument);
                }
                break;
            default : 
                throw new InvalidArgumentsException(args[3]);
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
                        throw new InvalidArgumentsException(args[1]);
                } 
                break;
            default:
                throw new InvalidArgumentsException(args[2]);
        }
    }
    private void validMark() throws InvalidArgumentsException {

        switch (args.length){
            case 1 :
                throw new InvalidArgumentsException();
            case 2 :
                throw new InvalidArgumentsException(args[1]);
            case 3 : 
                try {
                    int parsedId = Integer.parseInt(args[1]);
                    if (parsedId < 0)
                        throw new InvalidArgumentsException(args[1]);
                    ParsedArguments.add(args[1]);
                }
                catch (NumberFormatException e){
                    throw new InvalidArgumentsException(args[1]);
                }

                switch (args[2].toLowerCase()) {
                    case "todo" :
                    case "done" :
                    case "inprogress" :
                        ParsedArguments.add(args[2].toLowerCase());
                        break;
                    default :
                        throw new InvalidArgumentsException(args[2]);
                }
                break;
            default :
                throw new InvalidArgumentsException(args[3]);
        }
    }
    private void validEdit() throws InvalidArgumentsException {
        switch(args.length){
        case 1 :
            throw new InvalidArgumentsException();
        case 2 :
            throw new InvalidArgumentsException(args[1]);
        case 3 : 
            try{
            int parsedId = Integer.parseInt(args[1]);
            if (parsedId < 0)
                throw new InvalidArgumentsException(args[1]);
            ParsedArguments.add(args[1]);
            ParsedArguments.add(args[2]);
            }
            catch (NumberFormatException e){
                throw new InvalidArgumentsException(args[1]);
            }
            break;
        default :
            throw new InvalidArgumentsException(args[3]);
        }
    }
    private void validHelp() throws InvalidArgumentsException{
        if (args.length > 1)
            throw new InvalidArgumentsException(args[1]);
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

        throw new InvalidCommandException(command);
    }
    
    public void parse() throws InvalidCommandException , InvalidArgumentsException {
        if (args.length == 0 )
            return ;
        CommandCheck(args[0]);
        validArguments(MainCommand.toString());
    }
    

    public List<String> getArgs(){return new ArrayList<>(ParsedArguments);}
    public Commands getCommand(){return MainCommand;}
    
}
