package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Reviews;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

import java.util.ArrayList;
import java.util.List;

public interface BaseReviewsService {
    void createReview(User user, String comment, int mark, Food food) throws DaoException;
    void deleteReview(Reviews reviews) throws DaoException;
    void deleteReview(int reviewId) throws DaoException;
    public ArrayList<Reviews> findAllReviewsByFoodID(int id) throws DaoException;
}
