package com.example.SpringServer.DAO;


import com.example.SpringServer.model.City;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchPossibleFlightDAO {

    private City toCity;
    private City fromCity;
    private Date dateFlight;


    public SearchPossibleFlightDAO(City toCity, City fromCity, Date dateFlight) {
        this.toCity = toCity;
        this.fromCity = fromCity;
        this.dateFlight = dateFlight;

    }

    public SearchPossibleFlightDAO(Date dateFlight) {
        this.dateFlight = dateFlight;
    }
}
