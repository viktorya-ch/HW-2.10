package service.Counter.model.basket;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skypro.counter.model.basket.ProductBasket;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.service.BasketService;
import org.skypro.counter.model.service.NoSuchProductException;
import org.skypro.counter.model.service.StorageService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BasketServiceTest {

    private ProductBasket productBasket;
    private StorageService storageService;
    private BasketService basketService;


    private UUID existingProductId;
    private UUID noExistingProductId;


    @BeforeEach

    void setUp() {
        MockitoAnnotations.openMocks(this);
        existingProductId = UUID.randomUUID();
        noExistingProductId = UUID.randomUUID();
        productBasket = mock(ProductBasket.class);
        storageService = mock(StorageService.class);
        basketService = new BasketService(productBasket, storageService);


    }

    @Test
    void testAddExistingProductClassAddProduct() {
        UUID productId = UUID.randomUUID();
        when(storageService.getProductId(productId)).thenReturn(true);
        basketService.addProductToBasket(productId);
        verify(productBasket).getProducts(productId);
    }

    @Test
    void testGetUserBasketReturnsBasketWhisProducts() {
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();

        when(productBasket.isEmpty()).thenReturn(false);
        when(productBasket.getProducts()).thenReturn(Map.of(productId1, 1, productId2, 1));
        Map<UUID, Integer> products = BasketService.getUserBasket().getProducts();
        assertEquals(2, products.size());
        assertTrue(products.containsKey(productId1));
        assertTrue(products.containsKey(productId2));

    }


    @Test
    public void
    testAddNoExistentProductThrowsException() {
        assertThrows(NoSuchProductException.class, () -> {
            basketService.addProductToBasket(noExistingProductId);
        });
    }

    @Test
    public void
    testAddExistingProductCallsAddProductOnMock() {
        basketService.addProductToBasket(existingProductId);
        verify(productBasket, times(1)).addProduct(existingProductId);
    }


    @Test
    public void

    testGetUserBasketReturnsEmptyIfBasketIsEmpty() {
        when(productBasket.getProducts()).thenReturn(new HashMap<>());
        assertTrue(basketService.getUserBasket().isEmpty());
    }


}




