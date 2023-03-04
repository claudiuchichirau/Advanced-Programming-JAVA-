class Locatie {
    private String nume;
    private double x;
    private double y;
    private TipLocatie tip;

    // tipul enum pentru tipul locatiei
    enum TipLocatie {
        Oras, Aeroport, Benzinarie, Gara, Mall, Universitate, InstitutiePublica
    }

    public Locatie(String nume, TipLocatie tip, double x, double y) {
        this.nume = nume;
        this.tip = tip;
        this.x = x;
        this.y = y;
    }

    public String getNume() {
        return nume;
    }

    public TipLocatie getTip() {
        return tip;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setTip(TipLocatie tip) {
        this.tip = tip;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public String toString() {
        return "Locatie:" + "nume='" + nume + "', tip='" + tip + "', Latitudine=" + x + ", Longitudine='" + y + ".\n";
    }
}

class Drum {
    private int LimitaViteza;
    private double Lungime;
    private TipDrum tip;
    private Locatie locatieStart;
    private Locatie locatieEnd;
    enum TipDrum {
        DrumComunal, DrumJudetean, DrumNational, DrumEuropean, DrumExpress, Autostrada
    }

    public Drum(Drum.TipDrum tip, double Lungime, int LimitaViteza, Locatie locatieStart, Locatie locatieEnd)  {
        double distanta = calculeazaDistanta(locatieStart, locatieEnd);
        if (Lungime <= distanta) {
            System.out.println ("Lungimea drumului dintre " + locatieStart.getNume() + " si " + locatieEnd.getNume() + " trebuie sa fie mai mare decat distanta euclidiana dintre cele doua locatii!\n");
            return;
        }
        this.tip = tip;
        this.Lungime = Lungime;
        this.LimitaViteza = LimitaViteza;
        this.locatieStart=locatieStart;
        this.locatieEnd=locatieEnd;
    }

    public double calculeazaDistanta(Locatie loc1, Locatie loc2) {
        double x1 = loc1.getX();
        double y1 = loc1.getY();
        double x2 = loc2.getX();
        double y2 = loc2.getY();
        double distanta = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); // calculez distanta euclidiana dintre cele doua locatii
        return distanta;
    }

    public Drum.TipDrum getTip() {
        return tip;
    }

    public double getLungime()
    {
        return Lungime;
    }

    public int getLimitaViteza() {
        return LimitaViteza;
    }

    public Locatie getLocatieStart() { return locatieStart; }

    public Locatie getLocatieEnd() { return locatieEnd; }

    public void setTip(Drum.TipDrum tip) {
        this.tip = tip;
    }

    public void setLungime(int Lungime) {
        this.Lungime = Lungime;
    }

    public void setLimitaViteza(int LimitaViteza){
        this.LimitaViteza = LimitaViteza;
    }

    public void setLocatieStart(Locatie locatieStart) { this.locatieStart=locatieStart; }

    public void setLocatieEnd(Locatie locatieEnd) { this.locatieEnd=locatieEnd; }

    public String toString() {
        return "Drum: Locatie de start=' " + locatieStart.getNume() + "', Locatie finala='" + locatieEnd.getNume() + "', Tip=" + tip + ", Lungime=" + Lungime + ", Limita de Viteza=" + LimitaViteza + ".\n";
    }

}

public class Compulsory {
    public static void main(String[] args) {
        Locatie universitate1 = new Locatie("Universitatea Alexandru Ioan Cuza",  Locatie.TipLocatie.Universitate, 47.173598, 27.574102);
        Locatie universitate2 = new Locatie("Universitatea Tehnica Gheorghe Asachi din Iasi", Locatie.TipLocatie.Universitate, 47.1670319, 27.5731605);
        Locatie primariaIasi = new Locatie("Palatul Roznovanu", Locatie.TipLocatie.InstitutiePublica, 47.1611312, 27.5842603 );
        Locatie palas = new Locatie("Palas Mall", Locatie.TipLocatie.Mall, 47.166765, 27.586613);
        Locatie aeroportIasi = new Locatie("Aeroportul International Iasi", Locatie.TipLocatie.Aeroport , 47.1782766, 27.6193838);
        Locatie aeroportOtopeni = new Locatie("Aeroportul Henri Coanda Otopeni", Locatie.TipLocatie.Aeroport, 44.57115, 26.08415);
        Locatie aeroportTimisoara = new Locatie("Aeroportul Traian Vuia Timisoara", Locatie.TipLocatie.Aeroport, 45.8083, 21.3379);
        Locatie aeroportCluj = new Locatie("Aeroportul International Cluj-Napoca", Locatie.TipLocatie.Aeroport, 46.7822, 23.6877);

        System.out.println(universitate2);
        System.out.println(primariaIasi);

        Drum aeroportIasiOtopeni = new Drum(Drum.TipDrum.Autostrada , 386, 130, aeroportIasi, aeroportOtopeni);
        Drum universitate12 = new Drum(Drum.TipDrum.DrumJudetean, 4, 60, universitate1, universitate2);
        Drum palasAeroportCluj = new Drum(Drum.TipDrum.DrumExpress, 1, 100, palas, aeroportCluj);

        System.out.println(universitate12);
        System.out.println(aeroportIasiOtopeni);
        // System.out.println(palasAeroportCluj);
    }
}
