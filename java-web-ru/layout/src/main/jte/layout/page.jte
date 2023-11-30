<!-- BEGIN -->
@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
    <title>Document</title>
</head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                crossorigin="anonymous">
        </script>
        <div class="container">
            <header class="d-flex justify-content-center py-3">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">Home</a></li>
                    <li class="nav-item"><a href="/users" class="nav-link">Users</a></li>
                </ul>
            </header>
        </div>
        <div class="container">
            <section class="mx-auto p-4 py-md-5">
                ${content}
            </section>
        </div>
        <div class="container">
            <footer class="py-3 my-4">
                <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                    <li class="nav-item"><a href="/" class="nav-link px-2 text-muted">Home</a></li>
                    <li class="nav-item"><a href="/users" class="nav-link px-2 text-muted">Users</a></li>
                </ul>
                <p class="text-center text-muted">© 2023 Kudritskiy Danil</p>
            </footer>
        </div>
    </body>
</html>
<!-- END -->
