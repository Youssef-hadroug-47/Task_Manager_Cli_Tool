package commandFactory;

import commands.*;
import storage.*;
import java.util.List;
import taskPrinter.*;


public class CommandFactory {
    private final List<String> Arguments ;
    private final Commands c_Command ;
    private Storage storage ; 

    public CommandFactory(List<String> Arguments , Commands Command , Storage storage){
        this.c_Command= Command;
        this.Arguments= Arguments;
        this.storage=storage;
    }
    
    public void commandGenerator(){

        switch (c_Command){
            case add : 
                add addCommand = new add(storage);
                addCommand.addCommand(new Task(Arguments.get(0)));
                break;
            case rm :
                rm rmCommand = new rm(storage);
                if (Arguments.get(0).equals("--all"))
                    rmCommand.rm__all();
                else 
                    rmCommand.rmCommand(Integer.parseInt(Arguments.get(0)));
                break ;
            case ls :
                ls lsCommand = new ls(storage);
                Printer p ;
                switch (Arguments.size()) {
                    case 1:
                        switch (Arguments.get(0)) {
                            case "--format=badge":
                                p = new BadgeStyle();
                                break;
                            case "--format=box":
                                p = new BoxTaskPrinter();
                                break;
                            default :
                                p = new MinimalistStylePrinter();
                                break;
                        } 
                        lsCommand.lsCommand(p);
                        break;
                    default:
                        p = new BadgeStyle();
                        lsCommand.lsCommand(p);
                        break;
                }
                break ;
            case edit :
                edit editCommand = new edit(storage);
                editCommand.editCommand(Integer.parseInt(Arguments.get(0)), Arguments.get(1));
                break ;
            case mark :
                mark markCommand = new mark(storage);
                markCommand.markCommand(Integer.parseInt(Arguments.get(0)),Arguments.get(1));
                break;
            case null :
            case help : 
                help.printHelp();
                break;
        }
    }
}
