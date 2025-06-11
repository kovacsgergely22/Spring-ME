package org.me.bookstore.persist;

import org.me.bookstore.model.StorePlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorePlaceRepository extends JpaRepository<StorePlace, Long> {
}
