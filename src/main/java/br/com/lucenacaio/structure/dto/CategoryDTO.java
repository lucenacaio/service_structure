package br.com.lucenacaio.structure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;
import org.springframework.lang.Nullable;

@Immutable
@JsonDeserialize(builder = ImmutableCategoryDTO.Builder.class)
public abstract class CategoryDTO {

    @Nullable
    @JsonProperty(value = "id", access= JsonProperty.Access.READ_ONLY)
    public abstract Integer getId();

    @JsonProperty("name")
    public abstract String getName();
}
