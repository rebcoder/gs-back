package in.rebcoder.gs_back.repositories;

import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUser(User user);
    List<Appointment> findByHome(Home home);

    Appointment findByHomeAndAppointmentTime(Home home, LocalDateTime appointmentTime);
}
