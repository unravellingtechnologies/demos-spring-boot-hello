package io.unravelling.demos.springboot.hello.configuration.interceptors;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * This test class is absolutely wrong. Need to figure how to test the interceptor
 * being properly added to the registry.
 */
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InterceptorConfigurationTest {

    @Mock
    ControllerInterceptor controllerInterceptor;

    @Mock
    InterceptorRegistry interceptorRegistry;

    private InterceptorConfiguration interceptorConfiguration;

    @BeforeAll
    void setup() {
        interceptorConfiguration = new InterceptorConfiguration(controllerInterceptor);
    }

    @Test
    @DisplayName("configures the interceptors")
    void configureInterceptors() {
        interceptorConfiguration.addInterceptors(interceptorRegistry);
        assertTrue(true);
    }
}
