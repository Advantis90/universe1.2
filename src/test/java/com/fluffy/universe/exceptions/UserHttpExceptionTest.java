package com.fluffy.universe.exceptions;

import io.javalin.http.HttpCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//In this test, we're checking that both constructors of the HttpException class are working as intended.
// We're using the assertEquals() method from JUnit to verify that the actual values match the expected values.
// In the first test, we're checking that the constructor with a message parameter correctly sets the HTTP status code and the message.
// In the second test, we're checking that the constructor without a message parameter correctly sets the HTTP status code and uses the default message for that status code.
public class UserHttpExceptionTest {

    @Test
    void testHttpExceptionWithMessage() {
        HttpCode code = HttpCode.UNAUTHORIZED;
        String message = "You are not authorized to perform this action.";
        HttpException exception = new HttpException(code, message);
        assertEquals(code, exception.getHttpCode());
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testHttpExceptionWithoutMessage() {
        HttpCode code = HttpCode.INTERNAL_SERVER_ERROR;
        HttpException exception = new HttpException(code);
        assertEquals(code, exception.getHttpCode());
        assertEquals(code.getMessage(), exception.getMessage());
    }
}