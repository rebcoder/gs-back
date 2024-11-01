package in.rebcoder.gs_back.controllers;

import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/user/{userId}")
    public List<Appointment> getAppointmentsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // Retrieve user instance if needed from user service
        return appointmentService.getAppointmentsByUser(user);
    }

    @GetMapping("/home/{homeId}")
    public List<Appointment> getAppointmentsByHome(@PathVariable Long homeId) {
        Home home = new Home();
        home.setId(homeId); // Retrieve home instance if needed from home service
        return appointmentService.getAppointmentsByHome(home);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointment(id, updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
