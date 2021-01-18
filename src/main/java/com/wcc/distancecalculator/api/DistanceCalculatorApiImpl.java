package com.wcc.distancecalculator.api;

import com.wcc.distancecalculator.dto.DistanceCalculationResult;
import com.wcc.distancecalculator.dto.Location;
import com.wcc.distancecalculator.dto.PostCodeDto;
import com.wcc.distancecalculator.model.PostcodeInfo;
import com.wcc.distancecalculator.repository.PostcodeRepository;
import com.wcc.distancecalculator.translator.PostcodeInfoTranslator;
import com.wcc.distancecalculator.util.DistanceCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorApiImpl implements DistanceCalculatorApi {

    @Autowired
    private PostcodeRepository repository;

    @Autowired
    private PostcodeInfoTranslator translator;

    @Override
    public DistanceCalculationResult calculateDistanceBetweenTwoLocations(String zipCode1, String zipCode2) {

        PostcodeInfo postcodeInfo1 = repository.findByPostCode(zipCode1);
        PostcodeInfo postcodeInfo2 = repository.findByPostCode(zipCode2);

        double distance = DistanceCalculatorUtil.calculateDistance(postcodeInfo1.getLatitude(), postcodeInfo1.getLongitude(), postcodeInfo2.getLatitude(), postcodeInfo2.getLongitude());

        Location startLocation = translator.translateToLocation(postcodeInfo1);
        Location endLocation = translator.translateToLocation(postcodeInfo2);
        return new DistanceCalculationResult(startLocation, endLocation, distance);

    }

    @Override
    public PostCodeDto getPostCodeByCode(String postCode) {
        PostcodeInfo postcodeInfo = repository.findByPostCode(postCode);
        return translator.translateToPostCodeDto(postcodeInfo);
    }

    @Override
    public void updatePostCodeInfo(PostCodeDto postCodeDto) {
        PostcodeInfo postcodeInfo = translator.translateFromPostCodeDto(postCodeDto);
        repository.save(postcodeInfo);
    }


}
