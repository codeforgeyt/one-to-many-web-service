package com.codeforgeyt.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class ItemIsAlreadyAssignedException extends RuntimeException{
    public ItemIsAlreadyAssignedException(final Long itemId, final Long cartId){
        super(MessageFormat.format("Item: {0} is already assigned to cart: {1}", itemId, cartId));
    }
}
