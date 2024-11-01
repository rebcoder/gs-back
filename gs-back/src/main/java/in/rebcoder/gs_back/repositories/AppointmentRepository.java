package in.rebcoder.gs_back.repositories;

import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUser(User user);
    List<Appointment> findByHome(Home home);
}
