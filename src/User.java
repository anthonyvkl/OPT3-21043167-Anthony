import java.util.Scanner;

class User {

    public void UserEntry() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welkom bij Vitalarm.\nWat is uw naam?");

        String naam = scanner.nextLine();

        System.out.println("Hi! " + naam + ", bedankt voor het kiezen van Vitalarm.");

        System.out.println("Ik zal je helpen met het bijhouden van je medicatie! :)");


    }
}
