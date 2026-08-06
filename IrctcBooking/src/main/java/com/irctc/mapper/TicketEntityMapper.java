package com.irctc.mapper;

import org.mapstruct.Mapper;

import com.irctc.entity.TicketEntity;
import com.irctc.request.BookingRequest;

//@Mapper(componentModel = "spring")
//public interface TicketEntityMapper {
//	
//	TicketEntity BookingReqToTicketEntityMapper(BookingRequest req);
//}

@Mapper(componentModel = "spring")
public interface TicketEntityMapper {
	TicketEntity bookingReqToTicketEntityMapper(BookingRequest req);
}