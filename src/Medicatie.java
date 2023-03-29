import java.util.ArrayList;
import java.util.Scanner;

class Medicatie {
    public ArrayList<String> medicaties = new ArrayList<>();

    public void voegMedicatieToe(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Voor welke medicijn zou je notificaties willen ontvangen? Als je geen medicijn meer wilt toevoegen typ dan 'volgende' in.");

            String medicijn = scanner.nextLine();


            if (!medicijn.equals("volgende")){
                medicaties.add(medicijn);

            }

            if (medicijn.equals("volgende")){
                break;
            }

            System.out.println("Welke dosering zou u willen nemen? Voer het aantal in.");

            if (scanner.hasNextInt()) {
                int dosering = scanner.nextInt();
                scanner.nextLine();
                medicaties.add(String.valueOf(dosering));
            } else {
                String line = scanner.nextLine();

                if(line.equals("volgende")) {
                    break;
                } else {
                    System.out.println("Voer het aantal in. (1, 5, etc.)");
                    int dosering = scanner.nextInt();
                    medicaties.add(String.valueOf(dosering));
                }
            }
        }
    }
}


