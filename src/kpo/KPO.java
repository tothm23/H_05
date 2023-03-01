package kpo;

import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Helix
 */
public class KPO {
    
    private static int gepPontok = 0;
    private static int userPontok = 0;
    private static int hibasValasz = 0;
    
    public static void main(String[] args) {
        
        Scanner be = new Scanner(System.in);
        String userValasz;
        String gepValasz;
        
        do {
            menu();
            gepValasz = valaszGeneral();
            
            out.print("Válassz:\t");
            userValasz = be.next();
            
            kiertekel(gepValasz, userValasz);
        } while (!userValasz.equals("x"));
        be.close();
    }

    /**
     * Legenerálja a gép választását
     *
     * @return
     */
    public static String valaszGeneral() {
        // 0-2
        int szam = new Random().nextInt(3);
        
        return switch (szam) {
            case 0 ->
                "k";
            case 1 ->
                "p";
            default ->
                "o";
        };
    }

    /**
     * Kilistázza az opciókat
     */
    public static void menu() {
        out.println("\n###################");
        out.println("#                 #");
        out.println("#   k kő          #");
        out.println("#   p papír       #");
        out.println("#   o olló        #");
        out.println("#   x kilépés     #");
        out.println("#                 #");
        out.println("###################\n");
    }

    /**
     * A játék logikája
     *
     * @param gepValasz
     * @param userValasz
     */
    public static void kiertekel(String gepValasz, String userValasz) {
        
        if (userValasz.equalsIgnoreCase("x")) {
            System.exit(0);
        } else if (!userValasz.equalsIgnoreCase("k") && !userValasz.equalsIgnoreCase("p") && !userValasz.equalsIgnoreCase("o")) {
            hibasValasz++;
            out.println("Hibás válasz! 3 hibánál kilépek!");
            out.println("Hibák száma: " + hibasValasz);
            if (hibasValasz == 3) {
                System.exit(0);
            }
        } else {
            if (gepValasz.equalsIgnoreCase(userValasz)) {
                out.println(gepValasz + " - " + userValasz);
                out.println("Döntetlen!");
            } else if (gepValasz.equalsIgnoreCase("k") && userValasz.equalsIgnoreCase("p")
                    || gepValasz.equalsIgnoreCase("p") && userValasz.equalsIgnoreCase("o")
                    || gepValasz.equalsIgnoreCase("o") && userValasz.equalsIgnoreCase("k")) {
                userPontok++;
                out.println(gepValasz + " - " + userValasz);
                out.println("Te nyertél!");
            } else {
                gepPontok++;
                out.println(gepValasz + " - " + userValasz);
                out.println("A gép nyert!");
            }
            allas();
        }
        
    }

    /**
     * Megjeleníti az aktuális állást
     */
    public static void allas() {
        out.println("\nJelenlegi állás:");
        out.println(gepPontok + " - " + userPontok);
    }
}
