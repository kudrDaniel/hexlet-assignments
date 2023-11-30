<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    !{var users = page.getUsers();}
    @if(users == null || users.isEmpty())
        <p>Users not found</p>
    @else
        <table class="table-info">
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
`
)
<!-- END -->
