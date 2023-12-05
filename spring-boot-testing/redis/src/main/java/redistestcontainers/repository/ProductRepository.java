package redistestcontainers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import redistestcontainers.hash.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
