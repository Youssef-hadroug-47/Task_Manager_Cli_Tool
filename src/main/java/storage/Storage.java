package storage;
import java.io.File;
import java.io.IOException;
import org.json.simple.JsonObject;
import java.io.FileWriter;
public class Storage {
    File storage = new File("app/src/main/resources/storage.json"); 
    
    ////////////methods//////////////////////
    /////constructors//////
    public Storage(){
        try{
            boolean testCreation =storage.createNewFile();
        }
        catch (IOException e){
            System.out.println("An error just occured");
            e.printStackTrace();
        }
    }
    ////commands/////////
    public void add(Task task){
        JsonObject obj = new JsonObject();
    }
    public void remove(Task task){
        
    }
    public void edit(Task task , String description){}
    public void List__all(){}
    public void List__Today(){}
    public void List__INPROGRESS(){}
    public void List__Done(){}
    public void List__Todo(){}
    public void List__ThisWeek(){}
    public void List__d(){} //list tasks for a specific date 
    public void MarkDone(){}
    public void MarkTodo(){}
    public void MarkInProgress(){}
    
}
