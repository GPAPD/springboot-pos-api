package com.examplepointofsale.possystem.dto.pagineted;

import com.examplepointofsale.possystem.dto.response.ItemGetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {

    List<ItemGetDTO> list;

    private long dataCount;

}
