<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    !{var users = page.getUsers();}
    @if(users == null || users.isEmpty())
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Apply" />
        </form>
    @else
        <table class="table-info">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">User</th>
            </tr>
            </thead>
            <tbody>
            <form action="/users" method="get">
                <input type="search" name="term" value="${page.getTerm()}" />
                <input type="submit" value="Apply" />
            </form>
            @for(int i = 0; i < users.size(); i++)
                !{var user = users.get(i);}
                <tr>
                    <th scope="row">${i}</th>
                    <td>${user.getFirstName()} ${user.getLastName()} ${user.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
`
)
<!-- END -->
