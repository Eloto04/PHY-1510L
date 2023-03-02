import java.util.Scanner;

/** 
 * Inspiration: Tedious physics lab uncertainty calculations
 * Result: This lil Java program i coded from scratch :)
 * 
 * @author Eli Tolentino, https://github.com/Eloto04
 */
public class UncertaintyCalc {

    /** 
     * Main method used to apply other methods as needed.
     * @param args
     */
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);

        percentUncertainty(scnr);

    }

    public static double momentumUncertainty(double mass, double massUncertainty, double speed, double speedUncertainty) {
        double pMax = (mass + massUncertainty) * (speed + speedUncertainty);
        double pMin = (mass - massUncertainty) * (speed - speedUncertainty);

        return (pMax - pMin) / 2; 
    }
    
    /** 
     * Determines the absolute percentage difference between two values, using the formula
     * from https://www.calculatorsoup.com/calculators/algebra/percent-difference-calculator.php
     * @param scnr
     */
    public static void percentDiff(Scanner scnr){
        System.out.println("Enter value 1: ");
        double v1 = scnr.nextDouble();
        System.out.println("Enter value 2: ");
        double v2 = scnr.nextDouble();
        
        double num = Math.abs(v2 - v1);
        double den = (v2 + v1)/2;
        double percentDiff = (num/den) * 100;
        System.out.printf("Percentage difference: %.6f", percentDiff);
    }

    /** 
     * Determines the absolute percentage difference between two predetermined values, using the
     * formula from https://www.calculatorsoup.com/calculators/algebra/percent-difference-calculator.php
     * 
     * @param v1 The first value used in the calculations
     * @param v2 The second value used in the calculations, to be compared with v1.
     * @return double, the absolute percentage difference
     */
    public static double percentDiff(double v1, double v2){
        double num = Math.abs(v2 - v1);
        double den = (v1 + v2)/2;
        return (num/den) * 100;
    }

    
    /** Determines the uncertainty in a given percentage difference calculation. Designed for physics
     *  lab calculations, printing the uncertainty in a calculation of absolute percentage difference
     *  between an initial value and a final value.
     *  
     *  @param scnr
     *  @see percentDiff returning double
     */
    public static void percentUncertainty(Scanner scnr){
        System.out.println("NOTE: Make sure to keep measurement units consistent for all input values.");
        System.out.println("Enter initial value: ");
        double mi = scnr.nextDouble();
        System.out.println("Enter initial value uncertainty: ");
        double miUncertainty = scnr.nextDouble();
        System.out.println("Enter final value: ");
        double mf = scnr.nextDouble();
        System.out.println("Enter final value uncertainty: ");
        double mfUncertainty = scnr.nextDouble();

        double percentMax = percentDiff(mi + miUncertainty, mf + mfUncertainty);
        double percentMin = percentDiff(mi - miUncertainty, mf - mfUncertainty);
        double percentUncertainty = Math.abs((percentMax - percentMin)) / 2;
        System.out.printf("Percentage uncertainty: %.6f \n", percentUncertainty);
    }

    public static double kineticEnergy(Scanner scnr){
        System.out.println("Enter mass value (g): ");
        double mass = scnr.nextDouble();
        System.out.println("Enter speed value (m/s): ");
        double speed = scnr.nextDouble();

        return (speed * speed * mass)/2;
    }

    public static double kineticEnergy(double mass, double speed){
        return (speed * speed * mass)/2;
    }

    public static double kineticEnergyUncertainty(Scanner scnr){
        System.out.println("Enter mass value (g): ");
        double mass = scnr.nextDouble();
        System.out.println("Enter mass uncertainty value (g): ");
        double massUncertainty = scnr.nextDouble();
        System.out.println("Enter speed value (cm/s): ");
        double speed = scnr.nextDouble();
        speed /= 100;
        System.out.println("Enter speed uncertainty value (cm/s): ");
        double speedUncertainty = scnr.nextDouble();
        speedUncertainty /= 100;

        double keMax = kineticEnergy(mass + massUncertainty, speed + speedUncertainty);
        System.out.println(keMax);
        double keMin = kineticEnergy(mass - massUncertainty, speed - speedUncertainty);
        System.out.println(keMin);

        return (keMax - keMin)/2;
    }

}