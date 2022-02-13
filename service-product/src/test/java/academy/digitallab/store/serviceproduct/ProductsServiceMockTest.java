package academy.digitallab.store.serviceproduct;

import academy.digitallab.store.serviceproduct.entity.Category;
import academy.digitallab.store.serviceproduct.entity.Product;
import academy.digitallab.store.serviceproduct.repository.ProductRepository;
import academy.digitallab.store.serviceproduct.service.ProductService;
import academy.digitallab.store.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductsServiceMockTest {

    @Mock
    private ProductRepository repo;

    private ProductService service;

    @BeforeEach
    public  void  setup(){
        MockitoAnnotations.openMocks(this);
        service = new ProductServiceImpl(repo);
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        //crear mock
        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(repo.save(computer))
                .thenReturn(computer);
    }

    //valdiar la busqueda
    @Test
    public void whenValidedGetID_ThenReturnProduct(){
        Product found = service.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = service.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
