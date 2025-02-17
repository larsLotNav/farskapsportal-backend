package no.nav.farskapsportal.backend.libs.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Builder
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class StatusKontrollereFar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Forelder mor;

  private String registrertNavnFar;

  private String oppgittNavnFar;

  private int antallFeiledeForsoek;

  private LocalDateTime tidspunktForNullstilling;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (mor == null ? 0 : mor.hashCode()) + antallFeiledeForsoek * prime + (tidspunktForNullstilling == null ? 0 : tidspunktForNullstilling
        .hashCode());

    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final StatusKontrollereFar other = (StatusKontrollereFar) obj;

    if (!mor.equals(other.mor)) {
      return false;
    }

    if (antallFeiledeForsoek != other.getAntallFeiledeForsoek()) {
      return false;
    }

    return tidspunktForNullstilling.equals(other.tidspunktForNullstilling);
  }

  @Override
  public String toString() {
    return "StatusKontrollereFar gjelder " + mor.toString()  + " Antall feilede forsøk for å kontrollere navn mot fødselsnummer til far: " + antallFeiledeForsoek + "."
        + "\n Tidspunkt siste feilede forsøk: " + tidspunktForNullstilling;
  }

}
