<%@ page import="by.fpmibsu.bystro_i_tochka.entity.User" %>
<%@ page import="by.fpmibsu.bystro_i_tochka.entity.Order" %>
<html lang="ru">
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
            <a class="navbar-brand" href="/bystro_i_tochka_maven_war">
                <img src="images/logo.png" alt="Логотип" class="logo-image">Быстро и Точка</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/bystro_i_tochka_maven_war">Главная</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/bystro_i_tochka_maven_war#contacts">О нас</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/bystro_i_tochka_maven_war#about">Контакты</a>
                </li>
              </ul>
            </div>
              <%
                  if(request.getSession().getAttribute("logined")!= null){
                         Order order = (Order) request.getSession().getAttribute("order");
              %>
            <a href="basket.jsp" class="cart-icon ms-auto" style="text-decoration: none; margin-right: 10px;">
                <i class="bi bi-cart"></i>
                <span id="cart-counter"><%=order.getOrder().size()%></span>
              </a>
              <%}else{%>
              <a href="basket.jsp" class="cart-icon ms-auto" style="text-decoration: none; margin-right: 10px;">
                  <i class="bi bi-cart"></i>
                  <span id="cart-counter_default">0</span>
              </a>
              <%}%>
              <%
                  if(request.getSession().getAttribute("logined")!= null){
                      if((boolean)request.getSession().getAttribute("logined")){
              %>
              <a class="nav-link ms-auto" href="account.jsp">
                  <i class="fas fa-user"></i><%User us =(User) request.getSession().getAttribute("user");%>
                      <%=us.getName()%>
              </a>
              <%} else{%>{
              <a class="nav-link ms-auto" href="account.jsp">
                  <i class="fas fa-user"></i> Мой аккаунт
              </a>
              }<%} }else{ %>
              <a class="nav-link ms-auto" href="account.jsp">
                  <i class="fas fa-user"></i> Мой аккаунт
              </a>
              <%}%>
          </div>
        </nav>
      </header>

  <main>
    <div class="container" style="display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;">
        <h1 class="account-h1" >Мой аккаунт</h1>
        <div id="userInfo">
            <h2>Информация о пользователе</h2>
            <p id="userName">Имя пользователя: <%=request.getAttribute("name")%></p>
            <p id="userLogin">Ваш логин: <%=request.getAttribute("login")%></p>
            <p id="password">Ваш пароль: <%=request.getAttribute("password")%></p>
            <p id="address">Ваш адрес: <%=request.getAttribute("address")%></p>
          </div>
        <button style="margin-top: 250px" class="btn btn-danger">Выйти из аккаунта</button>
    </div>

    <div class="account-details">
        <!-- Остальные элементы аккаунта -->
        <div class="add-restaurant-button">
          <button id="add-restaurant-btn">Добавить ресторан</button>
        </div>
        <div class="add-food-button">
          <button id="add-food-btn">Добавить ресторан</button>
        </div>
      </div>

      <%

boolean isAdmin = false;

String accountDetailsClass = isAdmin ? "account-details admin" : "account-details";
%>

<script>
    var isAdmin = document.querySelector(".account-details").classList.contains("admin");
  
    var addRestaurantBtn = document.getElementById("add-restaurant-btn");
    var addFoodBtn = document.getElementById("add-food-btn");

    if (isAdmin) {
      addRestaurantBtn.style.display = "block";
      addFoodBtn.style.display = "block";
    } else {
      addRestaurantBtn.style.display = "none";
      addFoodBtn.style.display = "none";
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
