
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Мой аккаунт</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
  <link rel="stylesheet" href="styles/style.css">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container">
              <a type="submit" class="navbar-brand" href="/bystro_i_tochka_maven_war">
                <img src="images/logo.png" alt="Логотип" class="logo-image"> Быстро и Точка
              </a>
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
        <div class="container">
            <h1 class="account-h1" >Мой аккаунт</h1>
          <%
            if(request.getSession().getAttribute("logined")!= null){
              if((boolean)request.getSession().getAttribute("logined")){
          %>
            <!-- Форма входа -->
            <form id="loginForm" class="registration-form" action="account" method="post">
              <h2>Вы уже авторизированы)</h2>
            </form>
          <%}else{%>
            <!-- Форма регистрации (изначально скрыта) -->
            <div id="registrationFormContainer" class = "registration-form" style="display: none;">
              <h2>Регистрация</h2>
              <form id="registrationForm" action="/register" method="post">
                <label for="registerName">Имя:</label>
                <input type="text" id="registerName" name="name" placeholder="Имя" required>
                <br>
                <label for="registerUsername">Логин:</label>
                <input type="text" id="registerUsername" name="username" placeholder="Логин" required>
                <br>
                <label for="registerPassword">Пароль:</label>
                <input type="password" id="registerPassword" name="password" placeholder="Пароль" required>
                <br>
                <button type="submit" class="btn btn-primary" style = "margin-top: 10px;">Зарегистрироваться</button>
                <br>
                <button type="button" class="change-button" id="toggleLoginBtn">У меня уже есть аккаунт. Войти</button>
              </form>
            </div>
          <%}}else{%>
          <form id="loginForm" class="registration-form" action="account" method="post">
            <h2>Вход</h2>
            <label for="loginUsername">Логин:</label>
            <input type="text" id="loginUsername" name="username" placeholder="Логин" required>
            <br>
            <label for="loginPassword">Пароль:</label>
            <input type="password" id="loginPassword" name="password" placeholder="Пароль" required>
            <br>
            <button type="submit" class="btn btn-primary" style = "margin-top: 10px;">Войти</button>
            <br>
            <button type="button" id="toggleRegisterBtn" class="change-button">У меня нету аккаунта. Зарегистрироваться</button>
          </form>
          <%}%>
        
            <!-- Блок с информацией о пользователе (изначально скрыт) -->
            <div id="userInfo" style="display: none;">
              <h2>Информация о пользователе</h2>
              <p id="userName"></p>
              <p id="userLogin"></p>
            </div>
          </div>
      </main>
  

  <footer class="bg-light text-center p-3 mt-4">
    &copy; 2023 Быстро и Точка. Все права защищены.
  </footer>

  <!-- Подключение JavaScript-файла -->
  <script src="scripts/script.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.5.0/bootstrap-icons.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>  
</body>
</html>
