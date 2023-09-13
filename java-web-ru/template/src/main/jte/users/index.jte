<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

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
            !{var users = page.getUsers();}
            @if(users == null || users.isEmpty())
                <p>Users not found</p>
            @else
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">User</th>
                        </tr>
                    </thead>
                    <tbody>
                    @for(int i = 0; i < users.size(); i++)
                        !{var user = users.get(i);}
                        <tr>
                            <th scope="row">${i}</th>
                            <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                        </tr>
                    @endfor
                    </tbody>
                </table>
            @endif
            </main>
        </div>
    </body>
</html>
<!-- END -->
