<!DOCTYPE html>
<html>
<head>
  <title>Добавить еду</title>
  <!-- Подключите необходимые стили и скрипты -->
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
</head>
<body>
    <div class="container">
        <div class="back-btn">
            <a href="myaccount.html" class="btn back-btn">
              <i class="bi bi-arrow-left">Вернуться на страницу аккаунта</i> 
            </a>
          </div>
  <!-- Добавьте header и footer, если они используются в вашем проекте -->
  
  <div class="container">
    <h1>Добавить еду</h1>
    <form action="/addFood" method="post" enctype="multipart/form-data">
      <div>
        <label for="foodName">Название еды:</label>
        <input type="text" id="foodName" name="foodName" required>
      </div>
      <div>
        <label for="foodPhoto">Фотография еды:</label>
        <input type="file" id="foodPhoto" name="foodPhoto" accept="image/*" required>
      </div>
      <div>
        <label for="restaurant">Ресторан:</label>
        <select id="restaurant" name="restaurant" required>
          <!-- Здесь можно добавить код для динамической генерации списка ресторанов из базы данных -->
          <option value="restaurant1">Ресторан 1</option>
          <option value="restaurant2">Ресторан 2</option>
          <option value="restaurant3">Ресторан 3</option>
        </select>
      </div>
      <button type="submit">Добавить</button>
    </form>
  </div>
</body>
</html>
