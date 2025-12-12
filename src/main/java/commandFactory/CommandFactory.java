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
                storage.add(new Task(Arguments.get(0)));
                break;
            case rm :
                storage.remove(Integer.parseInt(Arguments.get(0)));
                break ;
            case ls :
                storage.List__all();
                break ;
            case edit :
                storage.edit(Integer.parseInt(Arguments.get(0)), Arguments.get(1));
                break ;
            case markinp :
                storage.MarkInProgress(Integer.parseInt(Arguments.get(0)));
                break;
            case markdone:
                storage.MarkDone(Integer.parseInt(Arguments.get(0)));
                break;

        }
    }
}
