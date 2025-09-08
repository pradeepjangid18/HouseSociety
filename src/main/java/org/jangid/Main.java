package org.jangid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Design and implement a simplified visitor management system with the following requirements:
// - Register multiple societies; each society maintains a list of houses (no blocks or floors).
// - The society admin can register residents into houses; each house can have multiple residents.
// - Security can create visitor approval requests (Guest, Visiting Help, Delivery) for a house.
// - Residents approve or deny requests:
//      - For Guest and Visiting Help: Approve or Deny
//      - For Delivery: Approve, Deny, or Leave at Gate

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

        SpringApplication.run(Main.class, args);
    }
}