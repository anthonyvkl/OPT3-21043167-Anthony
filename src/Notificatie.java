import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class Notificatie {

    public void notificatieMethode(ArrayList<Medicijn> medicaties) {
        if (medicaties.isEmpty()) {
            System.out.println("Geen medicijnen ingesteld");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        ArrayList<Medicijn> notificatieMedicaties = new ArrayList<>();

        for (int i = 0; i < medicaties.size(); i++) {
            Medicijn medicatie = medicaties.get(i);
            System.out.println("Vul hierin de tijdstip waarop je de notificatie voor " + medicatie.getNaam() + " wilt ontvangen. (Bijvoorbeeld 18:30).");
            String tijd = scanner.nextLine();

            if (!tijd.equals("volgende")) {
                notificatieMedicaties.add(medicatie);
                startTimer(medicatie, tijd);
            }
        }

        System.out.println("Hierbij een overzicht van de tijdstippen waarbij u uw medicaties in moet nemen:");
        for (Medicijn medicatie : notificatieMedicaties) {
            System.out.println(medicatie.getNaam());
        }
    }


    public void startTimer(Medicijn medicatie, String tijd){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                LocalTime specifiedTime = LocalTime.parse(tijd);
                if (now.toLocalTime().compareTo(specifiedTime) >= 0) {
                    String medicijn = medicatie.getNaam();
                    int hoeveelheid = medicatie.getHoeveelheid();
                    System.out.println("Het is momenteel " + tijd + ". " + medicatie.neemMedicijn(medicatie.getDosering()));
//                    System.out.println("U heeft nog " + hoeveelheid + " " + medicijn + " over.");

                }
            }
        };

        int uren = Integer.parseInt(tijd.split(":")[0]);
        int minuten = Integer.parseInt(tijd.split(":")[1]);

        Date specifiedTime = new Date();
        specifiedTime.setHours(uren);
        specifiedTime.setMinutes(minuten);

        timer.schedule(task, specifiedTime);

        System.out.println("Notificatie ingesteld voor " + tijd + " voor " + medicatie.getNaam() + ".");

    }
}