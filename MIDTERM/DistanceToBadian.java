import java.util.Scanner;

public class Badian 
{

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        final double distViaBarili = 86.3;
        final double distViaDumanjug = 95.9;
        final double distViaArgao = 102.6;

        boolean validInput = false;

        while (!validInput) 
        {
            System.out.println("Is Barili obstructed?");
            String barBlocked = scan.nextLine();

            if (barBlocked.equalsIgnoreCase("NO") || barBlocked.equalsIgnoreCase("No") || barBlocked.equalsIgnoreCase("no")) {
                validInput = true;
                recommendedRoute("Barili", distViaBarili);
            } else if (barBlocked.equalsIgnoreCase("YES") || barBlocked.equalsIgnoreCase("Yes") || barBlocked.equalsIgnoreCase("yes")) {
                System.out.println("Is Dumanjug obstructed?");
                String dumBlocked = scan.nextLine();

                if (dumBlocked.equalsIgnoreCase("NO") || dumBlocked.equalsIgnoreCase("No") || dumBlocked.equalsIgnoreCase("no")) {
                    validInput = true;
                    recommendedRoute("Dumanjug", distViaDumanjug);
                } else if (dumBlocked.equalsIgnoreCase("YES") || dumBlocked.equalsIgnoreCase("Yes") || dumBlocked.equalsIgnoreCase("yes")) {
                    validInput = true;
                    recommendedRoute("Argao", distViaArgao);
                } else {
                    System.out.println("Invalid Input");
                }
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void recommendedRoute(String location, double distance) {
        System.out.println("\nCebu City (South Bus) - Start");
        System.out.println("route 1: Minglanilla");
        System.out.println("route 2: San Fernando");
        System.out.println("route 3: Carcar");

        if (location.equals("Barili")) {
            System.out.println("route 4.1: Barili");
            System.out.println("route 4.1.1: Dumanjug");
            System.out.println("route 4.1.2: Alcantara");
        } else if (location.equals("Dumanjug")) {
            System.out.println("route 4.2: Sibonga");
            System.out.println("route 4.2.1: Dumanjug");
            System.out.println("route 4.2.2: Alcantara");
        } else if (location.equals("Argao")) {
            System.out.println("route 4.2: Sibonga");
            System.out.println("route 5: Argao");
            System.out.println("route 5.1: Ronda");
            System.out.println("route 5.2: Alcantara");
        }

        System.out.println("END: BADIAN");

        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter Speed (km/hr):");
        int speed = scan.nextInt();
        double timeTravelled = distance / speed;

        int hours = (int) timeTravelled;
        int minutes = (int) ((timeTravelled - hours) * 60);

        System.out.println("Speed: " + speed + " km/hr");
        System.out.println("Distance: " + distance + " km");
        System.out.println("ETA: " + hours + " hour/s " + minutes + " minutes");
    }
}
