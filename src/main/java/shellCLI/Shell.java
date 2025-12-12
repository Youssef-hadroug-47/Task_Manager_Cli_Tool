package shellCLI;

import parser.Parser;
import storage.Storage;
import exceptions.*;
import commands.*;
import java.util.List;

import commandFactory.CommandFactory;
public class Shell {
    public static void main(String[] args) {
        Storage myStorage = new Storage();
        Parser parser = null;
        try { 
            parser = new Parser(args);
            parser.parse();
            Commands command = parser.getCommand();
            List<String> Arguments = parser.getArgs();
            CommandFactory commandFactory = new CommandFactory(Arguments, command, myStorage);
            commandFactory.commandGenerator();
        }
        catch (CommandException e){
            System.out.println("An error is caught !!");
            System.out.println(e.toString());
        }
    }
}
