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
        try{
            String userHome = System.getProperty("user.home");
            storage = new File(userHome + "/MyCode/Projects/Java/Task_Manager_Cli_Tool/src/main/resources/storage.json");
            if(!storage.createNewFile()){
                if (storage.length()==0)
                {
                    try ( FileWriter newFile = new FileWriter(storage)){
                        JSONArray arrayObj= new JSONArray();
                        newFile.write(arrayObj.toJSONString());
                    }
                    catch (IOException e){
                        System.out.println(e.toString());
                    }
                } 
            }
            else{
                try ( FileWriter newFile = new FileWriter(storage)){
                        JSONArray arrayObj= new JSONArray();
                        newFile.write(arrayObj.toJSONString());
                }
                catch (IOException e){
                    System.out.println(e.toString());
                }
            }
            
        }
        catch (Exception e){
            System.out.println("Project structure corrupted !!");
            System.out.println(e.toString());
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
    private JSONObject idToJsonobject(int id){
        JSONParser parserObject = new JSONParser();
        JSONObject return_obj = null;
        
        try (FileReader JsonFile = new FileReader(storage)){
            Object obj = parserObject.parse(JsonFile);
            JSONArray arrayObject = (JSONArray)obj;

            for (Object o : arrayObject){
                JSONObject jo = (JSONObject) o;
                

                if (jo.get("id")==Integer.toString(id)){
                    return_obj = jo;
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("An error just occured !! ");
            System.out.println(e.toString());
        }


        return return_obj;
    }
    ////commands/////////

    public void add(Task task){
        
        JSONObject taskObj = taskToJsonObject(task) ;
        JSONParser parserObject = new JSONParser();
        
        try( FileReader JsonFile = new FileReader(storage)){
            Object obj = parserObject.parse(JsonFile);
            try(FileWriter newFile = new FileWriter(storage)){
                JSONArray arrayObject = (JSONArray)obj ;
                arrayObject.add(taskObj);
                newFile.write(arrayObject.toJSONString());
            }
            catch (Exception e) {
                System.out.println("error of json format ! ");
                System.out.println("check storage.json format !");
                System.out.println(e.toString());
            }
        }
        catch(Exception e){
            System.out.println("An error just occured !! ");
            System.out.println(e.toString());
        }
    }
    public void remove(int id ){
        JSONObject taskObj = idToJsonobject(id);
        JSONParser objParser = new JSONParser();
        
        try ( FileReader file = new FileReader(storage)){
            Object obj = objParser.parse(file);
            
            try(FileWriter newFile = new FileWriter(storage)){
                JSONArray arrayObj = (JSONArray)obj;
                arrayObj.remove(taskObj);
                newFile.write(arrayObj.toJSONString());
            }

            catch (Exception e){
                System.out.println("error of json format ! ");
                System.out.println("check storage.json format !");
                System.out.println(e.toString());
          }
       }
       catch(Exception e){
            System.out.println("An error just occured !!");
            System.out.println(e.toString());
       }
    }
    public void edit(int id , String description){}
    public void List__Todo(){}
    public void List__INPROGRESS(){}
    public void List__Done(){}
    public void List__all(){}
    public void List__Today(){}
    public void List__ThisWeek(){}
    public void List__d(){} //list tasks for a specific date 
    public void MarkDone(int id){}
    public void MarkTodo(int id){}
    public void MarkInProgress(int id){}
    
}
