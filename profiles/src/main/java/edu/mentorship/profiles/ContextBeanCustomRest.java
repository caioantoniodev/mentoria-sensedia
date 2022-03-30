package edu.mentorship.profiles;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profiles")
public class ContextBeanCustomRest {

    @Autowired
    private final ContextBeanCustom contextBeanCustom;

    @GetMapping
    public ResponseEntity<Response> getContextBeanCustom() {
        return ResponseEntity.ok(contextBeanCustom.response());
    }
}
