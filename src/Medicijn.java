import java.util.*;

public abstract class Medicijn {
    String naam;
    int hoeveelheid;
    int dosering;
    int huidigeHoeveelheid;
    Date tijd;
    List<Observer> observers = new ArrayList<>();  // Lijst van observers

    public Medicijn(String naam, int hoeveelheid, int dosering) {
        this.naam = naam;
        this.hoeveelheid = hoeveelheid;
        this.dosering = dosering;
        this.huidigeHoeveelheid = hoeveelheid;
    }

    public String getNaam() {
        return naam;
    }

    public int getHoeveelheid() {
        return huidigeHoeveelheid;
    }

    public int getDosering() {
        return dosering;
    }

    public void setTijd(Date tijd) {
        this.tijd = tijd;
        startTimer(this.naam, tijd);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    protected void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(this, message);
        }
    }


    public void startTimer(String medicatie, Date tijd) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                notifyObservers("Het is tijd om " + medicatie + " in te nemen.");
                System.out.println(neemMedicijn());
            }
        };

        long delay = tijd.getTime() - System.currentTimeMillis();
        if (delay > 0) {
            timer.schedule(task, delay);
        }

        System.out.println("Notificatie ingesteld voor " + String.format("%02d", tijd.getHours()) + ":" + String.format("%02d", tijd.getMinutes()) + " voor " + medicatie + ".");
    }

    // Template Method Pattern
    public final String neemMedicijn() {
        if (checkVoorraad()) {
            neemIn();
            updateVoorraad();
            notifyObservers("De voorraad van " + naam + " is geupdate.");
            return afterNeemMessage();
        } else {
            return "Niet genoeg " + naam + ".";
        }
    }

    protected boolean checkVoorraad() {
        return dosering <= huidigeHoeveelheid;
    }

    protected abstract void updateVoorraad();

    protected abstract String afterNeemMessage();

    public void neemIn() {
        huidigeHoeveelheid -= dosering;
        System.out.println("Neem " + dosering + " van " + naam + ". Er zijn nog " + huidigeHoeveelheid + " over.");
    }
}