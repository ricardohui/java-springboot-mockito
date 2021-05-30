package com.ricardohui.mockito;


import static org.assertj.core.api.Assertions.*; // assertion library
import static org.mockito.Mockito.when; // mock
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest()
public class UserServiceUnitTest {
    @Autowired
    private UserService userService;

    @MockBean
    private NameService nameService;



    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect(){
        when(nameService.getUserName("SomeId")).thenReturn("Mock user name");
        String testName = userService.getUserName("SomeId");
        assertThat(testName).isEqualTo("Mock user name");
    }
}
