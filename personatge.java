import java.util.*;

public class personatge {
    
    protected String nom;
    protected int edat;
    protected int forca;
    protected int destresa;
    protected int constitucio;
    protected int inteligencia;
    protected int saviesa;
    protected int carisma;
    protected double salut;
    protected double mana;
    protected double salutMax;
    protected double manaMax;

    protected int energia = 0;
    protected boolean habilitatEspecial = false;
    protected arma armaEquipada;
    protected ArrayList<arma> inventari = new ArrayList<>();
    protected boolean defensat = false;

    public personatge (String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa, int carisma) {
        this.nom = nom;
        this.edat = edat;
        this.forca = forca;
        this.destresa= destresa;
        this.constitucio = constitucio;
        this.inteligencia = inteligencia;
        this.saviesa = saviesa;
        this.carisma = carisma;
        this.salutMax = constitucio * 50;
        this.manaMax = inteligencia * 30;
        this.salut = salutMax;
        this.mana = manaMax;
    
        inventari.add(new arma("Espasa Llarga", tipusarma.ESPASA, 15, false));
    }

    public String getNom() {
        return nom;
    }
    public boolean viu() {
        return salut > 0;
    }

    public void atacar(personatge enemic) {

    double dany;

    if (armaEquipada == null || !armaEquipada.esMagica()) {

        int danyArma;

        if (armaEquipada == null) {
            danyArma = 0;
        } else {
            danyArma = armaEquipada.getDany();
        }

        dany = forca * (1 + danyArma / 100.0);

    } else {

        dany = armaEquipada.getDany() * inteligencia / 100.0;
    }

    if (habilitatEspecial) {
        dany *= 2;
        habilitatEspecial = false;
        System.out.println("ATAC ESPECIAL x2!");
    }

    if (enemic.esquivar()) {
        System.out.println(enemic.getNom() + " esquiva l'atac!");
        return;
    }

    enemic.rebreDany(dany);

    energia++;

    System.out.println("Energia guanyada! Energia actual: " + energia);

    }

    public void rebreDany(double dany) {

        if (defensat) {
            dany = dany * reduccioDanyDefensa();
            defensat = false;
        }

        salut -= dany;

        if (salut < 0)
            salut = 0;

        System.out.println(nom + " rep " + dany + " de dany. Vida: " + salut);
    }
    public boolean esquivar() {

        double prob = (destresa - 5) * 3.33;

        int random = new Random().nextInt(100) + 1;

        return random <= prob;
    }
     public void defensar() {

        defensat = true;

        System.out.println(nom + " es defensa.");
    }
    public void regenerarVida() {

        salut += constitucio * 3;

        if (salut > salutMax)
            salut = salutMax;
    }
     public void regenerarMana() {

        mana += inteligencia * 2;

        if (mana > manaMax)
            mana = manaMax;
    }
    public void usarHabilitatEspecial() {

        if (energia < 3) {

            System.out.println("No tens prou energia!");
            return;
        }

        energia -= 3;

        habilitatEspecial = true;

        System.out.println("Habilitat especial activada! Proxim atac x2!");
    }
    
    public boolean estaViu() {
    return salut > 0;
    }

    protected double reduccioDanyDefensa() {
    return 0.5;
    }

    public String getRaca() {
        return "Desconeguda";
    }
    
     public String toString() {

        return nom + " (" + getRaca() + ") | Vida: " + salut + "/" + salutMax +
                        " | Mana: " + mana + "/" + manaMax +
                        " | Energia: " + energia;
    }
}
