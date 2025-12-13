package taskPrinter;

import org.json.simple.JSONObject;
public class MinimalistStylePrinter extends Printer {

        public void printFormat(JSONObject json) {
            String id = json.get("id").toString();
            String desc = json.get("description").toString();
            String created = json.get("date_of_creation").toString();
            String updated = json.get("date_of_update").toString();
            String status = json.get("status").toString();
            
            System.out.println("\n" + CYAN + BOLD + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
            System.out.println(YELLOW + BOLD + "▸ ID:          " + RESET + YELLOW + id + RESET);
            System.out.println(GREEN + BOLD + "▸ Description: " + RESET + GREEN + desc + RESET);
            System.out.println(MAGENTA + BOLD + "▸ Created:     " + RESET + MAGENTA + created + RESET);
            System.out.println(MAGENTA + BOLD + "▸ Updated:     " + RESET + MAGENTA + updated + RESET);
            System.out.println(getStatusColor(status) + BOLD + "▸ Status:      " + RESET + getStatusColor(status) + BOLD + status.toUpperCase() + RESET);
            System.out.println(CYAN + BOLD + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET + "\n");
    }

}
