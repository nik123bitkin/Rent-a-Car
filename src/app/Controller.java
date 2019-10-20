package app;

import app.components.CommandWrapper;

import java.util.Scanner;

public class Controller {
    private static CommandWrapper commandWrapper = new CommandWrapper();

    private static String[] parseCommand(String command){
        String[] temp = command.split(" ");
        return temp.length > 1
                && commandWrapper.hasCommand(temp[0])
                && commandWrapper.hasKey(temp[0], temp[1]) ? temp : null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        while(result != -1) {
            String command = in.nextLine();
            String[] params = parseCommand(command);
            result = params != null ? commandWrapper.execute(params) : 1;
            switch(result){
                case -1://exit
                    break;
                case 1: //command format error
                    System.out.println("Invalid command format, see help --any");
                    break;
                default: //executed
                    break;
            }
        }
    }
}
