import java.util.Scanner;

public class MachineACafe {
    int eau;      // cl
    int grains;   //g
    int gobelets; //en nombre
    int cafesServis;

    double monnayeur; //
    double caisse;    // 

    int EAU_MAX = 100;
    int GRAINS_MAX = 50;
    int GOBELETS_MAX = 10;
    int MAX_CAFES = 5;

    public MachineACafe() {
        eau = EAU_MAX;
        grains = GRAINS_MAX;
        gobelets = GOBELETS_MAX;
        cafesServis = 0;
        monnayeur = 0;
        caisse = 0;
    }

    // demande la monnaie insérer
    public void insererMonnaie(double montant) {
        if (montant > 0) {
            monnayeur += montant;
            System.out.println("Vous avez mis " + montant + "€");
        } else {
            System.out.println("Montant incorrect !");
        }
    }

    // servir un café
    public void servirCafe(String type) {
        double prix = 0;
        int eauUsee = 0;
        int grainsUsee = 0;
        int gobeletsUsee = 1;

        if (type.equalsIgnoreCase("court")) {
            prix = 1.5;
            eauUsee = 10;
            grainsUsee = 10;
        } else if (type.equalsIgnoreCase("long")) {
            prix = 2.0;
            eauUsee = 20;
            grainsUsee = 10;
        } else {
            System.out.println("Café inconnu !");
            return;
        }

        // Vérifier si machine entartrée
        if (cafesServis >= MAX_CAFES) {
            System.out.println("ERREUR : Machine entartrée, appelez le technicien !");
            return;
        }

        // Vérifier argent
        if (monnayeur < prix) {
            System.out.println("Pas assez d'argent !");
            return;
        }

        // Vérifier stocks
        if (eau < eauUsee) {
            System.out.println("Plus d'eau !");
            return;
        }
        if (grains < grainsUsee) {
            System.out.println("Plus de grains !");
            return;
        }
        if (gobelets < gobeletsUsee) {
            System.out.println("Plus de gobelets !");
            return;
        }

        // Servir le café
        eau -= eauUsee;
        grains -= grainsUsee;
        gobelets -= gobeletsUsee;
        monnayeur -= prix;
        caisse += prix;
        cafesServis++;

        System.out.println("Voici votre café !");
    }

    // Menu technicien
    public void maintenance() {
        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while (choix != 0) {
            System.out.println("\n--- Menu Technicien ---");
            System.out.println("1 - Remplir réservoirs");
            System.out.println("2 - Détartrer");
            System.out.println("3 - Récupérer l'argent");
            System.out.println("0 - Retour");
            System.out.print("Choix : ");
            choix = sc.nextInt();

            if (choix == 1) {
                eau = EAU_MAX;
                grains = GRAINS_MAX;
                gobelets = GOBELETS_MAX;
                System.out.println("Réservoirs remplis !");
            } else if (choix == 2) {
                cafesServis = 0;
                System.out.println("Machine détartrée !");
            } else if (choix == 3) {
                System.out.println("Vous récupérez " + caisse + "€");
                caisse = 0.0;
            } else if (choix == 0) {
                System.out.println("Retour au menu principal");
            } else {
                System.out.println("Choix invalide !");
            }
        }
    }

    // afficher état de la machine
    public void afficherEtat() {
        System.out.println("\n--- Etat ---");
        System.out.println("Eau : " + eau + " cl");
        System.out.println("Grains : " + grains + " g");
        System.out.println("Gobelets : " + gobelets);
        System.out.println("Cafés servis : " + cafesServis + "/" + MAX_CAFES);
        System.out.println("Argent inséré : " + monnayeur + "€");
        System.out.println("Caisse : " + caisse + "€");
    }
}
