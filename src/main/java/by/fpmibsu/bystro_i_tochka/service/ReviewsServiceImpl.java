package by.fpmibsu.bystro_i_tochka.service;

import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.DAO.ReviewsDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Reviews;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ReviewsServiceImpl implements BaseReviewsService{
    private ReviewsDAO dao;
    static Logger logger = LogManager.getLogger(ReviewsServiceImpl.class.getName());

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

    @Override
    public ArrayList<Reviews> findAllReviewsByFoodID(int id) throws DaoException {
        ArrayList<Reviews> reviews = (ArrayList<Reviews>) new ReviewsDAO().findAll();
        ArrayList<Reviews> toReturn = new ArrayList<>();
        for (var tmp :
                reviews) {
            if(tmp.getFood().getId() == id){
                toReturn.add(tmp);
            }
        }
        logger.log(Level.INFO, "findAllReviewsByFoodID " + id);
        return toReturn;
    }


}
