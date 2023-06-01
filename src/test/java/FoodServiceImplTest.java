import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.FoodServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImplTest {

    private FoodServiceImpl foodService;
    private FoodDAO foodDAO;

    @BeforeEach
    public void setup() {
        foodDAO = new FoodDAO();
        foodService = new FoodServiceImpl();
    }

    @Test
    public void testFindAll() throws DaoException {
        // Arrange
        List<Food> expectedFoodList = foodDAO.findAll();/*
        expectedFoodList.add(new Food(1,  10.99,"Pizza"));
        expectedFoodList.add(new Food(2, 7.99,"Burger"));*/

        // Set up the mock FoodDAO


        // Act
        List<Food> actualFoodList = foodService.findAll();

        // Assert
        Assertions.assertEquals(expectedFoodList, actualFoodList);
    }

    // Вспомогательный класс для имитации FoodDAO
}