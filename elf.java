public class elf extends personatge {
    public elf(String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa,
            int carisma) {
        super(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        this.destresa = Math.min(20, this.destresa + 2);
        this.inteligencia = Math.min(20, this.inteligencia + 2);
    }
    @Override
    public void regenerarMana(){
        mana += inteligencia * 3;
        
        if (mana > manaMax){
            mana = manaMax;
        }
    }
    @Override
    public String getRaca() {
        return "Elfo";
    }
}
