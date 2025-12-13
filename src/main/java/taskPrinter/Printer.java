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

            switch (status.toLowerCase()) {
                case "Done":
                    return GREEN;
                case "InProgress":
                    return YELLOW;
                case "Todo":
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
                case "Done":
                    return "✓";
                case "InProgress":
                    return "⟳";
                case "Todo":
                    return "✗";
                default:
                    return "◉";
            }
        }
        public abstract void printFormat(JSONObject json);


}
