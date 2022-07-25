package com.example.SpringServer.DAO;

import com.example.SpringServer.model.City;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PossibleFlightDAO {

    private String id;
    private City fromId;
    private City toId;
    private String planeTypes;
    private Date dateFlight;
    private int freePlaces;
    private int sumTicket;

    public PossibleFlightDAO(String id, City fromId, City toId, String planeTypes, Date dateFlight, int freePlaces, int sumTicket) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.planeTypes = planeTypes;
        this.dateFlight = dateFlight;
        this.freePlaces = freePlaces;
        this.sumTicket = sumTicket;
    }
}
