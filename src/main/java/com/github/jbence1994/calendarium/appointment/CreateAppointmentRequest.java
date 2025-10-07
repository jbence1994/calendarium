package com.github.jbence1994.calendarium.appointment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@StartDateBeforeEndDateValidation
public class CreateAppointmentRequest {

    @NotNull(message = "Appointment's name must be provided.")
    @NotEmpty(message = "Appointment's name must be not empty.")
    private String name;

    @NotNull(message = "Appointment's start date must be provided.")
    private LocalDateTime startDate;

    @NotNull(message = "Appointment's end date must be provided.")
    private LocalDateTime endDate;

    private String description;
}
