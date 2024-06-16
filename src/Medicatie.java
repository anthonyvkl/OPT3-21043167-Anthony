import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Medicatie {
    public static ArrayList<Medicijn> medicaties = new ArrayList<>();

    public static void voegMedicatieToe(Gebruiker gebruiker) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format24 = new SimpleDateFormat("HH:mm");

        while (true) {
            System.out.println("Voor welke medicijn zou je notificaties willen ontvangen? Als je geen medicijn meer wilt toevoegen typ dan 'volgende' in.");
            String medicijn = scanner.nextLine();
            if (medicijn.equalsIgnoreCase("volgende")) {
                break;
            }

            System.out.println("Welke dosering zou u willen nemen? Voer het aantal in.");
            int dosering = Integer.parseInt(scanner.nextLine());

            System.out.println("Wat voor soort medicijn is dit? Pillen/Injecties/Vloeibare medicijnen.");
            String type = scanner.nextLine();
            System.out.println("Vul de hoeveelheid die je hebt");
            int hoeveelheid = Integer.parseInt(scanner.nextLine());

            Medicijn med = null;
            if (type.equalsIgnoreCase("pillen")) {
                med = new Pil(medicijn, hoeveelheid, dosering);
            } else if (type.equalsIgnoreCase("injecties")) {
                med = new Injectie(medicijn, hoeveelheid, dosering);
            } else if (type.equalsIgnoreCase("vloeibare medicijnen")) {
                med = new Vloeibaar(medicijn, hoeveelheid, dosering);
            } else {
                System.out.println("Ongeldig. Probeer opnieuw.");
                continue;
            }

            med.addObserver(gebruiker); // Voeg de gebruiker toe als observer
            Medicatie.medicaties.add(med);

            System.out.println("Op welk tijdstip wilt u het medicijn innemen? (HH:mm)");
            Date tijd = null;
            while (tijd == null) {
                String input = scanner.nextLine();
                try {
                    tijd = format24.parse(input);
                    Calendar now = Calendar.getInstance();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(tijd);
                    cal.set(Calendar.YEAR, now.get(Calendar.YEAR));
                    cal.set(Calendar.MONTH, now.get(Calendar.MONTH));
                    cal.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));

                    // Dit is een check om te kijken of het tijdstip in het verleden zit, als dit zo is
                    // heb ik het ingesteld dat het een tijdstip instelt voor de volgende dag.
                    if (cal.getTime().before(now.getTime())) {
                        cal.add(Calendar.DAY_OF_MONTH, 1);
                    }

                    tijd = cal.getTime();
                } catch (ParseException e) {
                    System.out.println("Ongeldige invoer. Voer het tijdstip in als HH:mm.");
                }
            }
            med.setTijd(tijd);
            System.out.println("Medicijn " + med.getNaam() + " ingesteld om " + format24.format(tijd) + ".");
        }
    }
}