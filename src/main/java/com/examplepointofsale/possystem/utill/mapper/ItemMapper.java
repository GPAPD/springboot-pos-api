package com.examplepointofsale.possystem.utill.mapper;

import com.examplepointofsale.possystem.dto.response.ItemGetDTO;
import com.examplepointofsale.possystem.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemGetDTO>entityListToDtoList(List<Item>items);

    List<ItemGetDTO>listDTOToPage(Page<Item> items);
}
