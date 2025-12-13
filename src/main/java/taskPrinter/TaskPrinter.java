package taskPrinter;

import org.json.simple.JSONObject;
public class TaskPrinter {
    
    // ANSI colors
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32;1m";
    private static final String YELLOW = "\u001B[33;1m";
    private static final String RED = "\033[1;31m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    private static final String WHITE  = "\u001B[37m";

    public static void print(JSONObject task) {
        String id = task.get("id").toString();
        String description = task.get("description").toString();
        String creationDate = task.get("date_of_creation").toString();
        String updateDate = task.get("date_of_update").toString();
        String taskStatus = task.get("status").toString();

        String statusColor = switch (taskStatus) {
            case "Done" -> GREEN;
            case "InProgress" -> YELLOW;
            case "Todo" -> RED;
            default -> RESET;
        };


        String[] labels = {
            "Status      : ",
            "Description : ",
            "Created At  : ",
            "Updated At  : "
        };

        String[] values = {
            taskStatus,
            description,
            updateDate,
            creationDate,
        };

        int width = ("Task #" + id).length();
        for (int i = 0; i < labels.length; i++) {
            width = Math.max(width, labels[i].length() + stripAnsi(values[i]).length());
        }

        width += 4; // padding

        printLine('┌', '─', '┐', width);
        printRow("","Task #" + id, width, CYAN);
        printLine('├', '─', '┤', width);


        printRow(labels[0] , values[0], width, statusColor);
        printRow(labels[1] , values[1], width, PURPLE);
        printRow(labels[2] , values [2] , width, null );
        printRow(labels[3] , values[3], width, null);
       
        

        printLine('└', '─', '┘', width);
    }

    private static void printLine(char left, char mid, char right, int width) {
        System.out.print(left);
        System.out.print(String.valueOf(mid).repeat(width));
        System.out.println(right);
    }

    private static void printRow(String label ,String value, int width, String color) {
        String clean = stripAnsi(label+value);
        int padding = width - clean.length();
        System.out.print("│ ");
        System.out.print(label);
        if (color != null) System.out.print(color);
        System.out.print(value);
        System.out.print(RESET);
        System.out.print(" ".repeat(padding - 1));
        System.out.println("│");
    }

    private static String stripAnsi(String s) {
        return s.replaceAll("\\u001B\\[[;\\d]*m", "");
    }
}
