package no.nav.farskapsportal.backend.apps.api.model;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import no.nav.farskapsportal.backend.libs.dto.BarnDto;
import org.springframework.validation.annotation.Validated;

@Schema
@Value
@Builder
@Validated
public class OppretteFarskapserklaeringRequest {

  @Valid
  @NotNull
  @Parameter(description = "Barnet det skal erklæres farskap for")
  BarnDto barn;

  @Valid
  @NotNull
  @Parameter(description = "Opplysninger om far, er tom dersom far skal signere erklæring")
  KontrollerePersonopplysningerRequest opplysningerOmFar;

  @Valid
  @NotNull
  @Parameter(description = "Skriftspråket erklæringen skal være på")
  Skriftspraak skriftspraak;

}
