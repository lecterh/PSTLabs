package com.pstlabs.test.repository;

import com.pstlabs.test.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
