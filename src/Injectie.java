public class Injectie extends Medicijn {
    public Injectie(String naam, int hoeveelheid, int dosering) {
        super(naam, hoeveelheid, dosering);
    }

    @Override
    protected void updateVoorraad() {
    }

    @Override
    protected String afterNeemMessage() {
        return "Neem " + getDosering() + " injecties van " + getNaam() + ". Er zijn nu nog " + getHoeveelheid() + " injecties over.";
    }
}