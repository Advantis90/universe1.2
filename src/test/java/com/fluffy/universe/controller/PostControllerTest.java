package com.fluffy.universe.controller;
import com.fluffy.universe.controllers.PostController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

//This test verifies that when the indexPage method of the PostController class is called,it should redirect to the home page. It creates a mock Javalin application and Context object, initializes a PostController, and then calls the indexPage method on the PostController. Finally, it uses the verify method from Mockito to check if the context.redirect("/") method was called.
public class PostControllerTest {

    @Mock
    private Javalin app;

    @Mock
    private Context context;

    private PostController postController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        postController = new PostController(app);
    }
    @Test
    void indexPage_shouldRedirectToHomePage() {
        postController.indexPage(context);
        verify(context).redirect("/");
    }
}
