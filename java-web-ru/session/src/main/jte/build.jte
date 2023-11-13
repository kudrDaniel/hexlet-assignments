@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

<!-- BEGIN -->
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        @if(page.getError() != null)
            <div class="mb-3">
                ${page.getError()}
            </div>
        @endif
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Имя
                    <input type="text" class="form-control" required name="name" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Пароль
                    <input type="password" class="form-control" required name="password" />
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Войти" />
        </form>
    </div>
`
)
<!-- END -->
