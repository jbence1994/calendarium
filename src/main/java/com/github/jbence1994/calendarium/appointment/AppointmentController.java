package com.github.jbence1994.calendarium.appointment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentDtoSanitizer appointmentDtoSanitizer;
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    public ResponseEntity<?> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        var sanitizedAppointmentDto = appointmentDtoSanitizer.sanitize(appointmentDto);

        var appointment = appointmentMapper.toEntity(sanitizedAppointmentDto);

        appointmentService.createAppointment(appointment);

        sanitizedAppointmentDto.setId(appointment.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(sanitizedAppointmentDto);
    }
}
