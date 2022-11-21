package at.htl.entitiy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDto {

    private String brand;
    private String type;

    //region Constructor
    public VehicleDto() {
    }

    public VehicleDto(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }
    //endregion

    //region Getter and Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //endregion

    //region to String
    @Override
    public String toString() {
        return String.format("%s %s", brand, type);
    }
    //endregion


}
