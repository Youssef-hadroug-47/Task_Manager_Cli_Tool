package commands;
import storage.*;
public class AddCommand implements Command {
    private Task task ;
    private Storage storage ;
    public AddCommand(){}
    public AddCommand(Task t, Storage s){task=t;storage=s;}
    public void execute(){
        storage.add(task);
    } 
}
