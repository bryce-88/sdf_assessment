package sdf;

import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Console cons = System.console();
        
        String input;
        float result;
        boolean exit = false;

        while(!exit) {
            input = cons.readLine("Welcome\n"); //assume user will type input in correct format after this
            System.out.printf("> %s", input);


        }
    }
}