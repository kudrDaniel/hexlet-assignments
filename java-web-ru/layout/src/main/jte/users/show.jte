<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <h1>User information</h1>
    !{var user = page.getUser();}
    <h2>${user.getFirstName()} ${user.getLastName()}</h2>
    !{var email = user.getEmail();}
    <p>Email: <a href="mailto:${email}"></a>${email}</p>
`
)
<!-- END -->
