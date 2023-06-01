import by.fpmibsu.bystro_i_tochka.DAO.UserDAO;
import by.fpmibsu.bystro_i_tochka.entity.User;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import org.junit.Assert;
import org.junit.Test;

public class UserDAOTest {

    @Test
    public void testFindEntityById() throws DaoException {
        // Создаем экземпляр UserDAO
        UserDAO userDAO = new UserDAO();

        // Устанавливаем ожидаемый ID пользователя
        int expectedUserId = 2004;

        // Вызываем метод findEntityById() для получения пользователя по ID
        User user = userDAO.findEntityById(expectedUserId);

        // Проверяем, что полученный пользователь не равен null и его ID соответствует ожидаемому значению
        Assert.assertNotNull(user);
        Assert.assertEquals(expectedUserId, user.getId());
    }
}
