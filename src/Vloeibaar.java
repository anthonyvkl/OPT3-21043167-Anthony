public class Vloeibaar extends Medicijn {
    public Vloeibaar(String naam, int hoeveelheid, int dosering) {
        super(naam, hoeveelheid, dosering);
    }

    @Override
    protected void updateVoorraad() {
    }

    @Override
    protected String afterNeemMessage() {
        return "Neem " + getDosering() + " ml van " + getNaam() + ". Er is nu nog " + getHoeveelheid() + " ml over.";
    }
}