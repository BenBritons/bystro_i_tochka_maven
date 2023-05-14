package by.fpmibsu.bystro_i_tochka.entity;

public class Address {
    private String street;
    private int house;
    private int flatNumber;

    public Address(String street, int house, int flatNumber) {
        this.street = street;
        this.house = house;
        this.flatNumber = flatNumber;
    }
    public Address() {
        this.street = "";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }
}
