package com.damy.data;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class StatisticController {

    @GetMapping("/city-stat")
    public ResponseEntity<List<CityStatistic>> getCityStatistic(){

        List<CityStatistic> list = new ArrayList<>();
        list.add(new CityStatistic("Beograd",45.0));
        list.add(new CityStatistic("Novi Sad",35.0));
        list.add(new CityStatistic("Nis",11.5));
        list.add(new CityStatistic("Subotica",3.5));
        list.add(new CityStatistic("Kragujevac",1.5));
        list.add(new CityStatistic("Ostali gradovi",3.5));
        return new ResponseEntity<>(list,OK);
    }

    @GetMapping("/time-stat")
    public ResponseEntity<List<TimeStatistic>> getTimeStatistic(){
        List<TimeStatistic> list = new ArrayList<>();
        list.add(new TimeStatistic("6h",2.0));
        list.add(new TimeStatistic("8h",50.0));
        list.add(new TimeStatistic("10h",160.0));
        list.add(new TimeStatistic("12h",100.0));
        list.add(new TimeStatistic("14h",80.0));
        list.add(new TimeStatistic("16h",320.0));
        list.add(new TimeStatistic("18h",500.0));
        list.add(new TimeStatistic("20h",600.0));
        list.add(new TimeStatistic("22h",100.0));
        list.add(new TimeStatistic("24h",5.0));
        list.add(new TimeStatistic("2h",2.0));
        list.add(new TimeStatistic("4h",0.0));
        return new ResponseEntity<>(list,OK);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> executePayment(@RequestHeader("total-price") Double totalPrice){
        if(totalPrice < Customer.bankAccountState){
            Customer.bankAccountState = Customer.bankAccountState - totalPrice;
            return new ResponseEntity<>("Uspesna kupovina",OK);
        }else{
            return new ResponseEntity<>("Neuspela kupovina",OK);
        }
    }


}


