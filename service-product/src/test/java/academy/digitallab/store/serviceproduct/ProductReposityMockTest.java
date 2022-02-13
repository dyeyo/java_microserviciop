package academy.digitallab.store.serviceproduct;

import academy.digitallab.store.serviceproduct.entity.Category;
import academy.digitallab.store.serviceproduct.entity.Product;
import academy.digitallab.store.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductReposityMockTest {

    @Autowired
    private ProductRepository repo;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
            Product product01 = Product.builder()
                    .name("computer")
                    .category(Category.builder().id(1L).build())
                    .description("")
                    .stock(Double.parseDouble("10"))
                    .price(Double.parseDouble("1240.99"))
                    .status("Created")
                    .createAt(new Date()).build();
            repo.save(product01);

            List<Product> founds= repo.findByCategory(product01.getCategory());

            Assertions.assertThat(founds.size()).isEqualTo(3);
    }

}
