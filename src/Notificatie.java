import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class Notificatie {

    public void notificatieMethode(ArrayList<String> medicaties) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String>kopieMedicaties = new ArrayList<>(medicaties);

        for (int i = 0; i < kopieMedicaties.size(); i+= 2) {
            String medicatie = kopieMedicaties.get(i);
            System.out.println("Vul hierin de tijdstip waarop je de notificatie voor " + medicatie + " wilt ontvangen. (Bijvoorbeeld 18:30).");
            String tijd = scanner.nextLine();

            if (!tijd.equals("volgende")) {
                medicaties.add(medicatie + " " + tijd);
                startTimer(medicatie, tijd);
            }
        }

        System.out.println("Hierbij een overzicht van de tijdstippen waarbij u uw medicaties in moet nemen:");
        for (String medicatie : medicaties) {
            System.out.println(medicatie);
        }
    }
    public void startTimer(String medicatie, String tijd){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                LocalTime specifiedTime = LocalTime.parse(tijd);
                if (now.toLocalTime().compareTo(specifiedTime) >= 0) {
                    System.out.println("Het is momenteel " + tijd + ". Neem uw " + medicatie + " pillen.");
                }
            }
        };

        int uren = Integer.parseInt(tijd.split(":")[0]);
        int minuten = Integer.parseInt(tijd.split(":")[1]);

        Date specifiedTime = new Date();
        specifiedTime.setHours(uren);
        specifiedTime.setMinutes(minuten);

        timer.schedule(task, specifiedTime);

        System.out.println("Notificatie ingesteld voor " + tijd + " voor " + medicatie + ".");

    }
}


