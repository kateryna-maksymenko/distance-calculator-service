package com.wcc.distancecalculator.api;

import com.wcc.distancecalculator.dto.DistanceCalculationResult;
import com.wcc.distancecalculator.model.PostcodeInfo;
import com.wcc.distancecalculator.repository.PostcodeRepository;
import com.wcc.distancecalculator.translator.PostcodeInfoTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class DistanceCalculatorApiTest {

    @Spy
    private PostcodeInfoTranslator translator;
    @Mock
    private PostcodeRepository repository;

    @InjectMocks
    private DistanceCalculatorApi api = new DistanceCalculatorApiImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCalculateDistanceBetweenTwoLocations() {
        String zipCode1 = "BR5 4BS";
        String zipCode2 = "BR5 4BT";
        DistanceCalculationResult result;

        PostcodeInfo postcodeInfo1 = new PostcodeInfo();
        postcodeInfo1.setPostCode(zipCode1);
        postcodeInfo1.setLatitude(51.386956000);
        postcodeInfo1.setLongitude(0.1195510);
        when(repository.findByPostCode(ArgumentMatchers.matches(zipCode1))).thenReturn(postcodeInfo1);

        PostcodeInfo postcodeInfo2 = new PostcodeInfo();
        postcodeInfo2.setPostCode(zipCode2);
        postcodeInfo2.setLatitude(51.387483);
        postcodeInfo2.setLongitude(0.119632);
        when(repository.findByPostCode(ArgumentMatchers.matches(zipCode2))).thenReturn(postcodeInfo2);

        result = api.calculateDistanceBetweenTwoLocations(zipCode1, zipCode2);

        assertNotNull(result.getDistance());
        assertEquals(postcodeInfo1.getLatitude(), result.getStartPoint().getLatitude());
        assertEquals(postcodeInfo1.getLongitude(), result.getStartPoint().getLongitude());
        assertEquals(postcodeInfo1.getPostCode(), result.getStartPoint().getPostCode());
        assertEquals(postcodeInfo2.getLatitude(), result.getEndPoint().getLatitude());
        assertEquals(postcodeInfo2.getLongitude(), result.getEndPoint().getLongitude());
        assertEquals(postcodeInfo2.getPostCode(), result.getEndPoint().getPostCode());
    }
}
