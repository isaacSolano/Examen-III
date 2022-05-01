package com.kidslibrary.kidslibrary.Repository;

import com.kidslibrary.kidslibrary.Domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    public List<Parent> findByNameContainingIgnoreCase(String name);
}
