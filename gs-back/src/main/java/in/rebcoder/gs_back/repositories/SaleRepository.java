package in.rebcoder.gs_back.repositories;

import in.rebcoder.gs_back.models.Sale;
import in.rebcoder.gs_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
     List<Sale> findBySeller(User seller);
}
