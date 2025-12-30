package commands;

public class help {
    
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String WHITE = "\u001B[37m";
    private static final String DIM = "\u001B[2m";
    
    public static void printHelp() {
        // Header
        printHeader();
        
        // Tool Description
        printToolDescription();
        
        // Usage Section
        printUsageSection();
        
        // Commands Section
        printCommandsSection();
        
        // Footer
        printFooter();
    }
    
    private static void printHeader() {
        System.out.println();
        System.out.println(CYAN + BOLD + "╔════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + BOLD + "║" + YELLOW + BOLD + "                          TASKM v1.0.0                                  " + RESET + CYAN + BOLD + "║" + RESET);
        System.out.println(CYAN + BOLD + "╚════════════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
    
    private static void printToolDescription() {
        System.out.println(WHITE + BOLD + "DESCRIPTION:" + RESET);
        System.out.println(DIM + "  taskm is an open-source tool that aims to build a firm task tracker with a terminal interface." + RESET);
        System.out.println(DIM + "  taskm comes with many features enabling all task manipulation including adding removing editing and many other  ." + RESET);
        System.out.println();
    }
    
    private static void printUsageSection() {
        System.out.println(WHITE + BOLD + "USAGE:" + RESET);
        System.out.println(GREEN + "  taskm" + RESET + " " + YELLOW + "[command]" + RESET + " " + RESET + " " + MAGENTA + "[options]" + RESET);
        System.out.println();
    }
    
    private static void printCommandsSection() {
        System.out.println(WHITE + BOLD + "COMMANDS:" + RESET);
        System.out.println();
        
        // Command 1
        printCommand(
            "add [description]",
            "add task ",
            null
        );
        
        // Command 2
        printCommand(
            "rm <task_id>",
            "Remove a task from tasks list",
            new String[][]{
                {"--all", "remove all tasks "},
            }
        );
        
        // Command 3
        printCommand(
            "ls",
            "Display a list of tasks",
            new String[][]{
                {"--format=<format>" , "Display a list with a specific format = [ box | badge | mini ]"},
            }
        );
        
        // Command 4
        printCommand(
            "edit <task_id> [description]",
            "Edit existing task",
            null
        );
        
        // Command 5
        printCommand(
            "mark <task_id> <status>",
            "Change a task status",
            new String[][]{
                {"status = [ done | todo | inprogress ]",""}
            }
        );

        // Command 6
        printCommand(
            "help",
            "Display help information",
            new String[][]{
                {"<command>", "Show help for specific command"}
            }
        );
    }
    
    private static void printCommand(String command, String description, String[][] subcommands) {
        // Command name and description
        System.out.println(GREEN + BOLD + "  " + command + RESET);
        System.out.println(DIM + "    " + description + RESET);
        System.out.println();
        
        // Subcommands/options
        if (subcommands != null && subcommands.length > 0) {
            System.out.println(BLUE + BOLD + "    Options:" + RESET);
            for (String[] subcommand : subcommands) {
                String subcmd = subcommand[0];
                String subcmdDesc = subcommand[1];
                System.out.println(YELLOW + "      " + subcmd + RESET);
                System.out.println(DIM + "        " + subcmdDesc + RESET);
            }
            System.out.println();
        }
    }
    
    private static void printFooter() {
        System.out.println(CYAN + "────────────────────────────────────────────────────────────────────────────────────────" + RESET);
        System.out.println(DIM + "  Report issues at: https://github.com/youssef-hadroug-47/Task_Manager_Cli_Tool/issues" + RESET);
        System.out.println(CYAN + "────────────────────────────────────────────────────────────────────────────────────────" + RESET);
        System.out.println();
    }
}
