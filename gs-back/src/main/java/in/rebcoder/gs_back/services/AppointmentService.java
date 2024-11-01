package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.User;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);

    List<Appointment> getAppointmentsByUser(User user);

    List<Appointment> getAppointmentsByHome(Home home);

    Appointment updateAppointment(Long id, Appointment updatedAppointment);

    void deleteAppointment(Long id);
}
