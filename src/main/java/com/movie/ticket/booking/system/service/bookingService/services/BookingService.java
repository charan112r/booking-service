package com.movie.ticket.booking.system.service.bookingService.services;

import com.movie.ticket.booking.system.service.bookingService.dtos.BookingDto;
import com.movie.ticket.booking.system.service.bookingService.dtos.ResponseDto;


public interface BookingService {
    public ResponseDto createBooking(BookingDto bookingDto);
}
