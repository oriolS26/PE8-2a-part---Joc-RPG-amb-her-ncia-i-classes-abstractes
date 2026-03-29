public class huma extends personatge {
    public huma(String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa,
            int carisma) {
        super(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        this.forca = Math.min(20, this.forca + 1);
        this.inteligencia = Math.min(20, this.inteligencia + 1);
        this.carisma = Math.min(20, this.carisma + 1);
        this.saviesa = Math.max(20, this.saviesa + 1);
        this.destresa = Math.max(20, this.destresa + 1);
        this.constitucio = Math.max(20, this.constitucio + 1);
    }
}