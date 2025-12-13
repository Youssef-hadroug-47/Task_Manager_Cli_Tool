package commands ;

import storage.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import taskPrinter.TaskPrinter;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
public class ls extends Storage {
    
    public static final Map<String , List<String>> subCommands = new HashMap<>( Map.of(

            "-a" , List.of(),
            "--format" , List.of("box","json","minimal")            
    ));

    public ls (Storage st) {
        storage = st.getFile();
    }
    public void lsCommand () {
        JSONArray arr =openJson();
        if (arr != null){
            for (Object o : arr){
                JSONObject oj = (JSONObject) o;

                System.out.println(oj.get("status")+" : "+oj.get("description"));
            }
        }

    }
    public void List__all(){
        JSONArray arr =openJson();
        if (arr != null){
            for (Object o : arr){
                JSONObject oj = (JSONObject) o;        
                TaskPrinter.print(oj);
            }
        }
    }

}
