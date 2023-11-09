package com.raininman.monito.petItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetItemRepository extends JpaRepository<PetItem, Long> {

    @Query("SELECT s FROM PetItem s WHERE s.title = ?1")
    Optional<PetItem> findPetItemByTitle(String title);
}
