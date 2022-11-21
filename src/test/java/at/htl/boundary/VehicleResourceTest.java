package at.htl.boundary;

import at.htl.entitiy.dto.VehicleDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class VehicleResourceTest {

    @Test
    public void testHelloEndpoint() {

        List<VehicleDto> retrievedVehicle = given()
                .when().get("/vehicle")
                .then()
                    .statusCode(200)
                    .extract()
                    .jsonPath().getList(".", VehicleDto.class);

        assertThat(retrievedVehicle.get(0).getBrand()).isEqualTo("Opel");
        assertThat(retrievedVehicle.get(0).getType()).isEqualTo("Kadett");
    }

}