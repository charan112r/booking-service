package com.movie.ticket.booking.system.service.bookingService.utility;

import com.movie.ticket.booking.system.service.bookingService.dtos.BookingDto;
import com.movie.ticket.booking.system.service.bookingService.entities.BookingEntity;
import com.movie.ticket.booking.system.service.bookingService.enums.BookingStatus;

public class DtoConvertor {

    public static BookingEntity convertBookingDtoToBookingEntity(BookingDto bookingDto) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setUserId(bookingDto.getUserId());
        bookingEntity.setMovieId(bookingDto.getMovieId());
        bookingEntity.setSeatsSelected(bookingDto.getSeatsSelected());
        bookingEntity.setShowDate(bookingDto.getShowDate());
        bookingEntity.setShowTime(bookingDto.getShowTime());
        bookingEntity.setBookingStatus(BookingStatus.PENDING);
        return bookingEntity;
    }
}
