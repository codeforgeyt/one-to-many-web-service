package com.codeforgeyt.onetomanywebservice.repository;

import com.codeforgeyt.onetomanywebservice.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
