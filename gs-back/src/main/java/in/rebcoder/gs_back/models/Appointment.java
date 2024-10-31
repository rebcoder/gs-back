package in.rebcoder.gs_back.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appointmentDate;
    @ManyToOne
    private User buyer;  // Buyer making the appointment
    @ManyToOne
    private Home home;   // Home where the sale takes place
    @ManyToMany
    private List<Item> interestedItems;  // Items the buyer is interested in
}

