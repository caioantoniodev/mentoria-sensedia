package edu.mentorship.contextbean.controller;

import edu.mentorship.contextbean.interfaces.ObjectType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ObjectController {

    private final ObjectType objectType;

    public ObjectController(ObjectType objectType) {
        this.objectType = objectType;
    }

    @GetMapping
    public String getType() {
        return objectType.getType();
    }
}
