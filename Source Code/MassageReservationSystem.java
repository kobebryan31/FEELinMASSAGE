import java.util.ArrayList;
import java.util.Scanner;

class Service {
    protected String name;
    protected int roomId;

    public Service(String name, int roomId) {
        this.name = name;
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public int getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {
        return "Room " + roomId + ": " + name;
    }
}

class SwedishMassage extends Service {
    public SwedishMassage() {
        super("Swedish Massage", 1);
    }
}

class DeepTissueMassage extends Service {
    public DeepTissueMassage() {
        super("Deep Tissue Massage", 2);
    }
}

class SportsMassage extends Service {
    public SportsMassage() {
        super("Sports Massage", 3);
    }
}

class HotStoneMassage extends Service {
    public HotStoneMassage() {
        super("Hot Stone Massage", 4);
    }
}

class AromatherapyMassage extends Service {
    public AromatherapyMassage() {
        super("Aromatherapy Massage", 5);
    }
}

class ThaiMassage extends Service {
    public ThaiMassage() {
        super("Thai Massage", 6);
    }
}

class Reflexology extends Service {
    public Reflexology() {
        super("Reflexology", 7);
    }
}

class PrenatalMassage extends Service {
    public PrenatalMassage() {
        super("Prenatal Massage", 8);
    }
}

class ShiatsuMassage extends Service {
    public ShiatsuMassage() {
        super("Shiatsu Massage", 9);
    }
}

class ChairMassage extends Service {
    public ChairMassage() {
        super("Chair Massage", 10);
    }
}

class MassageReservationSystem {
    private static final double MASSAGE_PRICE = 1500.00;
    private static final String MASSAGE_DURATION = "1:30:00";

    private static final Service[] SERVICES = {
        new SwedishMassage(),
        new DeepTissueMassage(),
        new SportsMassage(),
        new HotStoneMassage(),
        new AromatherapyMassage(),
        new ThaiMassage(),
        new Reflexology(),
        new PrenatalMassage(),
        new ShiatsuMassage(),
        new ChairMassage()
    };

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Massage Reservation System ---");
            System.out.println("1. Make a Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Delete a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    showServices(scanner);
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    deleteReservation(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Massage Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void showServices(Scanner scanner) {
        System.out.println("\n--- Available Services ---");
        for (Service service : SERVICES) {
            System.out.println(service);
        }
        makeReservation(scanner);
    }

    private void makeReservation(Scanner scanner) {
        System.out.println("\n--- Make a Reservation ---");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Select a Service (1-10): ");
        int serviceChoice = scanner.nextInt();
        scanner.nextLine();

        if (serviceChoice < 1 || serviceChoice > SERVICES.length) {
            System.out.println("Invalid choice. Reservation failed.");
            return;
        }

        Service selectedService = SERVICES[serviceChoice - 1];

        System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Reservation Time (HH:MM): ");
        String time = scanner.nextLine();

        // Check for conflicts
        if (isRoomAvailable(selectedService.getRoomId(), date, time)) {
            Reservation reservation = new Reservation(firstName, lastName, contactNumber, selectedService, date, time);
            reservations.add(reservation);
            System.out.println("\nReservation successful!");
            System.out.println("Reservation Details:\n" + reservation);
        } else {
            System.out.println("Room is already reserved at the selected time. Please choose a different time or room.");
        }
    }

    private void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations made yet.");
        } else {
            System.out.println("\n--- Current Reservations ---");
            for (int i = 0; i < reservations.size(); i++) {
                System.out.println("Reservation #" + (i + 1) + ":\n" + reservations.get(i) + "\n");
            }
        }
    }

    private void deleteReservation(Scanner scanner) {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations to delete.");
            return;
        }

        viewReservations();

        System.out.print("Enter the reservation number to delete: ");
        int reservationNumber = scanner.nextInt();
        scanner.nextLine(); 

        if (reservationNumber < 1 || reservationNumber > reservations.size()) {
            System.out.println("Invalid reservation number. Deletion failed.");
        } else {
            reservations.remove(reservationNumber - 1);
            System.out.println("Reservation successfully deleted!");
        }
    }

    private boolean isRoomAvailable(int roomId, String date, String time) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomId() == roomId && reservation.getDate().equals(date) && reservation.getTime().equals(time)) {
                return false;
            }
        }
        return true;
    }

    private class Reservation {
        private String firstName;
        private String lastName;
        private String contactNumber;
        private Service service;
        private String date;
        private String time;

        public Reservation(String firstName, String lastName, String contactNumber, Service service, String date, String time) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.contactNumber = contactNumber;
            this.service = service;
            this.date = date;
            this.time = time;
        }

        public int getRoomId() {
            return service.getRoomId();
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Customer Information:\n" +
                   "First Name: " + firstName + "\n" +
                   "Last Name: " + lastName + "\n" +
                   "Contact Number: " + contactNumber + "\n" +
                   "Service: " + service.getName() + "\n" +
                   "Room: " + service.getRoomId() + "\n" +
                   "Date: " + date + "\n" +
                   "Time: " + time + "\n" +
                   "Price: Php " + String.format("%.2f", MASSAGE_PRICE) + "\n" +
                   "Duration: " + MASSAGE_DURATION;
        }
    }

    public static void main(String[] args) {
        MassageReservationSystem system = new MassageReservationSystem();
        system.showMenu();
    }
}

