package shellCLI;

import parser.Parser;
import storage.Storage;
import exceptions.*;
import commands.*;
import java.util.List;

import commandFactory.CommandFactory;
public class Shell {
    public static void main(String[] args) throws InvalidArgumentsException , InvalidCommandException{
        Storage myStorage = new Storage();
        try{
            Parser parser = null;
            parser = new Parser(args);
            parser.parse();
            Commands command = parser.getCommand();
            List<String> Arguments = parser.getArgs();
            CommandFactory commandFactory = new CommandFactory(Arguments, command, myStorage);
            commandFactory.commandGenerator();
        }
        catch (InvalidCommandException | InvalidArgumentsException e){
            System.exit(1);
        }
    }
}
