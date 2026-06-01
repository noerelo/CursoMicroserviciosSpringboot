package com.aleal.reservations.dao;

import org.springframework.data.repository.CrudRepository;

import com.aleal.reservations.model.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long>{

}
