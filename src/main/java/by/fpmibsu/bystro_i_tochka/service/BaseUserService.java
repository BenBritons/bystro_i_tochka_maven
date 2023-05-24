package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Order;

public interface BaseUserService {
    void createUser(String name, String login, String password);
    void login(String login, String password);
}
