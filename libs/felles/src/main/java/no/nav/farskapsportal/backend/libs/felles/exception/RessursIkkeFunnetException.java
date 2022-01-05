package no.nav.farskapsportal.backend.libs.felles.exception;

import java.util.Optional;
import lombok.Getter;
import no.nav.farskapsportal.backend.libs.dto.StatusKontrollereFarDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessursIkkeFunnetException extends UnrecoverableException {

  private final Feilkode feilkode;

  public RessursIkkeFunnetException(Feilkode feilkode) {
    super(feilkode.getBeskrivelse());
    this.feilkode = feilkode;
  }

  public Feilkode getFeilkode() {
    return this.feilkode;
  }
}
