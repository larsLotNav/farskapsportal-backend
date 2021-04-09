package no.nav.farskapsportal.consumer.skatt.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"innsending", "forespoerselOmRegistreringAvFarskap"})
public class MeldingOmRegistreringAvFarskap {

  @XmlElement
  private Innsending innsending;

  @XmlElement
  private ForespoerselOmRegistreringAvFarskap forespoerselOmRegistreringAvFarskap;

}
