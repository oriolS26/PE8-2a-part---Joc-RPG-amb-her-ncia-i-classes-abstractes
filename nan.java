public class nan extends personatge {
    public nan(String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa,
            int carisma) {
        super(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        this.destresa = Math.min(20, this.destresa - 1);
        this.constitucio = Math.min(20, this.constitucio + 4);
    }
    @Override
    public void regenerarVida() {
        salut = salut + constitucio * 4;

        if (salut > salutMax) {
            salut = salutMax;
        }
    }

    @Override
    protected double reduccioDanyDefensa() {
        return 0.25;
    }

    @Override
    public String getRaca() {
        return "Nan";
    }
}
