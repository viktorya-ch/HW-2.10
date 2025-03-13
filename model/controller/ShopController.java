package controller;
import service.StorageService;
import service.SearchService;


public class ShopController {
    private final StorageService storageService;
    private final SearchServise searchServise;

    @GetMapping("/products")
    public Collection<Product> getAllProducts(){
        return storageService.getProducts();
    }
    @GetMapping("/articles")
    public Collection<Article> getAllArticles(){
        return storageService.getArticle();
    }


@GetMapping("/search")
    public Collection<SearchResult>search (@RequestParam("pattern") String pattern){
        return searchServise.search(pattern);
}
}
