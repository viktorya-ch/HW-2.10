package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.counter.model.product.SimpleProduct;
import org.skypro.counter.model.search.SearchResult;
import org.skypro.counter.model.search.Searchable;
import org.skypro.counter.model.service.SearchService;
import org.skypro.counter.model.service.StorageService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ServiceTest {
    private StorageService storageService;
    private SearchService searchService;


    @BeforeEach
    public void setUp() {
        storageService=mock(StorageService.class);
        searchService=new SearchService(storageService);
    }


    @Test
    public void  testServiceWhenNOObjects(){
        when(storageService.getAllSearchable()).thenReturn(Collections.emptyList());


    Collection<SearchResult> results= searchService.search(" Тест ");

    assertTrue(" Результаты не должны быть пустыми ", results.isEmpty());}



    @Test
    public  void testServiceWhenNOMatchingObjects(){
       when(storageService.getAllSearchable()).thenReturn(Collections.singletonList(new SimpleProduct(UUID.randomUUID()," Нет подходящего ",UUID.randomUUID())));


   Collection<SearchResult> results=searchService.search(" Тест ");
        assertTrue(" Результаты не сожержат подходящих объектов ", results.isEmpty());}



    @Test
    public  void testServiceWhenMatchingObjects(){
        UUID id= UUID.randomUUID();
        Searchable matchingProduct = new SimpleProduct(id," Есть подходящий ", UUID.randomUUID());
        when(storageService.getAllSearchable()).thenReturn(Collections.singletonList(matchingProduct));

        Collection<SearchResult> results=searchService.search(" Подходит ");
        assertFalse(" Результаты сожержат подходящие объектоы ", results.isEmpty());



    }
}



