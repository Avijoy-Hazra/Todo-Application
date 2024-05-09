<!doctype html>
<html lang="en">
  <head th:replace="/fragment/header :: head"></head>
  <body>
    
  <header>
    <nav th:replace="/fragment/navbar :: navbar"></nav>
  </header>

  <main>
    <!-- carousel start -->
    <br><br>
    <!-- carousel start -->
      <!-- <div th:replace="/fragment/carousel :: carousel"></div> -->
    <!-- carousel End -->

    <!-- Body of the Page -->
        <div class="container">
            <a href="/" class="btn btn-primary mb-2">Back to Todo</a>
              <div th:if="${message}" th:text="${message}" th:class="${'alert '+alertClass}"></div>
               <div class="row">
                <h2 class="display-1">Todo</h2>
                    <form th:action="@{/todo/add}" method="post" th:object="${todo}">
                        <div th:if="${#fields.hasErrors('*')}" class="alert alert-danger">There are errors</div>
                        <div class="form-group">
                            <label for="">Title</label>
                            <input type="text" class="form-control" th:field="*{title}" placeholder="Title">
                            <span class="error" th:if="${#fields.hasErrors('title')}" th:errors="*{title}"></span>
                        </div>
                        <br>
                        <div class="form-group">
                            <label for="">Detail</label>
                            <textarea rows="10" class="form-control" th:field="*{detail}" placeholder="Detail"></textarea>
                            <span class="error" th:if="${#fields.hasErrors('detail')}" th:errors="*{detail}"></span>
                        </div>
                        <button class="btn btn-danger mb-5">Add</button>
                    </form>
            </div>
        </div>

      <!-- FOOTER -->
      <footer th:replace="/fragment/footer :: footer"></head>
  </main>

  
  </body>
</html>
