package com.deafult.project.Trait;

import com.deafult.project.Enums.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class ResponseTrait {

    // todo Return current language/locale
    public String getCurrentLang() {
        return java.util.Locale.getDefault().toString(); // Adjust this method depending on how you manage locale
    }

    // todo Return error response for API
    public ResponseEntity<Map<String, Object>> returnError(String errNum, String msg) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("errNum", errNum);
        response.put("msg", msg);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // todo Return success messages
    public ResponseEntity<Map<String, Object>> returnSuccessMessage( String msg) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("errNum", "S000");
        response.put("msg", msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // todo Return success for account-related actions
    public ResponseEntity<Map<String, Object>> returnSuccessAccount(String msg, String email) {
        Map<String, Object> response = new HashMap<>();
        response.put("errNum", "S000");
        response.put("status", true);
        response.put("msg", msg);
        response.put("email", email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // todo Return any data with a key-value pair
    public ResponseEntity<Map<String, Object>> returnData(String key, Object value) {
        Map<String, Object> response = new HashMap<>();
        response.put("errNum", "S000");
        response.put("status", true);
        response.put("msg", "");
        response.put(key, value);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // todo Return the authenticated user's profile (example with Spring Security)
    public Object profiles() {
        return null;
    }

    // todo Return message based on role type
    public String typerole(Role role, String username) {
        String msg = "Change role type for this user: " + username + " to: ";
        switch (role) {
            case ADMIN -> msg += "Admin";
            case OWNER -> msg += "Owner";
            case CUSTOMER -> msg += "Customer";
        }
        return msg;
    }

    // todo Return validation error
    public ResponseEntity<Map<String, Object>> returnValidationError(String code, Errors errors) {
        return returnError(code, Objects.requireNonNull(errors.getFieldError()).getDefaultMessage());
    }

    // todo Return error code according to input
    public String returnCodeAccordingToInput(Errors errors) {
        String input = errors.getFieldErrors().get(0).getField();
        return getErrorCode(input);
    }

    // todo Return error code for a specific input
    public String getErrorCode(String input) {
        return switch (input) {
            case "name" -> "E0011";
            case "password" -> "E002";
            case "mobile" -> "E003";
            case "id_number" -> "E004";
            case "birth_date" -> "E005";
            // Add more cases as needed...
            default -> "";
        };
    }

}


