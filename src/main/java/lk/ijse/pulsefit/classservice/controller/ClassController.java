package lk.ijse.pulsefit.classservice.controller;

import jakarta.validation.Valid;
import lk.ijse.pulsefit.classservice.dto.ClassDtos.ClassRequest;
import lk.ijse.pulsefit.classservice.dto.ClassDtos.ClassResponse;
import lk.ijse.pulsefit.classservice.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<ClassResponse> create(@Valid @RequestBody ClassRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classService.create(request));
    }

    @GetMapping
    public List<ClassResponse> findAll() {
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public ClassResponse findById(@PathVariable Long id) {
        return classService.findById(id);
    }

    @PutMapping("/{id}")
    public ClassResponse update(@PathVariable Long id, @Valid @RequestBody ClassRequest request) {
        return classService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
