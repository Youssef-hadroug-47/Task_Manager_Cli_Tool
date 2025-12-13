package commands ;

import storage.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.FileReader;

public class rm extends Storage {
    public rm (Storage st ){
        storage = st.getFile();
    }

    public void rmCommand (int id) {
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

}
