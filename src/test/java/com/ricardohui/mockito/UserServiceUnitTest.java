package com.ricardohui.mockito;


import static org.assertj.core.api.Assertions.*; // assertion library
import static org.mockito.Mockito.when; // mock
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest()
public class UserServiceUnitTest {
    @Autowired
    private UserService systemUnderTest;

    @MockBean
    private NameService nameService;

    @Captor
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);


    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect(){
        when(nameService.getUserName("SomeId")).thenReturn("Mock user name");
        String testName = systemUnderTest.getUserName("SomeId");
        assertThat(testName).isEqualTo("Mock user name");

    }

    @Test
    public void whenUserIdIsProvided_verifyItAlwaysReturnLowercaseId(){
        systemUnderTest.getUserName("SomeId");
        Mockito.verify(nameService).getUserName(captor.capture());
        String actual = captor.getValue();
        assertThat(actual).isEqualTo("SomeId");
    }




}
