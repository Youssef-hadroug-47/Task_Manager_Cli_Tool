package taskPrinter;
import org.json.simple.JSONObject;


public class BadgeStyle extends Printer {

    public void printFormat(JSONObject json) {
        String id = json.get("id").toString();
        String desc = json.get("description").toString();
        String created = json.get("date_of_creation").toString();
        String updated = json.get("date_of_update").toString();
        String status = json.get("status").toString();
        
        System.out.println();
        System.out.println(YELLOW + BOLD + "  [ID: " + id + "]  " + RESET + getStatusBadge(status));
        System.out.println();
        System.out.println(GREEN + BOLD + "  " + printDescripiton(new String(desc)) + RESET);
        System.out.println();
        System.out.println(MAGENTA + "  ⏱  " + created + "  →  " + updated + RESET);
        System.out.println();
    }

    
}
