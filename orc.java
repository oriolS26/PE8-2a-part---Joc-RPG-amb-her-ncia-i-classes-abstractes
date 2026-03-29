public class orc extends personatge {
    public orc(String nom, int edat, int forca, int destresa, int constitucio, int inteligencia, int saviesa,
            int carisma) {
        super(nom, edat, forca, destresa, constitucio, inteligencia, saviesa, carisma);

        this.forca = Math.min(20, this.forca + 3);
        this.constitucio = Math.min(20, this.constitucio + 1);
    }
    @Override
    public void atacar(personatge enemic) {

        double dany;
        int danyArma;

        if (armaEquipada == null) {
            danyArma = 0;
        } else {
            danyArma = armaEquipada.getDany();
        }

        if (armaEquipada != null && armaEquipada.esMagica()) {
            System.out.println("Els orcs no poden usar armes màgiques!");
            return;
        }

        dany = forca * (1 + danyArma / 100.0);
        dany = dany * 1.10;

        if (habilitatEspecial) {
            dany = dany * 2;
            habilitatEspecial = false;
            System.out.println("ATAC ESPECIAL x2!");
        }

        if (enemic.esquivar()) {
            System.out.println(enemic.getNom() + " esquiva l'atac!");
            return;
        }

        enemic.rebreDany(dany);

        energia = energia + 1;
        System.out.println("Energia guanyada! Energia actual: " + energia);
    }
    @Override
    public String getRaca() {
        return "Orc";
    }
}
