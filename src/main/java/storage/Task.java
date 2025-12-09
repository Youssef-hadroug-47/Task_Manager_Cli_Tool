package storage ;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
enum Status {
    Todo,
    InProgress,
    Done
}

public class Task {

    ///////////////////attributes///////////////////////////////////
    private static short id;
    private Status status;
    private String description ;
    private String createdAt;
    private String updatedAt;
    
    //////////////////methods/////////////////////////////////////
    ///constructors////
    public Task(){
        id ++;
        status=Status.Todo;
        description="";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        createdAt=LocalDateTime.now().format(formatter);
        updatedAt=createdAt;
    }
    public Task(String description ){
        id ++;
        status =Status.Todo;
        this.description=description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        createdAt=LocalDateTime.now().format(formatter);
        updatedAt=createdAt;
    }
    ////getters/////
    public short getId(){return id;}
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
