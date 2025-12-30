package taskPrinter;

import org.json.simple.JSONObject;

abstract public class Printer {
        // ANSI color codes
        protected static final String RESET = "\u001B[0m";
        protected static final String BOLD = "\u001B[1m";
        protected static final String CYAN = "\u001B[36m";
        protected static final String GREEN = "\u001B[32m";
        protected static final String YELLOW = "\u001B[33m";
        protected static final String BLUE = "\u001B[34m";
        protected static final String MAGENTA = "\u001B[35m";
        protected static final String RED = "\u001B[31m";

        protected static String getStatusColor(String status) {

            switch (status) {
                case "done":
                    return GREEN;
                case "inprogress":
                    return YELLOW;
                case "todo":
                    return RED;
                default:
                    return BLUE;
            }
        }
        protected static String getStatusBadge(String status) {
            String color = getStatusColor(status);
            String icon = getStatusIcon(status);
            return color + BOLD + "[ " + icon + " " + status.toUpperCase() + " ]" + RESET;
        }
        protected static String getStatusIcon(String status) {
            switch (status) {
                case "done":
                    return "✓";
                case "inprogress":
                    return "⟳";
                case "todo":
                    return "✗";
                default:
                    return "◉";
            }
        }
        protected static String printDescripiton(String description) {
            if (description.length() <= 100)    
                return description;
            String editedDescription =" ";
            while(description.length() / 100 != 0){
                int idx = 100;
                while(idx != -1 && description.charAt(idx) != ' '){
                    idx--;
                }
                if (idx == -1) idx = 100;
                editedDescription += description.substring(0, idx)+"\n   ";
                description = description.substring(idx+1);
            }
            if (!description.isEmpty())
                editedDescription += description;
            return editedDescription;
        }
        public abstract void printFormat(JSONObject json);
}
