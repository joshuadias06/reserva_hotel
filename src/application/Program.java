package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room Number:");
        int roomNumber = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy):");
        Date checkin = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy):");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)) {
            System.out.println("ERROR IN RESERVATION! Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to updated the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy):");
            checkin = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy):");
            checkout = sdf.parse(sc.next());

            String error = reservation.updatedDates(checkin, checkout);

            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();
    }
}