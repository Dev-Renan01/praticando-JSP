<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Projeto JSP</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card shadow">
          <div class="card-body">
            <h1 class="text-center mb-4">Seja bem-vindo(a) ao meu projeto JSP</h1>

            <form action="ServletLogin" method="post">
              <input type="hidden" value="<%= request.getParameter("url") %>" name="url">

              <div class="mb-3">
                <label for="login" class="form-label">Login:</label>
                <input name="login" type="text" class="form-control" id="login" required>
              </div>

              <div class="mb-3">
                <label for="senha" class="form-label">Senha:</label>
                <input name="senha" type="password" class="form-control" id="senha" required>
              </div>

              <div class="d-grid">
                <button type="submit" class="btn btn-primary">Entrar</button>
              </div>
            </form>

            <c:if test="${msg}">
              <div class="alert alert-warning mt-3" role="alert">
                ${msg}
              </div>
            </c:if>

          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
