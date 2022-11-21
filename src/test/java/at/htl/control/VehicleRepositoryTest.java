package at.htl.control;

import at.htl.entitiy.Vehicle;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {

    @Inject
    VehicleRepository vehicleRepository;

    //Holt sich aus dem Entity manager eine JDBC Data source,
    @Inject
    AgroalDataSource ds;

    @Transactional
    @Test
    void createSimpleVehicle() {
        Vehicle opel = new Vehicle("Opel", "Diplomat");
        vehicleRepository.persist(opel);

        //get table entity from the db
        Table table = new Table(ds, "vehicle");
        //output table to console
        output(table).toConsole();
        //check that the correct data is in the db
        assertThat(table).row(0)
                .column("brand").value().isEqualTo("Opel")
                .column("type").value().isEqualTo("Diplomat");
    }
}