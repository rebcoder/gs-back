package in.rebcoder.gs_back.controllers;

import in.rebcoder.gs_back.models.Item;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sell")
public class SellerController {
    @Autowired
    private ItemService itemService;
    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/add-item")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        itemService.createItem(item);
        return ResponseEntity.ok("Item added successfully");
    }
}
