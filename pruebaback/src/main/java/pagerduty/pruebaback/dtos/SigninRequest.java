package pagerduty.pruebaback.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SigninRequest {

    @Email(message = "Correo no valido")
    private String email;

    @NotBlank(message = "Contraseña debe ser ingresada")
    @Size(min = 6, message = "La contraseña debe tener minimo 6 caracteres")
    private String password;
}
