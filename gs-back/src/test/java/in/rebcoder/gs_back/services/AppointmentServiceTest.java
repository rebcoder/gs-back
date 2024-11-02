package in.rebcoder.gs_back.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.rebcoder.gs_back.models.Appointment;
import in.rebcoder.gs_back.models.AppointmentStatus;
import in.rebcoder.gs_back.repositories.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class AppointmentServiceTest {
    /*
    In unit testing with Spring,
    using @Mock and @InjectMocks is essential for isolating the functionality of a service layer by creating controlled, test-friendly versions of its dependencies:

    @Mock: This annotation creates a "mock" object—a stand-in for a dependency like a repository.
    Instead of connecting to a real database, it simulates behavior, returning predefined values when methods are called.
    This allows you to test your service layer without affecting or relying on actual database data.

    @InjectMocks: This annotation injects the mocked dependencies (created with @Mock) into the service under test.
    For example, if your service uses a repository, @InjectMocks links the mock repository to the service instance,
    making it possible to verify that the service behaves correctly given specific mock data or scenarios.

    Using these annotations helps ensure tests focus solely on the service’s logic, not on external dependencies.
    This approach is fundamental for writing reliable, isolated unit tests.
    */

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    public AppointmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenScheduleAppointment_thenAppointmentIsSaved() {
        Appointment appointment = new Appointment();
        appointment.setStatus(AppointmentStatus.PENDING);

        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment savedAppointment = appointmentService.scheduleAppointment(appointment);

        assertNotNull(savedAppointment);
        assertEquals(AppointmentStatus.PENDING, savedAppointment.getStatus());
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void whenUpdateAppointmentStatus_thenStatusIsUpdated() {
        Appointment appointment = new Appointment();
        appointment.setStatus(AppointmentStatus.PENDING);

        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(appointment));

        appointmentService.updateAppointmentStatus(1L,AppointmentStatus.CONFIRMED);

        assertEquals(AppointmentStatus.CONFIRMED, appointment.getStatus());
        verify(appointmentRepository, times(1)).save(appointment);
    }
}

