package commands ;

import storage.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class ls extends Storage {

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

                System.out.println(oj.get("id")+" "+oj.get("date_of_creation")+" "+oj.get("date_of_update")+" ->"+oj.get("description")+" : "+oj.get("status"));
            }
        }
    }

}
