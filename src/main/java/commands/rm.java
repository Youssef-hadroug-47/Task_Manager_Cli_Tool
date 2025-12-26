package commands ;

import storage.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class rm extends Storage {

    public static final Map<String ,List<String> > subCommands = new HashMap<>(Map.of(

            "-a", List.of()
                ));


    public rm (Storage st ){
        storage = st.getFile();
    }
    

    public void rmCommand (List<String> ids) {

        JSONParser objParser = new JSONParser();
        try ( FileReader file = new FileReader(storage)){

            Object obj = objParser.parse(file);
            JSONArray arrayObj = (JSONArray)obj;

            for (String stringId : ids){
                int id = Integer.parseInt(stringId);           
                
                JSONObject taskObj = idToJsonobject(id);
                if (taskObj == null ){
                    System.err.println(" "+String.valueOf(id) + ": does not figure in your current tasks ! ");
                    continue;
                }
                arrayObj.remove(taskObj);
            }
                
            try(FileWriter newFile = new FileWriter(storage)){
                newFile.write(arrayObj.toJSONString());
            }

            catch (IOException e){
                System.out.println("error of json format ! ");
                System.out.println("check storage.json format !");
                System.out.println(e.toString());
            }
        }
        catch(IOException e){
            System.out.println("An error just occured !!");
            System.out.println(e.toString());
        }
       catch(ParseException e){
            System.out.println(e.toString());
       }

    }
    public void rm__all()  {
        try(FileWriter f = new FileWriter(storage,false)){
        }
        catch(IOException e){
            System.out.println("error !!");
            System.out.println(e.toString());
        }
    }

}
