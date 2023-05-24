package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Promos;

public interface BasePromosService {
    void createPromos(Food food, int discount);
    void addPromosToFood(Promos promos, Food food);
    void removePromosToFood(Promos promos, Food food);
}
