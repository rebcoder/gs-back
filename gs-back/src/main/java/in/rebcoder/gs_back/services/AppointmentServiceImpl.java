package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByUser(User user) {
        return appointmentRepository.findByUser(user);
    }

    public List<Appointment> getAppointmentsByHome(Home home) {
        return appointmentRepository.findByHome(home);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow();
        existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        existingAppointment.setStatus(updatedAppointment.getStatus());
        existingAppointment.setInterestedItems(updatedAppointment.getInterestedItems());
        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
