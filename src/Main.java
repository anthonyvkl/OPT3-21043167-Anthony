import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Gebruiker user1 = new Gebruiker();
        user1.UserEntry();

        ArrayList<Medicijn> medicaties = new ArrayList<>();

        Medicatie medicatie = new Medicatie();
        medicatie.voegMedicatieToe();

        Notificatie notificatie1 = new Notificatie();

        notificatie1.notificatieMethode(Medicatie.medicaties);

        Scanner scanner = new Scanner(System.in);
        Medicijn med = null;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        while (true) {
            Date tijd = null;
            System.out.println("Wat wil je doen? 1: nieuwe medicijn instellen, 2: medicijn nemen, 3: stoppen");
            int keuze = scanner.nextInt();

            if (keuze == 1) {
                System.out.println("Wat is de naam van het medicijn?");
                String medicijn = scanner.next();
                System.out.println("Wat is de hoeveelheid van het medicijn die u hebt?");
                int hoeveelheid = scanner.nextInt();
                System.out.println("Welke dosering wilt u gebruiken?");
                int dosering = scanner.nextInt();
                System.out.println("Wat is de vorm van het medicijn? (1: Injectie, 2: Pil, 3: Vloeibaar)");
                int medicijnVorm = scanner.nextInt();
                if (medicijnVorm == 1) {
                    med = new Injectie(medicijn, hoeveelheid, dosering);
                } else if (medicijnVorm == 2) {
                    med = new Pil(medicijn, hoeveelheid, dosering);
                } else if (medicijnVorm == 3) {
                    med = new Vloeibaar(medicijn, hoeveelheid, dosering);
                } else {
                    System.out.println("Ongeldige keuze voor medicijnvorm.");
                    continue;
                }
                medicaties.add(med);
                System.out.println("Medicijn " + med.getNaam() + " ingesteld.");
                System.out.println("Op welk tijdstip wilt u het medicijn innemen? (HH:mm)");
                while (tijd == null) {
                    String input = scanner.next();
                    try {
                        tijd = format.parse(input);
                    } catch (ParseException e) {
                        System.out.println("Ongeldige invoer. Voer het tijdstip in als HH:mm.");
                    }
                }
                med.setTijd(tijd);
                System.out.println("Medicijn " + med.getNaam() + " ingesteld om " + format.format(tijd) + ".");
//            } else if (keuze == 2) {
//                if (med == null) {
//                    System.out.println("Geen medicijn ingesteld.");
//                } else {
//                    System.out.println("Het is momenteel " + new Date() + ". " + med.neemMedicijn(med.getDosering()));
//                }
            } else if (keuze == 2) {
                if (med == null) {
                    System.out.println("Geen medicijn ingesteld.");
                } else {
                    System.out.println("Wat is de hoeveelheid van het medicijn die u hebt?");
                    int dosering = scanner.nextInt();
                    if (med != null) {
                        System.out.println("Het is momenteel " + tijd + ". " + med.neemMedicijn(dosering));
                    } else {
                        System.out.println("Geen medicijn ingesteld.");
                    }
                }
            } else if (keuze == 3) {
                System.out.println("Tot ziens!");
                break;
            } else {
                System.out.println("Ongeldige keuze. Kies 1, 2 of 3.");
            }

        }
    }
}