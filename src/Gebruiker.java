import java.util.Scanner;

public class Gebruiker implements Observer {
    private String naam;

    public void UserEntry() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welkom bij Vitalarm.\nWat is uw naam?");
        naam = scanner.nextLine();

        System.out.println("Hi! " + naam + ", bedankt voor het kiezen van Vitalarm.");
        System.out.println("Ik zal je helpen met het bijhouden van je medicatie! :)");
    }

    @Override
    public void update(Medicijn medicijn, String message) {
        System.out.println("Gebruiker " + naam + ", let op: " + message);
    }
}
