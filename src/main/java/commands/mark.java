package commands ;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import storage.*;

public class mark extends Storage {
     
    public mark (Storage st){storage=st.getFile();}
    
    public void markCommand(int id, String status){
        JSONArray arr = openJson();
        boolean test = false ;
        for (Object o : arr) {
            JSONObject jo  = (JSONObject)o;
    
            if (jo.get("id").toString().equals(String.valueOf(id))) {
                jo.replace("status",status);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                jo.replace("date_of_update",LocalDateTime.now().format(formatter));
                test = true;
                break;
            }
        }
        if (!test){ 
            System.err.println(" "+String.valueOf(id) + ": does not figure in your current tasks ! ");
            return ;
        }
        try (FileWriter newFile = new FileWriter(storage)){
            newFile.write(arr.toString());
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }

}
