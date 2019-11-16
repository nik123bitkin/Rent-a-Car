package app;

import app.components.CommandWrapper;
import migrator.Migrator;

import java.util.Scanner;

public class Controller {
    private static CommandWrapper commandWrapper = new CommandWrapper();

    /**
     * First level validation method
     * @param command string entered by user
     * @return array with command, key and values or null, if format is incorrect
     */
    private static String[] parseCommand(String command){
        String[] temp = command.split(" ");
        return temp.length > 1
                && commandWrapper.hasCommand(temp[0])
                && commandWrapper.hasKey(temp[0], temp[1]) ? temp : null;
    }

    /**
     * Entry point of program
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Migrator mg = new Migrator();
        mg.validate();
        Scanner in = new Scanner(System.in);
        int result = 0;
        while(result != -1) {
            String command = in.nextLine();
            String[] params = parseCommand(command);
            result = params != null ? commandWrapper.execute(params) : 1;
            switch(result){
                case -1://exit
                    System.out.println("Programm finished...");
                    break;
                case 1: //command format error
                    System.out.println("Invalid command format, see help --[command]");
                    break;
                case 2:
                    System.out.println("Storage exception. Operation is not performed");
                    break;
                case 3:
                    System.out.println("Program exception. Operation is not performed");
                    break;
                default: //executed
                    break;
            }
        }
    }
}
