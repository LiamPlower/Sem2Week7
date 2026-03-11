package ie.atu.week7solution.service;

import ie.atu.week7solution.model.Reservation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    public Reservation addReservation(@Valid Reservation reservation)
    {
        return new Reservation();
    }
}
