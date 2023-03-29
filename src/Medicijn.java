class Medicijn {
    private String naam;
    private int dosering;

    public Medicijn(String naam, int dosering) {
        this.naam = naam;
        this.dosering = dosering;
    }

    public String getNaam(){
        return naam;
    }

    public int getDosering() {
        return dosering;
    }
}
