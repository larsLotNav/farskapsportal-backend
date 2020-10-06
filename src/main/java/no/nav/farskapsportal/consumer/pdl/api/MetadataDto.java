package no.nav.farskapsportal.consumer.pdl.api;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Value;

@Value
public class MetadataDto {
  String opplysningsId;
  @NotEmpty String master;
  @NotNull List<EndringDto> endringer;
  @Setter Boolean historisk;
}
