package com.codeforgeyt.onetomanywebservice.repository;

import com.codeforgeyt.onetomanywebservice.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
