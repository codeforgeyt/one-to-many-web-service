package com.codeforgeyt.onetomanywebservice.controller;

import com.codeforgeyt.onetomanywebservice.model.Cart;
import com.codeforgeyt.onetomanywebservice.model.dto.CartDto;
import com.codeforgeyt.onetomanywebservice.model.dto.ItemDto;
import com.codeforgeyt.onetomanywebservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

   @RequestMapping(value = "/postcarts", method = RequestMethod.POST, produces = "application/json") 
    public ResponseEntity<CartDto> addCart(@RequestBody final CartDto cartDto){
        Cart cart = cartService.addCart(Cart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

   @RequestMapping(value = "/getcarts", method = RequestMethod.GET, produces = "application/json") 
    public ResponseEntity<List<CartDto>> getCarts(){
        List<Cart> carts = cartService.getCarts();
        List<CartDto> cartsDto = carts.stream().map(CartDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartsDto, HttpStatus.OK);
    }

   @RequestMapping(value = "/getcarts/{id}", method = RequestMethod.GET, produces = "application/json") 
    public ResponseEntity<CartDto> getCart(@PathVariable final Long id){
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

   @RequestMapping(value = "/Deletecarts/{id}", method = RequestMethod.DELETE, produces = "application/json") 
    public ResponseEntity<CartDto> deleteCart(@PathVariable final Long id){
        Cart cart = cartService.deleteCart(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

   @RequestMapping(value = "/updatecarts/{id}", method = RequestMethod.PUT, produces = "application/json") 
    public ResponseEntity<CartDto> editCart(@PathVariable final Long id,
                                            @RequestBody final CartDto cartDto){
        Cart cart = cartService.editCart(id, Cart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

     @RequestMapping(value = "{cartId}/items/{itemId}/add", method = RequestMethod.POST, produces = "application/json") 
    public ResponseEntity<CartDto> addItemToCart(@PathVariable final Long cartId,
                                                 @PathVariable final Long itemId){
        Cart cart = cartService.addItemToCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @RequestMapping(value = "{cartId}/items/{itemId}/remove", method = RequestMethod.DELETE, produces = "application/json") 
    public ResponseEntity<CartDto> removeItemFromCart(@PathVariable final Long cartId,
                                                 @PathVariable final Long itemId){
        Cart cart = cartService.removeItemFromCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }
}
