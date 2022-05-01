package com.kidslibrary.kidslibrary.Controller;

import com.kidslibrary.kidslibrary.Domain.Child;
import com.kidslibrary.kidslibrary.Domain.Parent;
import com.kidslibrary.kidslibrary.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/parent")
public class ParentController {
    @Autowired
    ParentService parentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity postParent(@RequestBody Parent parent) {
        parentService.save(parent);
        return ResponseEntity.status(HttpStatus.OK).body(parent);
    }

    @PostMapping(value = "/child/{parent_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity postChild(@PathVariable Long parent_id, @RequestBody Child child) {
        Optional<Parent> foundResult = parentService.findById(parent_id);
        if (foundResult.isPresent()) {
            Parent parentToAssign = foundResult.get();

            parentToAssign.getChilds().add(child);

            parentService.save(parentToAssign);

            return ResponseEntity.status(HttpStatus.OK).body(child);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent with ID " + parent_id + " doesn't exists");
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity getAllParents() {
        List<Parent> result = parentService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity searchParent(
        @RequestParam("name") String keywords
    ) {
        List<Parent> result = parentService.search(keywords);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value="/{parent_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity getParentById(@PathVariable Long parent_id) {
        Optional<Parent> result = parentService.findById(parent_id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        Optional<Parent> foundResult = parentService.findById(id);
        if (foundResult.isPresent()) {
            Parent parentToEdit = foundResult.get();
            parentToEdit.setName(parent.getName().equals("") ? parentToEdit.getName() : parent.getName());
            parentToEdit.setAddress(parent.getAddress().equals("") ? parentToEdit.getAddress() : parent.getAddress());
            parentToEdit.setPrimaryPhone(parent.getPrimaryPhone() == null ? parentToEdit.getPrimaryPhone() : parent.getPrimaryPhone());
            parentToEdit.setSecondaryPhone(parent.getSecondaryPhone() == null ? parentToEdit.getSecondaryPhone() : parent.getSecondaryPhone());
            parentService.save(parentToEdit);
            return ResponseEntity.status(HttpStatus.OK).body(parentToEdit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent with id " + id + " not found.");
        }
    }
}
