package storage ;
import java.time.LocalDateTime;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    //////////////////methods/////////////////////////////////////
    ///constructors////
    public Task(){
        id ++;
        status=Status.Todo;
        description="";
        createdAt=LocalDateTime.now();
        updatedAt=createdAt;
    }
    public Task(String description ){
        id ++;
        status =Status.Todo;
        description=description;
        createdAt=LocalDateTime.now();
        updatedAt=createdAt;
    }
    ////getters/////
    public short getId(){return id;}
    public Status getStatus(){return status;}
    public String getDescription(){return description;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public LocalDateTime getUpdateAt(){return updatedAt;}
    ////setters/////
    public void setStatus(Status st){status=st;}
    public void setDescription(String desc){description=desc;}
    public void setUpdatedAt(LocalDateTime date){updatedAt=date;}
    ////commands//////
    public void listTask(){
        System.out.println(status+ " : "+ description);    
    }
    public void listTask__all(){
        System.out.println(id+" : created at "+createdAt +", updated at "+updatedAt + "status : "+status+" :");
        System.out.println("** "+description);
    }
}
