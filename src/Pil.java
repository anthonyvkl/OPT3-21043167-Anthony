public class Pil extends Medicijn {
    public Pil(String naam, int hoeveelheid, int dosering) {
        super(naam, hoeveelheid, dosering);
    }

    @Override
    protected void updateVoorraad() {
    }

    @Override
    protected String afterNeemMessage() {
        return "Neem " + getDosering() + " pillen van " + getNaam() + ". Er zijn nu nog " + getHoeveelheid() + " pillen over.";
    }
}
