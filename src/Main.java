import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Gebruiker user1 = new Gebruiker();
        user1.UserEntry();

        Medicatie.voegMedicatieToe(user1);

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        while (true) {
            System.out.println("Wat wil je doen? 1: nieuwe medicijn instellen, 2: medicijn nemen, 3: stoppen");
            int keuze = Integer.parseInt(scanner.nextLine());

            if (keuze == 1) {
                System.out.println("Wat is de naam van het medicijn?");
                String medicijn = scanner.nextLine();
                System.out.println("Wat is de hoeveelheid van het medicijn die u hebt?");
                int hoeveelheid = Integer.parseInt(scanner.nextLine());
                System.out.println("Welke dosering wilt u gebruiken?");
                int dosering = Integer.parseInt(scanner.nextLine());
                System.out.println("Wat is de vorm van het medicijn? (1: Injectie, 2: Pil, 3: Vloeibaar)");
                int medicijnVorm = Integer.parseInt(scanner.nextLine());
                Medicijn med = null;
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
                med.addObserver(user1); // Voeg de gebruiker toe als observer
                Medicatie.medicaties.add(med);
                System.out.println("Medicijn " + med.getNaam() + " ingesteld.");
                System.out.println("Op welk tijdstip wilt u het medicijn innemen? (HH:mm)");
                Date tijd = null;
                while (tijd == null) {
                    String input = scanner.nextLine();
                    try {
                        tijd = format.parse(input);
                    } catch (ParseException e) {
                        System.out.println("Ongeldige invoer. Voer het tijdstip in als HH:mm.");
                    }
                }
                med.setTijd(tijd);
                System.out.println("Medicijn " + med.getNaam() + " ingesteld om " + format.format(tijd) + ".");
            } else if (keuze == 2) {
                if (Medicatie.medicaties.isEmpty()) {
                    System.out.println("Geen medicijn ingesteld.");
                } else {
                    System.out.println("Wat is de naam van het medicijn dat u wilt nemen?");
                    String medicijnNaam = scanner.nextLine();
                    for (Medicijn med : Medicatie.medicaties) {
                        if (med.getNaam().equalsIgnoreCase(medicijnNaam)) {
                            System.out.println(med.neemMedicijn());
                            break;
                        }
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
