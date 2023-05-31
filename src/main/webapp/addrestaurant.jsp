<!DOCTYPE html>
<html>
<head>
  <title>Добавить ресторан</title>
  <!-- Подключите необходимые стили и скрипты -->
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <!-- Добавьте header и footer, если они используются в вашем проекте -->
  
  <div class="container">
    <div class="back-btn">
        <a href="myaccount.html" class="btn back-btn">
          <i class="bi bi-arrow-left">Вернуться к выбору ресторана</i> 
        </a>
      </div>
    <h1>Добавить ресторан</h1>
    <form action="/addRestaurant" method="post" enctype="multipart/form-data">
      <div>
        <label for="restaurantName">Название ресторана:</label>
        <input type="text" id="restaurantName" name="restaurantName" required>
      </div>
      <div>
        <label for="restaurantPhoto">Фотография ресторана:</label>
        <input type="file" id="restaurantPhoto" name="restaurantPhoto" accept="image/*" required>
      </div>
      <button type="submit">Добавить</button>
    </form>
  </div>
</body>
</html>