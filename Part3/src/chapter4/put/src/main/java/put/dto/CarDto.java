package put.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {

    private String name;

    @JsonProperty("car_number")
    private String carNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarName() {
        return carNumber;
    }

    public void setCarName(String carName) {
        this.carNumber = carName;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", carName='" + carNumber + '\'' +
                '}';
    }
}
