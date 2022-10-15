package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Repository.Crud.ReservationCrudRepositoryInterfaz;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepositoryInterfaz reservationCrudRepositoryInterfaz;
    
   public List <Reservation> getReservationAll(){
        return (List<Reservation>) reservationCrudRepositoryInterfaz.findAll();
   } 
  
   public Optional <Reservation> getReservationId(Integer id){
       return reservationCrudRepositoryInterfaz.findById(id);
   }
        
   public Reservation saveReservation(Reservation   reservation){
       return reservationCrudRepositoryInterfaz.save(reservation);
   }     
 
   public List<Reservation> ReservationStatus(String status){
        return reservationCrudRepositoryInterfaz.findAllByStatus(status);
    }

    public List<Reservation> reservationTime(Date startDate, Date endDate){
        return reservationCrudRepositoryInterfaz.findAllByStartDateAfterAndStartDateBefore(startDate, startDate);
    }
  
    public   List<Object[]> reportClient() {
        return reservationCrudRepositoryInterfaz.reportClients();

    }

}