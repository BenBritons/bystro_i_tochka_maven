package by.fpmibsu.bystro_i_tochka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    @Override
    public String toString() {
        return "Улица " + street + '\'' +
                ", дом " + house +
                " квартира= " + flatNumber;
    }

    private int id;
    private String street;
    private int house;
    private int flatNumber;

    public Address() {
        this.street = "";
    }

}
