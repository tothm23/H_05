package kpo;

import java.util.Random;

/**
 *
 * @author Tóth Milán
 */
public class Computer {

    private String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @SuppressWarnings("empty-statement")
    public void generate() {
        // 0-2
        int szam = new Random().nextInt(3);

        switch (szam) {
            case 0 ->
                this.choice = "k";
            case 1 ->
                this.choice = "p";
            default ->
                this.choice = "o";
        };
    }

}
