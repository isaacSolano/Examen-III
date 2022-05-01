package com.kidslibrary.kidslibrary.Service;

import com.kidslibrary.kidslibrary.Domain.Child;
import com.kidslibrary.kidslibrary.Repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildService {
    @Autowired
    private ChildRepository childRepository;

    public void save(Child child) { childRepository.saveAndFlush(child); }
    public Optional<Child> findById(Long id) { return childRepository.findById(id); }

}
