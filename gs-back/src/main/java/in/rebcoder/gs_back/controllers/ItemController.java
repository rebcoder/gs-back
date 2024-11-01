package in.rebcoder.gs_back.controllers;

import in.rebcoder.gs_back.models.Home;
import in.rebcoder.gs_back.models.Item;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/home/{homeId}")
    public List<Item> getItemsByHome(@PathVariable Long homeId) {
        Home home = new Home(); // Fetch home by ID or however you implement home retrieval
        home.setId(homeId);
        return itemService.getItemsByHome(home);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/seller/{sellerId}")
    public List<Item> getItemsBySeller(@PathVariable Long sellerId) {
        User seller = new User();
        seller.setId(sellerId); // Retrieve user if necessary
        return itemService.getItemsBySeller(seller);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
