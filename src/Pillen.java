interface newUpdate {
    void update();
}

class Pillen extends Medicijn implements newUpdate {
    private int aantalPillen;

    public Pillen(String naam, int dosering, int aantalPillen){
        super(naam, dosering);
        this.aantalPillen = aantalPillen;
    }

    public int getAantalPillen() {
        return aantalPillen;
    }

    public void setAantalPillen(int aantalPillen){
        this.aantalPillen = aantalPillen;
    }

    public void update() {
        aantalPillen--;
        System.out.println("U heeft een pil genomen van " + getNaam() + ". U heeft nog " + aantalPillen + " pillen.");
    }
}
