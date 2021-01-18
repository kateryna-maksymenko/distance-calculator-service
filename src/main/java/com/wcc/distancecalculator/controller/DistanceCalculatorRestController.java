package com.wcc.distancecalculator.controller;

import com.wcc.distancecalculator.api.DistanceCalculatorApi;
import com.wcc.distancecalculator.dto.DistanceCalculationResult;
import com.wcc.distancecalculator.dto.PostCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/locations")
@Validated
public class DistanceCalculatorRestController {

    private static final String VALIDATION_REGEX = "[A-Z]{1,2}[0-9R][0-9A-Z]?\\s[0-9][ABD-HJLNP-UW-Z]{2}";
    @Autowired
    private DistanceCalculatorApi api;

    @GetMapping("/distance/{zipCode1}/{zipCode2}")
    public DistanceCalculationResult getDistance(@Valid @Pattern(regexp = VALIDATION_REGEX)
                                                 @PathVariable(name = "zipCode1") String zipCode1, @Valid @Pattern(regexp = VALIDATION_REGEX) @PathVariable(name = "zipCode2") String zipCode2) {
        return api.calculateDistanceBetweenTwoLocations(zipCode1, zipCode2);
    }

    @GetMapping("/{postCode}")
    public PostCodeDto getPostCode(@Valid @Pattern(regexp = VALIDATION_REGEX) @PathVariable String postCode) {
        return api.getPostCodeByCode(postCode);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updatePostCodeInfo(@RequestBody PostCodeDto postCodeDto, @PathVariable String id) {
        postCodeDto.setId(Long.valueOf(id));
        api.updatePostCodeInfo(postCodeDto);
        return ResponseEntity.ok("resource updated");
    }

}
