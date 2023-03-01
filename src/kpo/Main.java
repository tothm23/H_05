package kpo;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Tóth Milán
 */
public class Main {

    public static int computerPoint = 0;
    public static int userPoint = 0;
    public static int wrongChoice = 0;

    private final Computer c = new Computer();
    private final User u = new User();

    public static void main(String[] args) {
        try ( Scanner in = new Scanner(System.in)) {
            Main m = new Main();

            do {
                m.c.generate();
                m.menu();

                out.print("Válassz:\t");
                m.u.setChoice(in.next());

                m.evaluate(m.c.getChoice(), m.u.getChoice());
            } while (!m.u.getChoice().equalsIgnoreCase("x"));
        }
    }

    public void evaluate(String computer, String user) {

        if (user.equalsIgnoreCase("x")) {
            System.exit(0);
        } else if (!user.equalsIgnoreCase("k")
                && !user.equalsIgnoreCase("p")
                && !user.equalsIgnoreCase("o")) {
            wrongChoice++;
            out.println("Hibás válasz! 3 hibánál kilépek!");
            out.println("Hibák száma: " + wrongChoice);
            if (wrongChoice == 3) {
                System.exit(0);
            }
        } else {
            if (computer.equalsIgnoreCase(user)) {
                out.println(computer + " - " + user);
                out.println("Döntetlen!");
            } else if (computer.equalsIgnoreCase("k")
                    && user.equalsIgnoreCase("p")
                    || computer.equalsIgnoreCase("p")
                    && user.equalsIgnoreCase("o")
                    || computer.equalsIgnoreCase("o")
                    && user.equalsIgnoreCase("k")) {
                userPoint++;
                out.println(computer + " - " + user);
                out.println("Te nyertél!");
            } else {
                computerPoint++;
                out.println(computer + " - " + user);
                out.println("A gép nyert!");
            }
            state();
        }

    }

    public void menu() {
        out.println("\n###################");
        out.println("#                 #");
        out.println("#   k kő          #");
        out.println("#   p papír       #");
        out.println("#   o olló        #");
        out.println("#   x kilépés     #");
        out.println("#                 #");
        out.println("###################\n");
    }

    public void state() {
        out.println("\nJelenlegi állás:");
        out.println(computerPoint + " - " + userPoint);
    }

}
