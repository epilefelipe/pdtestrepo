package pagerduty.pruebaback.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMApperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
