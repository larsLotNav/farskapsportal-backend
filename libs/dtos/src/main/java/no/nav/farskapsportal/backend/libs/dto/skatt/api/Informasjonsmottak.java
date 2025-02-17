package no.nav.farskapsportal.backend.libs.dto.skatt.api;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"informasjonskanal", "mottakstidspunktFraOpprinneligkanal", "puncher"})
public class Informasjonsmottak {

  @XmlElement
  private KanalForRegistreringAvFarskap informasjonskanal;

  @XmlElement
  private Dato mottakstidspunktFraOpprinneligkanal;

  @XmlElement
  private NorskIdentifikator puncher;

}
