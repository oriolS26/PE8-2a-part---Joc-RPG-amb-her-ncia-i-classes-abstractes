public class orc extends personatge {
    public orc(String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa,
            int carisma) {
        super(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        this.forca = Math.min(20, this.forca + 3);
        this.constitucio = Math.min(20, this.constitucio + 1);
    }
    
}
