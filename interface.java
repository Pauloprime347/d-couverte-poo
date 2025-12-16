import java.util.Scanner;

public class MachineCafe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eau = 80, grains = 30, gobelets = 8;
        double credit = 0.50;
        int choix;
        do {
            System.out.println("ETAT: EAU "+eau+"cl | GRAINS " + grains + "g | GOBELETS " + gobelets);
            System.out.println("CREDIT: " + credit + "€");
            System.out.println("1. Insérer une pièce (+0.50€) | 2. Espresso (1.50€) | 3. Allongé (2.00€) | 4. Quitter");
            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            if (choix == 1) credit += 0.50;
            else if (choix == 2 && credit >= 1.50) { credit -= 1.50; System.out.println("Espresso commandé."); }
            else if (choix == 3 && credit >= 2.00) { credit -= 2.00; System.out.println("Allongé commandé."); }
            else if (choix == 4) System.out.println("a bientot!");
            else System.out.println("pas assez d'argent.");
        } while (choix != 4);
        scanner.close();
    }
}

