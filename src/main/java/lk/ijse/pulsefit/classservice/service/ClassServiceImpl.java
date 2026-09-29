package lk.ijse.pulsefit.classservice.service;

import lk.ijse.pulsefit.classservice.dto.ClassDtos.ClassRequest;
import lk.ijse.pulsefit.classservice.dto.ClassDtos.ClassResponse;
import lk.ijse.pulsefit.classservice.entity.ClassCategory;
import lk.ijse.pulsefit.classservice.entity.FitnessClass;
import lk.ijse.pulsefit.classservice.exception.ClassNotFoundException;
import lk.ijse.pulsefit.classservice.repository.ClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public ClassResponse create(ClassRequest request) {
        FitnessClass fitnessClass = FitnessClass.builder()
                .className(request.getClassName())
                .description(request.getDescription())
                .category(ClassCategory.valueOf(request.getCategory().toUpperCase()))
                .trainerName(request.getTrainerName())
                .scheduleTime(request.getScheduleTime())
                .durationMinutes(request.getDurationMinutes())
                .capacity(request.getCapacity())
                .location(request.getLocation())
                .build();
        return toResponse(classRepository.save(fitnessClass));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClassResponse> findAll() {
        return classRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClassResponse findById(Long id) {
        return toResponse(getOrThrow(id));
    }

    @Override
    public ClassResponse update(Long id, ClassRequest request) {
        FitnessClass fitnessClass = getOrThrow(id);
        fitnessClass.setClassName(request.getClassName());
        fitnessClass.setDescription(request.getDescription());
        fitnessClass.setCategory(ClassCategory.valueOf(request.getCategory().toUpperCase()));
        fitnessClass.setTrainerName(request.getTrainerName());
        fitnessClass.setScheduleTime(request.getScheduleTime());
        fitnessClass.setDurationMinutes(request.getDurationMinutes());
        fitnessClass.setCapacity(request.getCapacity());
        fitnessClass.setLocation(request.getLocation());
        return toResponse(classRepository.save(fitnessClass));
    }

    @Override
    public void delete(Long id) {
        if (!classRepository.existsById(id)) {
            throw new ClassNotFoundException(id);
        }
        classRepository.deleteById(id);
    }

    private FitnessClass getOrThrow(Long id) {
        return classRepository.findById(id).orElseThrow(() -> new ClassNotFoundException(id));
    }

    private ClassResponse toResponse(FitnessClass fitnessClass) {
        return new ClassResponse(
                fitnessClass.getId(),
                fitnessClass.getClassName(),
                fitnessClass.getDescription(),
                fitnessClass.getCategory().name(),
                fitnessClass.getTrainerName(),
                fitnessClass.getScheduleTime(),
                fitnessClass.getDurationMinutes(),
                fitnessClass.getCapacity(),
                fitnessClass.getLocation()
        );
    }
}
