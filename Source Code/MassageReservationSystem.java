import java.util.ArrayList;
import java.util.Scanner;

class MassageReservationSystem {
    private static final double MASSAGE_PRICE = 1500.00;
    private static final String MASSAGE_DURATION = "1:30:00";

    private static final String[] SERVICES = {
        "Swedish Massage",
        "Deep Tissue Massage",
        "Sports Massage",
        "Hot Stone Massage",
        "Aromatherapy Massage",
        "Thai Massage",
        "Reflexology",
        "Prenatal Massage",
        "Shiatsu Massage",
        "Chair Massage"
    };

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Massage Reservation System ---");
            System.out.println("1. Make a Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Exit");
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
                    System.out.println("Thank you for using the Massage Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private void showServices(Scanner scanner) {
        System.out.println("\n--- Available Services ---");
        for (int i = 0; i < SERVICES.length; i++) {
            System.out.println((i + 1) + ". " + SERVICES[i]);
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

        int roomId = serviceChoice;

        System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Reservation Time (HH:MM): ");
        String time = scanner.nextLine();

        if (isRoomAvailable(roomId, date, time)) {
            Reservation reservation = new Reservation(firstName, lastName, contactNumber, roomId, SERVICES[roomId - 1], date, time);
            reservations.add(reservation);
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Room is already reserved at the selected time. Please choose a different time or room.");
        }
    }

    private void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations made yet.");
        } else {
            System.out.println("\n--- Current Reservations ---");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
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
        private int roomId;
        private String serviceName;
        private String date;
        private String time;

        public Reservation(String firstName, String lastName, String contactNumber, int roomId, String serviceName, String date, String time) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.contactNumber = contactNumber;
            this.roomId = roomId;
            this.serviceName = serviceName;
            this.date = date;
            this.time = time;
        }

        public int getRoomId() {
            return roomId;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return String.format("Customer: %s %s, Contact: %s, Service: %s, Room: %d, Date: %s, Time: %s, Price: Php %.2f, Duration: %s",
                firstName, lastName, contactNumber, serviceName, roomId, date, time, MASSAGE_PRICE, MASSAGE_DURATION);
        }
    }

    public static void main(String[] args) {
        MassageReservationSystem system = new MassageReservationSystem();
        system.showMenu();
    }
}


