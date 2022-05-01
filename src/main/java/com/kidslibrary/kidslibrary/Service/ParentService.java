package com.kidslibrary.kidslibrary.Service;

import com.kidslibrary.kidslibrary.Domain.Parent;
import com.kidslibrary.kidslibrary.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    @Autowired
    private ParentRepository parentRepository;

    public void save(Parent parent) { parentRepository.saveAndFlush(parent); }
    public List<Parent> search(String keywords) {
        return parentRepository.findByNameContainingIgnoreCase(keywords);
    }
    public Optional<Parent> findById(Long id) {
        return parentRepository.findById(id);
    }
    public List<Parent> getAll() { return parentRepository.findAll(); }
}
