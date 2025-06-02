package com.movie.ticket.booking.system.service.bookingService.dtos;

import com.movie.ticket.booking.system.service.bookingService.enums.BookingStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class BookingDto {

    private UUID bookingId;

    @NotBlank(message = "userId is mandatory")
    private String userId;
    @Positive(message = "Please provide movie-id")
    private int movieId;
    @NotEmpty(message = "Please select atleast one seat")
    private List<String> seatsSelected;
    @NotNull(message = "please select show date")
    private LocalDate showDate;
    @NotNull(message = "please select show time")
    private LocalTime showTime;

    private Double bookingAmount;

    private BookingStatus bookingStatus;

}
