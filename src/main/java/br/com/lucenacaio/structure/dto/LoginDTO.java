package br.com.lucenacaio.structure.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
@JsonDeserialize(builder = ImmutableLoginDTO.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class LoginDTO {

    @Nullable
    @JsonProperty("username")
    public abstract String getUsername();

    @Nullable
    @JsonProperty(value = "password")
    public abstract String getPassword();

    @Nullable
    @JsonProperty(value = "token")
    public abstract String getToken();

}
