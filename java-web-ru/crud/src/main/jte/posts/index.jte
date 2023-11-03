@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage

@param PostsPage page
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                @if(page.getPageNum() > 1)
                    <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPageNum() - 1}">Назад</a></li>
                @else
                    <li class="page-item disabled"><a class="page-link" href="#">Назад</a></li>
                @endif
                @if(page.getPageNum() < page.getMaxPageNum())
                    <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPageNum() + 1}">Вперед</a></li>
                @else
                    <li class="page-item disabled"><a class="page-link" href="#">Вперед</a></li>
                @endif
            </ul>
        </nav>
        <main>
            <h1>Посты на странице ${page.getPageNum()}</h1>
            <ul class="list-group">
                @for(int i = 0; i < page.getPosts().size(); i++)
                    <li class="list-group-item"><a href="${NamedRoutes.postPath(page.getPosts().get(i).getId())}">${page.getPosts().get(i).getName()}</a></li>
                @endfor
            </ul>
        </main>
    </div>
`
)
<!-- END -->
