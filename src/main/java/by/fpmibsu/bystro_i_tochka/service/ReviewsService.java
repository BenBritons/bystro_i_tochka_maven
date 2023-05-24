package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.ReviewsDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Reviews;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;

public class ReviewsService implements BaseReviewsService{
    private ReviewsDAO dao;
    @Override
    public void createReview(User user, String comment, int mark, Food food) throws DaoException {
        dao.create(new Reviews(user, comment, mark, food));
    }

    @Override
    public void deleteReview(Reviews reviews) throws DaoException {
        dao.delete(reviews);
    }

    @Override
    public void deleteReview(int reviewId) throws DaoException {
        dao.delete(reviewId);
    }
}
