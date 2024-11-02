package in.rebcoder.gs_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // The user who wants to visit the garage sale

    @ManyToOne
    @JoinColumn(name = "home_id", nullable = false)
    private Home home; // The home where the garage sale is

    private LocalDateTime appointmentTime; // Scheduled time for the visit

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status; // Status of the appointment (e.g., PENDING, CONFIRMED, COMPLETED)

    @ManyToMany
    @JoinTable(
            name = "appointment_items",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> interestedItems; // Items user is interested in buying

}

