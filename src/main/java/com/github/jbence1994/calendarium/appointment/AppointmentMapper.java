package com.github.jbence1994.calendarium.appointment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(
            target = "organizer",
            expression = """
                    java(
                    appointment.getOrganizer().getFirstName() + " " +
                    appointment.getOrganizer().getMiddleName() + ", " +
                    appointment.getOrganizer().getLastName()
                    )
                    """
    )
    CreateAppointmentResponse toResponse(Appointment appointment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizer", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "participants", ignore = true)
    Appointment toEntity(CreateAppointmentRequest request);
}
