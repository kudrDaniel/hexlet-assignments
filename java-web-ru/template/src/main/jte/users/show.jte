<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Users list</title>
    </head>
    <body>
        <div class="mx-auto p-4">
            <main>
                <h1>User information</h1>
                !{var user = page.getUser();}
                <h2>${user.getFirstName()} ${user.getLastName()}</h2>
                !{var email = user.getEmail();}
                <p>Email: <a href="mailto:${email}"></a>${email}</p>
            </main>
        </div>
    </body>
</html>
<!-- END -->
