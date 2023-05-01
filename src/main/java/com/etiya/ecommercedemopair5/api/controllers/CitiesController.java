package com.etiya.ecommercedemopair5.api.controllers;


import com.etiya.ecommercedemopair5.business.abstracts.CityService;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.IdCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.CityResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    //Add, Delete, Update, List, GetById

    private CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public DataResult<CityResponse> add(@Valid @RequestBody AddCityRequest addCityRequest){
        return cityService.add(addCityRequest);
    }

    @PostMapping ("")
    public DataResult<CityResponse> getById(@RequestBody IdCityRequest idCityRequest){
        return cityService.getById(idCityRequest);
    }

    @DeleteMapping("")
    public SuccessResult delete(@RequestBody IdCityRequest idCityRequest){
        return cityService.remove(idCityRequest);
    }

}
