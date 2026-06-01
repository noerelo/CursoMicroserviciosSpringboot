package com.aleal.reservations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleal.reservations.dao.IReservationDao;
import com.aleal.reservations.model.Reservation;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;
	
	@Override
	public List<Reservation> search() {
		return (List<Reservation>) reservationDao.findAll();
	}

}
