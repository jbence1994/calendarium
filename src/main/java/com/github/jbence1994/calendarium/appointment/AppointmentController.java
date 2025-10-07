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
    private final CreateAppointmentRequestSanitizer createAppointmentRequestSanitizer;
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    public ResponseEntity<CreateAppointmentResponse> createAppointment(@Valid @RequestBody CreateAppointmentRequest request) {
        var sanitizedRequest = createAppointmentRequestSanitizer.sanitize(request);

        var appointment = appointmentMapper.toEntity(sanitizedRequest);

        appointment = appointmentService.createAppointment(appointment);

        var response = appointmentMapper.toResponse(appointment);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
