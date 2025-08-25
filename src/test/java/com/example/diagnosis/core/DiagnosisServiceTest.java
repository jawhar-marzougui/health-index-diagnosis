package com.example.diagnosis.core;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class DiagnosisServiceTest {


private final DiagnosisService service = new DiagnosisService();


@ParameterizedTest
@DisplayName("Should return Cardiologie when index is multiple of 3 only")
@CsvSource({"3", "6", "9", "33"})
void cardiologieOnly(int idx) {
assertEquals("Cardiologie", service.diagnoseAsString(idx));
}


@ParameterizedTest
@DisplayName("Should return Traumatologie when index is multiple of 5 only")
@CsvSource({"5", "10", "20", "55"})
void traumatologieOnly(int idx) {
assertEquals("Traumatologie", service.diagnoseAsString(idx));
}


@ParameterizedTest
@DisplayName("Should return both when index is multiple of 3 and 5")
@CsvSource({"15", "30", "45", "60"})
void both(int idx) {
assertEquals("Cardiologie, Traumatologie", service.diagnoseAsString(idx));
}


@Test
@DisplayName("Should return RAS when no pathology detected")
void rasWhenNone() {
assertEquals("RAS", service.diagnoseAsString(1));
assertEquals("RAS", service.diagnoseAsString(2));
assertEquals("RAS", service.diagnoseAsString(7));
}


@Test
@DisplayName("Define behavior for 0 as both pathologies")
void zeroEdgeCase() {
assertEquals("Cardiologie, Traumatologie", service.diagnoseAsString(0));
}
}