package com.movie.ticket.booking.system.service.bookingService.repositories;

import com.movie.ticket.booking.system.service.bookingService.entities.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookingRepo extends CrudRepository<BookingEntity, UUID> {
}
