package commands ;

import storage.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import taskPrinter.Printer;
public class ls extends Storage {
    
    public static final Map<String , List<String>> subCommands = new HashMap<>( Map.of(
            "--format" , List.of("box","json","minimal")            
    ));

    public ls (Storage st) {
        storage = st.getFile();
    }
    public void lsCommand (Printer p) {
        JSONArray arr =openJson();
        if (arr != null){
            for (Object o : arr){
                JSONObject oj = (JSONObject) o;
                p.printFormat(oj);
            }
        }

    }
    public void List__all(Printer p ){
        JSONArray arr =openJson();
        if (arr != null){
            for (Object o : arr){
                JSONObject oj = (JSONObject) o;        
                p.printFormat(oj);  
            }
        }
    }
    

}
