package ie.atu.week7solution.service;

Reservation Service:

import ie.atu.week7solution.exception.ReservationConflictException;
import ie.atu.week7solution.model.Reservation;
import org.springframework.stereotype.Service;
import ie.atu.week7solution.repository.ReservationRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    public Reservation addReservation(Reservation reservation) {

        reservation.setReservationID(nextId++);

        int newStart = reservation.getStartHour();
        int newEnd = newStart + reservation.getDurationHour();

        for (Reservation existing : reservations) {

            if (existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
                    existing.getReservationDate().equals(reservation.getReservationDate())) {
                int existingStart = existing.getStartHour();
                int existingEnd = existingStart + existing.getDurationHours();

                if (existingStart < newEnd && newStart < existingEnd) {
                    reservation.setReservationID(nextId--);
                    throw new ReservationConflictException("Time slot already booked");
                }
            }
        }
        ReservationRepo.add(reservation);
        return reservation;
    }
}
