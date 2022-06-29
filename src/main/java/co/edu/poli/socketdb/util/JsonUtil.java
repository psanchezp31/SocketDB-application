package co.edu.poli.socketdb.util;

import co.edu.poli.socketdb.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class interact with the Jackson library to transform String to Object and vice versa.
 * Uses Singleton pattern because uses just one instance of the JsonUtil, to use this instance in other parts
 * of the code.
 *
 * @autor Paula Sanchez
 * @autor Diana Neira
 * @autor Ramon Barrios
 * @autor Andres Triana
 */

public class JsonUtil {

    private static final JsonUtil INSTANCE = new JsonUtil();
    private final ObjectMapper mapper;

    private JsonUtil() {
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Implementation of Singleton pattern, it returns an instance of this class itself.
     *
     * @return JsonUtil
     */
    public static JsonUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Transform Object to String, to show the server feedback to the user
     *
     * @param input
     * @return String
     */
    public String mapToString(Object input) {
        try {
            return mapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Transform String to Object, to get the attributes from the input user and apply the corresponding action.
     *
     * @param input
     * @return EmployeeDto
     */
    public EmployeeDto mapToDto(String input) {
        try {
            return mapper.readValue(input, EmployeeDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
