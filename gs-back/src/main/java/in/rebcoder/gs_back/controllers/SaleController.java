package in.rebcoder.gs_back.controllers;

import in.rebcoder.gs_back.models.Sale;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @PutMapping("/{saleId}/add-item/{itemId}")
    public Sale addItemToSale(@PathVariable Long saleId, @PathVariable Long itemId) {
        return saleService.addItemToSale(saleId, itemId);
    }

    @GetMapping("/seller/{sellerId}")
    public List<Sale> getSalesBySeller(@PathVariable Long sellerId) {
        User seller = new User();
        seller.setId(sellerId); // Fetch user from UserService if needed
        return saleService.getSalesBySeller(seller);
    }
}