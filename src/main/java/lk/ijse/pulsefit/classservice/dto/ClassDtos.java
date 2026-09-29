package lk.ijse.pulsefit.classservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class ClassDtos {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClassRequest {

        @NotBlank(message = "className is required")
        private String className;

        private String description;

        @NotNull(message = "category is required (YOGA, CARDIO, STRENGTH, HIIT, PILATES, SPIN or ZUMBA)")
        private String category;

        @NotBlank(message = "trainerName is required")
        private String trainerName;

        @NotNull(message = "scheduleTime is required (ISO-8601, e.g. 2026-04-01T09:00:00)")
        private LocalDateTime scheduleTime;

        @NotNull
        @Positive(message = "durationMinutes must be positive")
        private Integer durationMinutes;

        @NotNull
        @Positive(message = "capacity must be positive")
        private Integer capacity;

        private String location;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClassResponse {
        private Long id;
        private String className;
        private String description;
        private String category;
        private String trainerName;
        private LocalDateTime scheduleTime;
        private Integer durationMinutes;
        private Integer capacity;
        private String location;
    }
}
