package com.mintic.Reto3.Repository.Crud;

import com.mintic.Reto3.Model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ReservationCrudRepositoryInterfaz extends CrudRepository <Reservation, Integer >{
  
  public List<Reservation> findAllByStatus(String status);
  
  public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date enddate);

  @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
   public List<Object[]> reportClients();

}
