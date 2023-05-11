import java.util.ArrayList;
import java.util.Scanner;

class Medicatie {

    public static ArrayList<Medicijn> medicaties = new ArrayList<>();

    public void voegMedicatieToe(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Voor welke medicijn zou je notificaties willen ontvangen? Als je geen medicijn meer wilt toevoegen typ dan 'volgende' in.");

            String medicijn = scanner.nextLine();

            if (medicijn.equals("volgende")) {
                break;
            }

            System.out.println("Welke dosering zou u willen nemen? Voer het aantal in.");

            int dosering = 0;
            if (scanner.hasNextInt()) {
                dosering = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Voer het aantal in. (1, 5, etc.)");
                dosering = scanner.nextInt();
                scanner.nextLine();
            }

            while (true) {
                System.out.println("Wat voor soort medicijn is dit? Pillen/Injecties/Vloeibare medicijnen.");
                String type = scanner.nextLine();
                System.out.println("Vul de hoeveelheid die je hebt");
                int hoeveelheid = scanner.nextInt();
                scanner.nextLine();

                if (type.equals("pillen")) {
                    medicaties.add(new Pil(medicijn, hoeveelheid, dosering));
                    break;
                } else if (type.equals("injecties")) {
                    medicaties.add(new Injectie(medicijn, hoeveelheid, dosering));
                    break;
                } else if (type.equals("vloeibare medicijnen")) {
                    medicaties.add(new Vloeibaar(medicijn, hoeveelheid, dosering));
                    break;
                } else {
                    System.out.println("Ongeldig. Probeer opnieuw.");

                }
            }
        }
    }
}


