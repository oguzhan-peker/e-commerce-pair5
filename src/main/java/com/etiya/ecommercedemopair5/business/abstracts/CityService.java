package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.IdCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.CityResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessResult;

public interface CityService {

    DataResult<CityResponse> add(AddCityRequest addCityRequest);
    SuccessResult remove(IdCityRequest idCityRequest);
    DataResult<CityResponse> getById(IdCityRequest idCityRequest);

}
