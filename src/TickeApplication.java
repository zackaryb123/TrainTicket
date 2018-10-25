import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class TickeApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Ticket newTicket = new Ticket();

        boolean flag = true;
        while(flag){
            System.out.println("Welcome to Train ticketing booth\n");

            try {
                // get user ticket info and write to passenger DB
                newTicket = UserInput.getTicketInput();
                // write ticket to db and file
//                newTicket.writeTicket();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Unhandled Exception Exist");
            } catch (NoTrainException e) {
                e.msg();
            } catch (InvalidDateException e) {
                e.msg();
            } catch (DateBeforeCurrentDateException e) {
                e.msg();
            } catch (AtleastOnePassengerException e) {
                e.msg();
            }

            try {
                newTicket.writeTicket();
            } catch (SQLException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("\nEnter any key to continue or 'Q' to quite" );
            flag = !scanner.nextLine().equals("Q");
        }
    }
}
