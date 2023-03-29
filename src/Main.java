import javax.management.NotificationFilter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welkom bij Vitalarm.\nWat is uw naam?");
//
//        String naam = scanner.nextLine();
//
//        System.out.println("Hi! " + naam + ", bedankt voor het kiezen van Vitalarm.");
//
//        System.out.println("Ik zal je helpen met het bijhouden van je medicatie! :)");

        User user1 = new User();
        user1.UserEntry();

        Medicatie medicatie1 = new Medicatie();

        medicatie1.voegMedicatieToe();

        Notificatie notificatie1 = new Notificatie();

        notificatie1.notificatieMethode(medicatie1.medicaties);


//        Scanner scanner1 = new Scanner(System.in);

//        System.out.println("type 1 voor voegmed");
//        int choice= scanner1.nextInt();
//        switch (choice){
//            case 1:        medicatie1.voegMedicatieToe();
//
//                break;
//            default:
//                System.out.println("");
//        }

    }
}


