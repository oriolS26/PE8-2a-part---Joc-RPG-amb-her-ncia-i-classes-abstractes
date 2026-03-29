import java.util.*;

public class joc {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<personatge> personatges = new ArrayList<>();

    public static void main(String[] args) {
        joc programa = new joc();
        programa.programa();
    }
    
    public void programa() {

        int op;

        do {

            System.out.println("\n===== MENU RPG =====");
            System.out.println("1. Crear personatge");
            System.out.println("2. Combat 1 vs 1");
            System.out.println("0. Sortir");

            op = sc.nextInt();

            if (op == 1) {
                crearPersonatge();
            }

            if (op == 2) {
                combat();
            }

        } while (op != 0);
    }
    public void crearPersonatge() {
        sc.nextLine();

        System.out.print("Nom: ");
        String nom = sc.nextLine();

        System.out.print("Edat: ");
        int edat = sc.nextInt();

        System.out.println("1. Manual");
        System.out.println("2. Automatic");

        int tipus = sc.nextInt();

        int forca, destresa, constitucio, inteligencia, saviesa, carisma;

        if (tipus == 1) {

            System.out.print("Força: ");
            forca = sc.nextInt();

            System.out.print("Destresa: ");
            destresa = sc.nextInt();

            System.out.print("Constitucio: ");
            constitucio = sc.nextInt();

            System.out.print("Inteligencia: ");
            inteligencia = sc.nextInt();

            System.out.print("Saviesa: ");
            saviesa = sc.nextInt();

            System.out.print("Carisma: ");
            carisma = sc.nextInt();

        } else {

            forca = destresa = constitucio = inteligencia = saviesa = carisma = 5;
            int puntsRestants = 30;

            Random r = new Random();

            while (puntsRestants > 0) {

                int opcio = r.nextInt(6);

                if (opcio == 0 && forca < 20) { forca++; puntsRestants--; }
                else if (opcio == 1 && destresa < 20) { destresa++; puntsRestants--; }
                else if (opcio == 2 && constitucio < 20) { constitucio++; puntsRestants--; }
                else if (opcio == 3 && inteligencia < 20) { inteligencia++; puntsRestants--; }
                else if (opcio == 4 && saviesa < 20) { saviesa++; puntsRestants--; }
                else if (opcio == 5 && carisma < 20) { carisma++; puntsRestants--; }
            }
        }

        personatge p = new personatge(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        personatges.add(p);

        System.out.println("personatge creat!");
    }
    public void combat() {

        if(personatges.size() < 2) {
        System.out.println("Calen almenys 2 personatges.");
        return;
        }
        for (int i = 0; i < personatges.size(); i++) {
        System.out.println(i + " - " + personatges.get(i).getNom());
        }
        System.out.print("Jugador 1 tria personatge: ");
    personatge p1 = personatges.get(sc.nextInt());

    System.out.print("Jugador 2 tria personatge: ");
    personatge p2 = personatges.get(sc.nextInt());

    boolean combatActiu = true;

    while (combatActiu) {

        if (p1.estaViu() && p2.estaViu()) {
            torn(p1, p2);
        }

        if (p1.estaViu() && p2.estaViu()) {
            torn(p2, p1);
        }

        p1.regenerarVida();
        p2.regenerarVida();

        p1.regenerarMana();
        p2.regenerarMana();

        if (!p1.estaViu() || !p2.estaViu()) {
            combatActiu = false;
        }

        System.out.println("\nESTAT PERSONATGES:");
        System.out.println(p1);
        System.out.println(p2);
    }

    if (p1.estaViu()) {
        System.out.println("Guanya " + p1.getNom());
    } else {
        System.out.println("Guanya " + p2.getNom());
    }
    }
    public void torn(personatge atacant, personatge defensor) {

        System.out.println("\nTorn de " + atacant.getNom());

        System.out.println("1. Atacar");
        System.out.println("2. Defensar");
        System.out.println("3. Habilitat especial");

        int op = sc.nextInt();

        if (op == 1) {
            atacant.atacar(defensor);
        }

        if (op == 2) {
            atacant.defensar();
        }

        if (op == 3) {
            atacant.usarHabilitatEspecial();
        }
    }
}
