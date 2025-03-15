package model.service;

@Service
public class SearchService {
    private final SearchService searchService;

    @Autowired
    public SearchService(StorageService storageService) {
        this.searchService = storageService;
    }



}
