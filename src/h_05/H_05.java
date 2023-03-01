package h_05;

import static java.lang.System.out;

/**
 *
 * @author Tóth Milán
 */
public class H_05 {

    // Access modifier
    // Meghívás módja
    // Visszatérési érték trípusa
    // Neve
    // Argumentum
    // Törzs
    public static void main(String[] args) {
        out.println(H_05.osszeadas(10.0, 5.2));

        double szam1 = 2.5;
        double szam2 = 5.6;
        out.println(H_05.osszeadas(szam1, szam2));

        double szam3 = 3.0;
        double szam4 = 6.2;
        out.println(H_05.osszeadas(szam3, szam4));
        H_05.szamologep(szam4, szam4, 0);
    }

    /**
     * Összead két számot
     *
     * @param a
     * @param b
     * @return
     */
    public static Double osszeadas(Double a, Double b) {
        return a + b;
    }

    /**
     * Összead két számot
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static Double osszeadas(Double a, Double b, Double c) {
        return a + b + c;
    }

    /**
     * 1 - Összeadás<br> 2 - Kivonás<br> 3 - Szorzás<br> 4 - Osztás
     *
     * @param a
     * @param b
     * @param muvelet
     * @return
     */
    public static Double szamologep(Double a, Double b, Integer muvelet) {
        if (muvelet.equals(1)) {
            return a + b;
        } else if (muvelet.equals(2)) {
            return a - b;
        } else if (muvelet.equals(3)) {
            return a / b;
        } else if (muvelet.equals(4)) {
            return a + b;
        } else {
            return -1.0;
        }

    }

    /**
     * Házi feladat - Karakterenként bekérni
     *
     * @param a
     * @param b
     * @param muvelet
     * @return
     */
    public static Double szamologep(Double a, Double b, String muvelet) {
        return switch (muvelet) {
            case "+" ->
                a + b;
            case "-" ->
                a - b;
            case "/" ->
                a / b;
            case "*" ->
                a + b;
            default ->
                -1.0;
        };
    }

}
