# Task Manager Cli Tool

### Main command tasks 

**Available Commands :**
* add
* rm
* show
* done
* prog

How to add a command : 
* create a class inside commands , its name must be capitalized and ends with "Command"
* add it to Commands enum 
* create a private method inside Parser.java , its name must start with "valid" that adds the valid arguments to ParsedArguments and throws exceptions in case of one 
* a case holding the command name in a string format inside validArguments method , calls the "valid%command_name" method 

