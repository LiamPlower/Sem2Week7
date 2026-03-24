package ie.atu.week7solution.controller;

import ie.atu.week7solution.model.Reservation;
import ie.atu.week7solution.service.ReservationService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody Reservation reservation) {
        Reservation saved = reservationService.addReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return (ResponseEntity<List<Reservation>>) ResponseEntity.ok();
    }
}

