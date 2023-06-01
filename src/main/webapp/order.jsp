<%@ page import="by.fpmibsu.bystro_i_tochka.entity.Food" %>
<%@ page import="java.util.ArrayList" %>
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
            <a class="navbar-brand" href="">
                <img src="images/logo.png" alt="Логотип" class="logo-image">Быстро и Точка</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.jsp">Главная</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="index.jsp">О нас</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="index.jsp#about">Контакты</a>
                </li>
              </ul>
            </div>
            <a href="basket.jsp" class="cart-icon ms-auto" style="text-decoration: none; margin-right: 10px;">
                <i class="bi bi-cart"></i>
                <span id="cart-counter">0</span>
              </a>
            <%
              if(request.getSession().getAttribute("logined")!= null){
                if((boolean)request.getSession().getAttribute("logined")){
            %>
            <a class="nav-link ms-auto" href="account.jsp">
              <i class="fas fa-user"></i><%=request.getSession().getAttribute("username")%>
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
    <section class="menu-section">
      <div class="container">
        <div class="back-btn">
          <a href="index.jsp" class="btn back-btn">
            <i class="bi bi-arrow-left">Вернуться к выбору ресторана</i> 
          </a>
        </div>
        <h2>Меню</h2>
        <div class="menu-items">
          <%
            ArrayList<Food> restaurants = (ArrayList<Food>) request.getAttribute("rest_food_list");
            for(Food t : restaurants){%>
          <form class="menu-item" action="food" method="post">
            <img src="images/food<%=t.getId()%>.jpg" alt="Пицца Маргарита" class="menu-item-image">
            <div class="menu-item-details">
              <h3><%=t.getName()%></h3>
              <p>Состав: томатный соус, моцарелла, базилик</p>
              <p>Цена: $<%=t.getPrice()%></p>
              <button class="btn btn-primary add-to-cart" name="food_id" value="<%=t.getId()%>">Добавить в корзину</button>
              <div class="container"></div>
            </div>
          </form>
          <%}%>
          <!-- Добавьте другие блюда с аналогичной разметкой -->
        </div>
      </div>
    </section>
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
