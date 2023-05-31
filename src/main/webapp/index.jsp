<%@ page import="by.fpmibsu.bystro_i_tochka.entity.Restaurants" %>
<%@ page import="java.util.ArrayList" %>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Быстро и Точка - Заказ еды онлайн</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="styles/style.css">
</head>

<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <a class="navbar-brand" href="#">
            <img src="images/logo.png" alt="Логотип" class="logo-image">Быстро и Точка</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#">Главная</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#contacts">О нас</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#about">Контакты</a>
            </li>
          </ul>
        </div>
        <a class="nav-link ms-auto" href="account.jsp">
            <i class="fas fa-user"></i> Мой аккаунт
        </a>
      </div>
    </nav>
  </header>

  <main>
    <section class="container mt-4">
      <h2 class="mb-4">Рестораны</h2>
      <for class="row">
      <%
        ArrayList<Restaurants> restaurants = (ArrayList<Restaurants>) request.getAttribute("restaurants");
        for(Restaurants t : restaurants){
      %>
        <form id="rest_form" class="col-md-4 mb-4"  action="food" method="post">
            <div class="card">
              <input type="hidden" name="rest_id" value="<%=t.getId()%>">
              <img src="images/restaurant<%=t.getId()%>.jpg" class="card-img-top" alt="Ресторан 1">
              <div class="card-body">
                <h5 class="card-title"><%=t.getName()%></h5>
                <button class="btn btn-primary">Заказать</button>
              </div>
            </div>
        </form>
        <%}%>
      </div>
    </section>
    <section id="contacts" class="container mt-4">
        <h2 class="mb-4">Контакты</h2>
        <p>Свяжитесь с нами для получения дополнительной информации или помощи:</p>
  <ul>
    <li>Телефон: +375-33-654-0079</li>
    <li>Email: bystroitochka@gmail.com</li>
    <li>Адрес: ул. Октябрьская, д. 10, офис 915, Минск, Беларусь</li>
  </ul>
      </section>
    
      <section id="about" class="container mt-4">
        <h2 class="mb-4">О нас</h2>
        <p>Мы - команда "Быстро и Точка". Наша цель - предоставить вам удобный и быстрый способ заказа еды онлайн с доставкой. Мы сотрудничаем с лучшими ресторанами, чтобы обеспечить вас широким выбором блюд.</p>
  <p>Наша команда старается обеспечить высокое качество обслуживания и удовлетворить ваши вкусовые предпочтения. Мы всегда готовы помочь вам с вопросами и предоставить поддержку.</p>
      </section>
  </main>

  <footer class="bg-light text-center p-3 mt-4">
    &copy; 2023 Быстро и Точка. Все права защищены.
  </footer>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
