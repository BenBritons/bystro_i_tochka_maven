<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Меню заказа</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container">
            <a class="navbar-brand" href="index.html">
                <img src="images/logo.png" alt="Логотип" class="logo-image">Быстро и Точка</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Главная</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="index.html#contacts">О нас</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="index.html#about">Контакты</a>
                </li>
              </ul>
            </div>
            <a href="basket.html" class="cart-icon ms-auto" style="text-decoration: none; margin-right: 10px;">
                <i class="bi bi-cart"></i>
                <span id="cart-counter">0</span>
              </a>
            <a class="nav-link ms-auto" href="account.html">
                <i class="fas fa-user"></i> Мой аккаунт
            </a>
          </div>
        </nav>
      </header>

  <main>
    <div class="container">
        <h1 class="account-h1" >Мой аккаунт</h1>
        <div id="userInfo">
            <h2>Информация о пользователе</h2>
            <p id="userName"></p>
            <p id="userLogin"></p>
            <p id="password"></p>
          </div>
    </div>

    <div class="account-details">
        <!-- Остальные элементы аккаунта -->
        <div class="add-restaurant-button">
          <button id="add-restaurant-btn">Добавить ресторан</button>
        </div>
      </div>

      <%

boolean isAdmin = ...; 

String accountDetailsClass = isAdmin ? "account-details admin" : "account-details";
%>

<script>
    var isAdmin = document.querySelector(".account-details").classList.contains("admin");
  
    var addRestaurantBtn = document.getElementById("add-restaurant-btn");

    if (isAdmin) {
      addRestaurantBtn.style.display = "block";
    } else {
      addRestaurantBtn.style.display = "none";
    }
  </script>
  </main>

  <footer class="bg-light text-center p-3 mt-4">
    &copy; 2023 Быстро и Точка. Все права защищены.
  </footer>

  <!-- Подключение скриптов Bootstrap -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.5.0/bootstrap-icons.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
