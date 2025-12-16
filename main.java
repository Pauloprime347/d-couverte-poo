import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MachineACafe machine = new MachineACafe();
        Scanner scanner = new Scanner(System.in);
        int choix = -1;

        do {
            System.out.println("\nMachine à café");
            System.out.println("1 - Mettre de l'argent");
            System.out.println("2 - Café court de 10 cl (1.5€)");
            System.out.println("3 - Café long de 20 cl (2€)");
            System.out.println("4 - Menu technicien");
            System.out.println("5 - Etat de la machine");
            System.out.println("0 - Quitter");
            System.out.print("Choix : ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Montant : ");
                    double montant = scanner.nextDouble();
                    machine.insererMonnaie(montant);
                    break;

                case 2:
                    machine.servirCafe("court");
                    break;

                case 3:
                    machine.servirCafe("long");
                    break;

                case 4:
                    machine.maintenance();
                    break;

                case 5:
                    machine.afficherEtat();
                    break;

                case 0:
                    System.out.println("Fin du programme");
                    break;

                default:
                    System.out.println("Erreur de choix");
            }

        } while (choix != 0);

        scanner.close();
    }
}
