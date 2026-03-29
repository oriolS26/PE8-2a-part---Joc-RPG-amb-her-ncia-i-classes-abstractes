public class arma {
    protected String nom;
    protected tipusarma tipus;
    protected int dany;
    protected boolean magica;

    public arma(String nom, tipusarma tipus, int dany, boolean magica) {
        this.nom = nom;
        this.tipus = tipus;
        this.dany = dany;
        this.magica = magica;
    }
    public String getNom() {
        return nom;
    }
    public int getDany() {
        return dany;
    }
    public boolean esMagica() {
        return magica;
    }
    public tipusarma getTipus() {
        return tipus;
    }
    public String toString() {
        return nom + " (" + tipus + ", Dany: " + dany + ", Màgica: " + magica + ")";
    }
}