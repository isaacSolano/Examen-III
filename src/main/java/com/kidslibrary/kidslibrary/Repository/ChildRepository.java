package com.kidslibrary.kidslibrary.Repository;

import com.kidslibrary.kidslibrary.Domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChildRepository extends JpaRepository<Child, Long> {
}
