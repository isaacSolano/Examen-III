package com.kidslibrary.kidslibrary.Controller;

import com.kidslibrary.kidslibrary.Domain.Child;
import com.kidslibrary.kidslibrary.Domain.Parent;
import com.kidslibrary.kidslibrary.Service.ChildService;
import com.kidslibrary.kidslibrary.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/child")
public class ChildController {
    @Autowired
    ChildService childService;

    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity updateChild(@PathVariable Long id, @RequestBody Child child) {
        Optional<Child> foundResult = childService.findById(id);
        if (foundResult.isPresent()) {
            Child childToEdit = foundResult.get();
            childToEdit.setName(child.getName().equals("") ? childToEdit.getName() : child.getName());
            childToEdit.setReadingMember(child.isReadingMember());
            childToEdit.setDaycareMember(child.isDaycareMember());
            childToEdit.setAlergies(child.getAlergies() == null ? childToEdit.getAlergies() : child.getAlergies());
            childService.save(childToEdit);
            return ResponseEntity.status(HttpStatus.OK).body(childToEdit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent with id " + id + " not found.");
        }
    }
}
