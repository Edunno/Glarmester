/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glarmester.presentation;

import glarmester.logic.FrameType;
import static glarmester.logic.FrameType.Lavish;
import static glarmester.logic.FrameType.Ornate;
import static glarmester.logic.FrameType.Simple;
import java.util.Scanner;

/**
 *
 * @author Esben
 */
public class TUI implements UI {

    private final String TITLE = "Glarmester";
    private final String MSG_HEIGHT = "Enter height: (in cm.)";
    private final String MSG_WIDTH = "Enter width: (in cm.)";
    private final String MSG_FRAMETYPE = "Select frametype:";
    private final String MSG_PRICE = "Total price: kr. %.2f";
    private final String ERROR_MSG_NAN = "Invalid input - must be a positiv number!";
    private Scanner sc = new Scanner(System.in);

    @Override
    public double getFrameHeight() {
        return ((double) getInput(MSG_HEIGHT)) / 100.0;
    }

    @Override
    public double getFrameWidth() {
        return ((double) getInput(MSG_WIDTH)) / 100.0;
    }

    @Override
    public FrameType getFrameType() {
        String[] options = {Simple.toString(), Ornate.toString(), Lavish.toString()};
        int res;
        while (true) {
            res = getInput("Choose your frame type:\nType 1 for: " + options[0] + "\nType 2 for: " + options[1] + "\nType 3 for: " + options[2]) - 1;
            if (res == 1 || res == 0 || res == 2) {
                break;
            }
            System.out.println("Error. Try again.");
        }
        switch (res) {
            case 0:
                return Simple;
            case 1:
                return Ornate;
            case 2:
                return Lavish;
        }
        return null;
    }

    @Override
    public void displayPrice(double price) {
        System.out.println(String.format(MSG_PRICE, price)); //Kunne vist også have brugt "printf"
    }

    private int getInput(String MSG) {
        System.out.println(MSG);
        int in;
        in = sc.nextInt();
        if (in <= 0) {
            while (true) {
                System.out.println("Input is a negative number. Try again.");
                in = sc.nextInt();
                if (in > 0) {
                    break;
                }
            }
        }
        return in;
    }

}
