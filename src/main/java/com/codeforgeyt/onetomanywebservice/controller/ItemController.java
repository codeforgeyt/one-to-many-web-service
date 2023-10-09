package com.codeforgeyt.onetomanywebservice.controller;

import com.codeforgeyt.onetomanywebservice.model.Item;
import com.codeforgeyt.onetomanywebservice.model.dto.ItemDto;
import com.codeforgeyt.onetomanywebservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/postitems", method = RequestMethod.POST, produces = "application/json") 
    public ResponseEntity<ItemDto> addItem(@RequestBody final ItemDto itemDto){
        Item item = itemService.addItem(Item.from(itemDto));
        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    @RequestMapping(value = "/getitems", method = RequestMethod.GET, produces = "application/json") 
    public ResponseEntity<List<ItemDto>> getItems(){
        List<Item> items = itemService.getItems();
        List<ItemDto> itemsDto = items.stream().map(ItemDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/getitems/{id}", method = RequestMethod.GET, produces = "application/json") 
    public ResponseEntity<ItemDto> getItem(@PathVariable final Long id){
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteitems/{id}", method = RequestMethod.DELETE, produces = "application/json") 
    public ResponseEntity<ItemDto> deleteItem(@PathVariable final Long id){
        Item item = itemService.deleteItem(id);
        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateitems/{id}", method = RequestMethod.PUT, produces = "application/json") 
    public ResponseEntity<ItemDto> editItem(@PathVariable final Long id,
                                            @RequestBody final ItemDto itemDto){
        Item editedItem = itemService.editItem(id, Item.from(itemDto));
        return new ResponseEntity<>(ItemDto.from(editedItem), HttpStatus.OK);
    }
}
