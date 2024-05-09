<!doctype html>
<html lang="en">
  <head th:replace="/fragment/header :: head"></head>
  <body>
    
  <header>
    <nav th:replace="/fragment/navbar :: navbar"></nav>
  </header>

  <main>
    <br><br>
    <!-- carousel start -->
      <!-- <div th:replace="/fragment/carousel :: carousel"></div> -->
    <!-- carousel End -->

    <!-- Body of the Page -->
      <div class="container">
        <br><br>
        <a href="/todo/add" class="btn btn-primary mb-2">Add New Todo</a>
        <div th:if="${message}" th:text="${message}" th:class="${'alert '+alertClass}"></div>
        <div class="row">
          
          <div class="col-lg-4">
            <h2 class="display-1">Todo</h2>

            <div th:if="${!todos.empty}">
              <div class="table-responsive">
                <table class="table table-striped table-bordered mb-2">
                  <thead>
                    <tr>
                      <th>Id</th>
                      <th>Title</th>
                      <th>Detail</th>
                      <th>Delete</th>
                      <th>Edit</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr th:each="todo: ${todos}">
                      <td th:text="${todo.id}"></td>
                      <td th:text="${todo.title}"></td>
                      <td th:text="${todo.detail}"></td>
                      <td><a th:href="@{'/delete/'+${todo.id}}" class="confirmDelete">Delete</a></td>
                      <td><a th:href="@{'/edit/'+${todo.id}}">Edit</a></td>
                    </tr>
                  </tbody>
                </table>
              </div><!-- /.col-lg-4 -->
            </div>
            
            <div th:unless="${!todos.empty}">
              <h4 class="display-4">No Todo present</h4>
            </div>
        </div>

      </div>

      <!-- FOOTER -->
      <footer th:replace="/fragment/footer :: footer"></head>
  </main>
  <script th:src="@{/js/app.js}"></script>   
  </body>
</html>
