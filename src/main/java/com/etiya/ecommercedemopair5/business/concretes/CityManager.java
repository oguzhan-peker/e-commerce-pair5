package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.CityService;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.IdCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.CityResponse;
import com.etiya.ecommercedemopair5.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessResult;
import com.etiya.ecommercedemopair5.entities.concrete.City;
import com.etiya.ecommercedemopair5.repositories.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
        this.cityDao = cityDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<CityResponse> add(AddCityRequest addCityRequest) {
        City city = modelMapperService.forRequest().map(addCityRequest, City.class);

        cityDao.save(city);
        CityResponse response = modelMapperService.forResponse().map(city, CityResponse.class);
        return new DataResult<>(response, true, "City added.");

    }

    @Override
    public SuccessResult remove(IdCityRequest idCityRequest) {
        cityDao.deleteById(idCityRequest.getId());
        return new SuccessResult("Data deleted succesfuly.");
    }

    @Override
    public DataResult<CityResponse> getById(IdCityRequest idCityRequest) {
        City city = modelMapperService.forRequest().map(idCityRequest, City.class);
        cityDao.getById(idCityRequest.getId());
        CityResponse response = modelMapperService.forResponse().map(city, CityResponse.class);
        return new SuccessDataResult<>(response);
    }

    //TODO: Id kontrolü yap.
}
