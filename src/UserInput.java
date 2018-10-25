import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/*****User Defined Exceptions*****/
class NoTrainException extends Exception {
     void msg(){
         System.out.println("Train with given train number does not exist");
    }
}

class InvalidDateException extends Exception {
    void msg(){
        System.out.println("Invalid date format: (mm/dd/yyyy)");
    }
}

class DateBeforeCurrentDateException extends Exception {
    void msg(){
        System.out.println("Travel Date is before current date");
    }
}

class AtleastOnePassengerException extends Exception {
    void msg(){
        System.out.println("Must have at least one passenger");
    }
}

/*****User Input Class*******/
public class UserInput {
    static Scanner scanner = new Scanner(System.in);

    static Ticket getTicketInput() throws SQLException, ClassNotFoundException, NoTrainException, InvalidDateException, DateBeforeCurrentDateException, AtleastOnePassengerException {
        System.out.println("Enter the Train Number:");
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number");
            scanner.next();
        }
        int trainNo = scanner.nextInt();

        Train train = TrainDAO.findTrain(trainNo);

        if(train == null) throw new NoTrainException();

        System.out.println("Enter travel Date:");
        scanner.nextLine();
        String date = scanner.nextLine();

        LocalDate fDate = null;
        try {
            String[] dateArr = date.split("/");
            fDate = LocalDate.of(
                    Integer.valueOf(dateArr[2]),
                    Integer.valueOf(dateArr[1]),
                    Integer.valueOf(dateArr[0]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidDateException();
        }

        LocalDate currDate = LocalDate.now();

        if(fDate.getYear() <  currDate.getYear()){
            throw new DateBeforeCurrentDateException();
        } else if(fDate.getYear() ==  currDate.getYear() &&
        fDate.getMonthValue() < currDate.getMonthValue()){
            throw new DateBeforeCurrentDateException();
        } else if (fDate.getYear() ==  currDate.getYear() &&
                fDate.getMonthValue() == currDate.getMonthValue() &&
        fDate.getDayOfMonth() < currDate.getDayOfMonth()){
            throw new DateBeforeCurrentDateException();
        }
        //TODO: handle DatTimeException (month int 1-12)

        System.out.println("Enter Number of Passengers:");
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number greater that 0");
            scanner.next();
        }
        int numPass = scanner.nextInt();

        if(numPass <= 0) throw new AtleastOnePassengerException();

        Ticket t = new Ticket(fDate, train);

        for(int i = 0; i < numPass; i++){
            System.out.println("Enter Passenger Name:");
            String name = scanner.next();

            scanner.nextLine();

            System.out.println("Enter Age:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number");
                scanner.next();
            }
            int age = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter Gender:");
            String gender = scanner.nextLine();

            t.addPassenger(name, age, gender.charAt(0));
        }
        return t;
    }
}
