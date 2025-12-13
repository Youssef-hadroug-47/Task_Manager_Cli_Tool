package commandFactory;

import commands.*;
import storage.*;
import java.util.List;



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
                rmCommand.rmCommand (Integer.parseInt(Arguments.get(0)));
                break ;
            case ls :
                ls lsCommand = new ls(storage);
                switch (Arguments.size()) {
                    case 1:
                        lsCommand.List__all();
                        break;
                    default:
                        lsCommand.lsCommand();
                        break;
                }
                break ;
            case edit :
                edit editCommand = new edit(storage);
                editCommand.editCommand(Integer.parseInt(Arguments.get(0)), Arguments.get(1));
                break ;
            case markinp :
                markinp markinpCommand = new markinp(storage);
                markinpCommand.markinpCommand(Integer.parseInt(Arguments.get(0)));
                break;
            case markdone:
                markdone markdoneCommand = new markdone(storage);
                markdoneCommand.markdoneCommand(Integer.parseInt(Arguments.get(0)));
                break;

        }
    }
}
