public class nan extends personatge {
    public nan(String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa,
            int carisma) {
        super(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        this.destresa = Math.min(20, this.destresa - 1);
        this.constitucio = Math.min(20, this.constitucio + 4);
    }
    
}
