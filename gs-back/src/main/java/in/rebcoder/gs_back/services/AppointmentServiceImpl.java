package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.exception.ResourceNotFoundException;
import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.AppointmentStatus;
import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.PENDING);
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

    @Override
    public Appointment scheduleAppointment(Appointment appointment) {
        // Validate if appointment slot is available
        Appointment existingAppointment = appointmentRepository.findByHomeAndAppointmentTime(
                appointment.getHome(), appointment.getAppointmentTime());

        if (!existingAppointment.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("This time slot is already booked.");
        }

        // Save the new appointment
        return appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointmentStatus(long appointmentId, AppointmentStatus status) {
        // Find the appointment by its ID
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

        // Update the status and save
        appointment.setStatus(status);
        appointmentRepository.save(appointment);
    }
}
