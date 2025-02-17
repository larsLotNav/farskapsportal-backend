package no.nav.farskapsportal.backend.apps.api.consumer.pdl.stub;

import lombok.Getter;
import lombok.Value;
import no.nav.farskapsportal.backend.libs.dto.pdl.ForelderBarnRelasjonDto;

@Value
@Getter
public class HentPersonForelderBarnRelasjon implements HentPersonSubResponse {

  String response;

  public HentPersonForelderBarnRelasjon(
      ForelderBarnRelasjonDto forelderBarnRelasjonDto, String opplysningsId) {
    this.response = buildResponse(forelderBarnRelasjonDto, opplysningsId);
  }

  private String buildResponse(ForelderBarnRelasjonDto forelderBarnRelasjonDto, String opplysningsId) {
    if (forelderBarnRelasjonDto == null) {
      return String.join("\n", " \"forelderBarnRelasjon\": [", "]");
    } else {
      return String.join(
          "\n",
          " \"forelderBarnRelasjon\": [",
          " {",
          " \"relatertPersonsIdent\": \"" + forelderBarnRelasjonDto.getRelatertPersonsIdent() + "\",",
          " \"relatertPersonsRolle\": \"" + forelderBarnRelasjonDto.getRelatertPersonsRolle() + "\",",
          " \"minRolleForPerson\": \"" + forelderBarnRelasjonDto.getMinRolleForPerson() + "\",",
          " \"metadata\": {",
          " \"opplysningsId\": \"" + opplysningsId + "\",",
          " \"master\": \"FREG\"",
          " }",
          " }",
          "]");
    }
  }

  @Override
  public String hentRespons(boolean medHistorikk) {
    return medHistorikk ? response : response;
  }
}
