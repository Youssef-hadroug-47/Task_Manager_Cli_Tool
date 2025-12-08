package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Storage {
    File storage ; 
    
    ////////////methods//////////////////////
    /////constructors//////
    public Storage(){
        storage = new File("src/main/ressources/storage.json");
        try{
            if( storage.createNewFile()){
                System.out.println("File created successfully !");
            }
            else{
                if (storage.length()==0)
                {
                    try {
                    JSONArray arrayObj= new JSONArray();
                    FileWriter newFile = new FileWriter(storage);
                    newFile.write(arrayObj.toJSONString());
                    newFile.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("File already created !");
            }
        }
        catch (IOException e){
            System.out.println("An error just occured");
            e.printStackTrace();
        }
    }
    /////methods i need ////////
    private JSONObject taskToJsonObject(Task task){
        Map<String,String> taskMap = new HashMap<String,String>(Map.of(
                "id",String.valueOf(task.getId()),
                "description", task.getDescription(),
                "status", task.getStatus().toString(),
                "date_of_creation " , task.getCreatedAt(),
                "date_of_update  " , task.getUpdateAt()
                    )); 
         JSONObject taskObj = new JSONObject(taskMap);

        return taskObj;
    }
    ////commands/////////

    public void add(Task task){
        JSONObject taskObj = taskToJsonObject(task) ;
        JSONParser parserObject = new JSONParser();
        try{
            FileReader JsonFile = new FileReader(storage);
            Object obj = parserObject.parse(JsonFile);
            try {
                JSONArray arrayObject = (JSONArray)obj ;
                arrayObject.add(taskObj);
                FileWriter newFile = new FileWriter(storage);
                newFile.write(arrayObject.toJSONString());
                newFile.close();
            }
            catch (Exception e) {
                if (e instanceof IOException){
                    e.printStackTrace();
                }
                System.out.println("error of json format ! ");
                System.out.println("check storage.json format !");
            }
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
    }
    public void remove(Task task){
        JSONObject taskObj = taskToJsonObject(task);
        JSONParser objParser = new JSONParser();
        try {
          FileReader file = new FileReader(storage);
          Object obj = objParser.parse(file);
          try{
            JSONArray arrayObj = (JSONArray)obj;
            arrayObj.remove(taskObj);
            FileWriter newFile = new FileWriter(storage);
            newFile.write(arrayObj.toJSONString());
            newFile.close();
          }
          catch (Exception e){
                if (e instanceof IOException){
                    e.printStackTrace();
                }
                System.out.println("error of json format ! ");
                System.out.println("check storage.json format !");
          }
       }
       catch(IOException | ParseException e){
            e.printStackTrace();
       }
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
