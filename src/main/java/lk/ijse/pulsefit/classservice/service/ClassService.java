package lk.ijse.pulsefit.classservice.service;

import lk.ijse.pulsefit.classservice.dto.ClassDtos.ClassRequest;
import lk.ijse.pulsefit.classservice.dto.ClassDtos.ClassResponse;

import java.util.List;

public interface ClassService {
    ClassResponse create(ClassRequest request);
    List<ClassResponse> findAll();
    ClassResponse findById(Long id);
    ClassResponse update(Long id, ClassRequest request);
    void delete(Long id);
}
