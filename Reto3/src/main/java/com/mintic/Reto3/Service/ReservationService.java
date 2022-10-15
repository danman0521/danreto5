package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Reports.CountClients;
import com.mintic.Reto3.Reports.ReservationStatus;
import com.mintic.Reto3.Repository.ReservationRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository ReservationRepository;

    public List<Reservation> getReservationAll() {
        return ReservationRepository.getReservationAll();
    }

    public Optional<Reservation> getReservationId(Integer id) {
        return ReservationRepository.getReservationId(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return ReservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> reservationAuxiliar = ReservationRepository.getReservationId(reservation.getIdReservation());
            if (reservationAuxiliar.isEmpty()) {
                return ReservationRepository.saveReservation(reservation);
            } else {
                return reservation;
            }
        }
    }

    public ReservationStatus reservationStatus() {

        List<Reservation> completed = ReservationRepository.ReservationStatus("completed");
        List<Reservation> cancelled = ReservationRepository.ReservationStatus("cancelled");

        return new ReservationStatus(completed.size(), cancelled.size());
    }

    public List<Reservation> ReservationTime(String startDate, String endDate) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date dateOne = new Date();
        Date dateTwo = new Date();

        try {
            dateOne = parser.parse(startDate);
            dateTwo = parser.parse(endDate);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (dateOne.before(dateTwo)) {
            return ReservationRepository.reservationTime(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }

    public List<CountClients> reportClients() {
        List<CountClients> result = new ArrayList<>();
        List<Object[]> report = ReservationRepository.reportClient();
        System.out.println(report);
        for (int i = 0; i < report.size(); i++) {
            result.add(new CountClients((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return result;
    }

}
