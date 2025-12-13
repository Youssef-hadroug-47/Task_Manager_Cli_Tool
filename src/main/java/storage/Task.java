package storage ;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import storage.Storage;

enum Status {
    Todo,
    InProgress,
    Done
}

public class Task {

    ///////////////////attributes///////////////////////////////////
    private int id;
    private Status status;
    private String description ;
    private String createdAt;
    private String updatedAt;
    
    //////////////////methods/////////////////////////////////////
    ///constructors////
    public Task(String description ){
        Storage st = new Storage();
        JSONArray arr = st.openJson();

        if (arr.size()==0)
            id =0;
        else {
            JSONObject lastElement = (JSONObject)arr.getLast();
            String id_string = lastElement.get("id").toString();
            id = Integer.parseInt(id_string)+1;
        }
 
        status =Status.Todo;
        this.description=description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        createdAt=LocalDateTime.now().format(formatter);
        updatedAt=createdAt;
    }
    ////getters/////
    public int getId(){return id;}
    public Status getStatus(){return status;}
    public String getDescription(){return description;}
    public String getCreatedAt(){return createdAt;}
    public String getUpdateAt(){return updatedAt;}
    ////setters/////
    public void setStatus(Status st){status=st;}
    public void setDescription(String desc){description=desc;}
    public void setUpdatedAt(String date){updatedAt=date;}
    ////commands//////
    public void listTask(){
        System.out.println(status+ " : "+ description);    
    }
    public void listTask__all(){
        System.out.println(id+" : created at "+createdAt +", updated at "+updatedAt + "status : "+status+" :");
        System.out.println("** "+description);
    }
}
