package br.com.lucenacaio.structure.mapper;

import br.com.lucenacaio.structure.domain.Category;
import br.com.lucenacaio.structure.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toDTO(Category category);

    Category toEntity(CategoryDTO categoryDTO);

}
