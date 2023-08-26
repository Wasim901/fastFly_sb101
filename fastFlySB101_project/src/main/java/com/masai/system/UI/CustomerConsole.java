package com.masai.system.UI;

import java.util.List;
import java.util.Scanner;
import com.masai.system.DAO.CustomerDao;
import com.masai.system.DAO.CustomerDaoImp;
import com.masai.system.DAO.FlightDao;
import com.masai.system.DAO.FlightDaoImp;
import com.masai.system.DTO.Booking;
import com.masai.system.DTO.Customer;
import com.masai.system.DTO.Flight;

public class CustomerConsole {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerDao customerDao = new CustomerDaoImp();
    private static final FlightDao flightDao = new FlightDaoImp();

    public static void main(String[] args) {
        System.out.println("Welcome to the Customer Console!");
        login();
    }

    private static void login() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Customer customer = customerDao.getCustomerByEmail(email);

        if (customer != null && customer.getPassword().equals(password)) {
            System.out.println("Login successful!");
            customerMenu(customer);
        } else {
            System.out.println("Invalid credentials. Please try again.");
            login();
        }
    }

    private static void customerMenu(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Search Flights");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    searchFlights(customer);
                    break;
                case 2:
                    viewBookings(customer);
                    break;
                case 3:
                    cancelBooking(customer);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchFlights(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        // Gather search criteria from the customer
        System.out.print("Enter departure city: ");
        String departureCity = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destinationCity = scanner.nextLine();
        System.out.print("Enter departure date (YYYY-MM-DD): ");
        String departureDate = scanner.nextLine();

        // Fetch available flights from FlightDao based on the search criteria
        List<Flight> availableFlights = flightDao.searchFlights(departureCity, destinationCity, departureDate);

        if (availableFlights.isEmpty()) {
            System.out.println("No flights available for the given criteria.");
        } else {
            System.out.println("Available flights:");
            for (Flight flight : availableFlights) {
                // Display flight details to the customer
                System.out.println(flight.toString());  // Override toString() in Flight class
            }

            // Allow customer to select a flight for booking
            System.out.print("Enter the flight number to book: ");
            String flightNumber = scanner.nextLine();
            
            // Implement booking process using BookingDao
            // Create a new booking, associate it with the customer, and save to the database
            Booking newBooking = new Booking(/* Initialize booking details */);
            customer.getBookings().add(newBooking);
            customerDao.updateCustomer(customer);
            System.out.println("Booking successful!");
        }
    }

    private static void viewBookings(Customer customer) {
        List<Booking> bookings = customer.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("You have no bookings.");
        } else {
            System.out.println("Your bookings:");
            for (Booking booking : bookings) {
                // Display booking details
                System.out.println(booking.toString());  // Override toString() in Booking class
            }
        }
    }

    private static void cancelBooking(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter booking ID to cancel: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Booking bookingToCancel = customerDao.getBookingById(bookingId);

        if (bookingToCancel != null) {
            // Implement logic to cancel the booking using BookingDao
            // Remove the booking from customer's bookings and update the customer
            customer.getBookings().remove(bookingToCancel);
            customerDao.updateCustomer(customer);
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Booking not found.");
        }
    }
}