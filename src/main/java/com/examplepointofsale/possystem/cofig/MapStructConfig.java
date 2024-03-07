package com.examplepointofsale.possystem.cofig;

import com.examplepointofsale.possystem.utill.mapper.ItemMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapStructConfig {
    @Bean
    public ItemMapper itemMapper(){
        return Mappers.getMapper(ItemMapper.class);
    }
}
