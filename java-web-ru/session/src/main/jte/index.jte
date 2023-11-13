@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

<!-- BEGIN -->
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            @if(page.getName() != null)
                <h1>${page.getName().toString()}</h1>
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <input type="submit" class="btn btn-primary" value="Выйти" />
                </form>
            @else
                <h1>Войдите в систему</h1>
                <a class="btn btn-primary" href="${NamedRoutes.buildSessionPath()}">Войти</a>
            @endif
        </main>
    </div>
`
)
<!-- END -->
