@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage

@param PostPage page
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">

        <main>
            <h1>${page.getPost().getName()}</h1>
            <div>${page.getPost().getBody()}</div>
        </main>
        <a href="${NamedRoutes.postsPath()}">Назад</a>
    </div>
`
)
<!-- END -->
