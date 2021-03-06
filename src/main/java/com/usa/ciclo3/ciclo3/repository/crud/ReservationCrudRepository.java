package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    @Query("SELECT c.status, COUNT(c.status) FROM Reservation AS c GROUP BY c.status ORDER BY COUNT(c.status) DESC")
    public List<Object[]> countTotalReservationByStatus();
}
