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
                <img src="../bystro_i_tochka_maven/src/main/webapp/images/logo.png" alt="Логотип" class="logo-image">Быстро и Точка</a>
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
            <a href="basket.jsp" class="cart-icon ms-auto" style="text-decoration: none; margin-right: 10px;">
                <i class="bi bi-cart"></i>
                <span id="cart-counter">0</span>
              </a>
            <a class="nav-link ms-auto" href="account.jsp">
                <i class="fas fa-user"></i> Мой аккаунт
            </a>
          </div>
        </nav>
      </header>

  <main>
    <section class="basket-section">
      <div class="container">
        <div class="back-btn">
          <a href="order.jsp" class="btn back-btn">
            <i class="bi bi-arrow-left">Вернуться в меню ресторана</i> 
          </a>
        </div>
        <h2>Ваш заказ</h2>
        <div class="basket-items">
          <div class="basket-item">
            <div class="menu-item-details">
              <img src="../bystro_i_tochka_maven/src/main/webapp/images/pizza.jpg" alt="Пицца Маргарита" class="basket-item-image" style="margin-right: 10px;">
              <h3>Пицца Маргарита</h3>
              <p>Состав: томатный соус, моцарелла, базилик</p>
            </div>
          </div>
          <div class="basket-item">
            <div class="menu-item-details">
              <img src="../bystro_i_tochka_maven/src/main/webapp/images/pizza.jpg" alt="Пицца Маргарита" class="basket-item-image" style="margin-right: 10px;">
              <h3>Пицца Маргарита</h3>
              <p>Состав: томатный соус, моцарелла, базилик</p>
            </div>
          </div>
          <div class="basket-item">
            <div class="menu-item-details">
              <img src="../bystro_i_tochka_maven/src/main/webapp/images/pizza.jpg" alt="Пицца Маргарита" class="basket-item-image" style="margin-right: 10px;">
              <h3>Пицца Маргарита</h3>
              <p>Состав: томатный соус, моцарелла, базилик</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <div class="container">
        <section class="basket-order-section">
        <h3 style = "margin-bottom: 20px;">Общая стоимость заказа: 30$</h3>
        <button class="glow-button">Заказать</button>
        <div class="promo-code-form">
          <form action="/applyPromoCode" style="margin-top: 50px;" method="post">
            <input type="text" name="promoCode" placeholder="Введите промокод" />
            <button type="submit" class = "btn-secondary">Применить</button>
          </form>
        </div>
        </section>
    </div>
    
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
