package co.edu.poli.socketdb.util;

import co.edu.poli.socketdb.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final JsonUtil INSTANCE = new JsonUtil();
    private final ObjectMapper mapper;

    private JsonUtil() {
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonUtil getInstance() {
        return INSTANCE;
    }

    public String mapToString(Object input) {
        try {
            return mapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDto mapToDto(String input) {
        try {
            return mapper.readValue(input, EmployeeDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
