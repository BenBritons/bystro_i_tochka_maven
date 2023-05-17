package by.fpmibsu.bystro_i_tochka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {

    private int id;
    private String street;
    private int house;
    private int flatNumber;

    public Address() {
        this.street = "";
    }

}
