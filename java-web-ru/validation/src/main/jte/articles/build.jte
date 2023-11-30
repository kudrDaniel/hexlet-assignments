@import exercise.dto.articles.NewArticlePage
@param NewArticlePage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Создание статьи</h1>
            @if(page.getErrors() != null)
                <ul>
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            @endif

            <form action="/articles" method="post">
                <div>
                    <label>
                        Название
                        <input type="text" required name="title" value="${page.getTitle()}" />
                    </label>
                </div>
                <div>
                    <label>
                        Содержимое
                        <textarea required name="content">${page.getContent()}</textarea>
                    </label>
                </div>
                <input type="submit" value="Создать" />
            </form>
        </main>
    </div>
`
)
<!-- END -->
