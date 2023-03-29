public class Main {

    public static void main(String[] args) {

        Gebruiker user1 = new Gebruiker();
        user1.UserEntry();

        Medicatie medicatie1 = new Medicatie();

        medicatie1.voegMedicatieToe();

        Notificatie notificatie1 = new Notificatie();

        notificatie1.notificatieMethode(medicatie1.medicaties);

    }
}


