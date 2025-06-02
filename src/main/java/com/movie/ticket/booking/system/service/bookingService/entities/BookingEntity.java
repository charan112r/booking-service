package com.movie.ticket.booking.system.service.bookingService.entities;

import com.movie.ticket.booking.system.service.bookingService.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "movie_id")
    private int movieId;
    @ElementCollection
    private List<String> seatsSelected;
    @Column(name = "show_date")
    private LocalDate showDate;
    @Column(name = "show_time")
    private LocalTime showTime;
    @Column(name = "booking_status")
    private BookingStatus bookingStatus;
    @Column(name = "booking_amount")
    private Double bookingAmount;


}
