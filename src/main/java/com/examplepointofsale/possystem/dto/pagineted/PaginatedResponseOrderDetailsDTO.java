package com.examplepointofsale.possystem.dto.pagineted;

import com.examplepointofsale.possystem.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDTO {

    List<ResponseOrderDetailsDTO> list;

    private long dataCount;
}
