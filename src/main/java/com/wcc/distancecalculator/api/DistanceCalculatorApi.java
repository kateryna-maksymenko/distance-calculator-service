package com.wcc.distancecalculator.api;

import com.wcc.distancecalculator.dto.DistanceCalculationResult;
import com.wcc.distancecalculator.dto.PostCodeDto;

public interface DistanceCalculatorApi {

    DistanceCalculationResult calculateDistanceBetweenTwoLocations(String zipCode1, String zipCode2);

    PostCodeDto getPostCodeByCode(String postCode);

    void updatePostCodeInfo(PostCodeDto postCodeInfo);
}
