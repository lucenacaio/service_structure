package br.com.lucenacaio.structure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;
import org.springframework.lang.Nullable;

@Immutable
@JsonDeserialize(builder = ImmutableUserDTO.Builder.class)
public abstract class UserDTO {

    @Nullable
    @JsonProperty("username")
    public abstract String getUsername();

    @Nullable
    @JsonProperty(value = "password")
    public abstract String getPassword();

    @Nullable
    @JsonProperty("firstName")
    public abstract String getFirstName();

    @Nullable
    @JsonProperty("lastName")
    public abstract String getLastName();

}
