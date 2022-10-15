package com.mintic.Reto3.Controller;

import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Reports.CountClients;
import com.mintic.Reto3.Reports.ReservationStatus;
import com.mintic.Reto3.Service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService  reservationService;
    
    @GetMapping("/all")
    public List <Reservation> getReservationAll(){
            return reservationService.getReservationAll();
    }
    @GetMapping("/{id}")
    public Optional <Reservation> getReservationId(@PathVariable("id")Integer identificador){
        return reservationService.getReservationId(identificador);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }
   
   @GetMapping("/report-status")
    public ReservationStatus getStatusReservation() {
        return reservationService.reservationStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationTime(@PathVariable("dateOne") String startDate,@PathVariable("dateTwo") String endDate) {
        return reservationService.ReservationTime(startDate, endDate);
    }

    @GetMapping("/report-clients")
    public List<CountClients> getClientes() {
        return reservationService.reportClients();
    }    
}