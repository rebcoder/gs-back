package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.models.Item;
import in.rebcoder.gs_back.models.Sale;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.repositories.ItemRepository;
import in.rebcoder.gs_back.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale addItemToSale(Long saleId, Long itemId) {
        Sale sale = saleRepository.findById(saleId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();

        sale.getItems().add(item);
        return saleRepository.save(sale);
    }

    public List<Sale> getSalesBySeller(User seller) {
        return saleRepository.findBySeller(seller);
    }
}
