package com.ricardohui.mockito;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

//
//@Configuration
public class NameServiceTestConfiguration {
    @Bean
    @Primary
    public NameService nameService(){
        return Mockito.mock(NameService.class);
    }
}
