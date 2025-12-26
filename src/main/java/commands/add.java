package commands ;

import storage.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;


public class add extends Storage {
     
    public add(Storage st){
        storage = st.getFile();
        
    
    }

    public void addCommand(List<Task> tasks){
        JSONParser parserObject = new JSONParser();
        
        try( FileReader JsonFile = new FileReader(storage)){
            Object obj = parserObject.parse(JsonFile);

            try(FileWriter newFile = new FileWriter(storage)){
                JSONArray arrayObject = (JSONArray)obj ;
                for (Task task : tasks){
                    JSONObject taskObj = taskToJsonObject(task) ;
                    arrayObject.add(taskObj);
                }
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

}
