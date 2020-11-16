package com.codeforgeyt.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(final Long id){
        super(MessageFormat.format("Could not find item with id: {0}", id));
    }
}
