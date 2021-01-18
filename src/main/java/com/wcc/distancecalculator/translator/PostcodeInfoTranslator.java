package com.wcc.distancecalculator.translator;

import com.wcc.distancecalculator.dto.Location;
import com.wcc.distancecalculator.dto.PostCodeDto;
import com.wcc.distancecalculator.model.PostcodeInfo;
import org.springframework.stereotype.Component;

@Component
public class PostcodeInfoTranslator {

    public Location translateToLocation(PostcodeInfo postcodeInfo) {
        return new Location(postcodeInfo.getLongitude(), postcodeInfo.getLatitude(), postcodeInfo.getPostCode());
    }

    public PostCodeDto translateToPostCodeDto(PostcodeInfo postcodeInfo) {
        return new PostCodeDto(postcodeInfo.getId(), postcodeInfo.getPostCode(), postcodeInfo.getLatitude(), postcodeInfo.getLongitude());
    }

    public PostcodeInfo translateFromPostCodeDto(PostCodeDto input) {
        PostcodeInfo postcodeInfo = new PostcodeInfo();
        postcodeInfo.setId(input.getId());
        postcodeInfo.setPostCode(input.getPostCode());
        postcodeInfo.setLatitude(input.getLatitude());
        postcodeInfo.setLongitude(input.getLongitude());
        return postcodeInfo;
    }

}
