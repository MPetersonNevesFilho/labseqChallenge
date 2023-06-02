package main.java.altice.firstChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.arc.All;
import io.quarkus.jackson.ObjectMapperCustomizer;
import java.util.List;
import jakarta.inject.Singleton;

public class CustomObjectMapper {

    // Replaces the CDI producer for ObjectMapper built into Quarkus
    @Singleton
    @Produces
    ObjectMapper objectMapper(@All List<ObjectMapperCustomizer> customizers) {
        ObjectMapper mapper = myObjectMapper(); // Custom `ObjectMapper`

        // Apply all ObjectMapperCustomizer beans (incl. Quarkus)
        for (ObjectMapperCustomizer customizer : customizers) {
            customizer.customize(mapper);
        }

        return mapper;
    }
}