package no.nav.farskapsportal.persistence.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Farskapserklaering implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne(cascade = CascadeType.ALL)
  private Barn barn;

  @ManyToOne(cascade = CascadeType.ALL)
  private Forelder mor;

  @ManyToOne(cascade = CascadeType.ALL)
  private Forelder far;

  @OneToOne(cascade = CascadeType.ALL)
  private Dokument dokument;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result
            + (barn == null ? 0 : barn.hashCode())
            + (mor == null ? 0 : mor.hashCode())
            + (far == null ? 0 : far.hashCode());

    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final Farskapserklaering other = (Farskapserklaering) obj;

    if (!barn.equals(other.barn)) {
      return false;
    }
    if (!mor.equals(other.mor)) return false;
    return far.equals(other.far);
  }

  @Override
  public String toString() {
    return "Farskapserklaering gjelder barn med termindato "
        + barn.getTermindato().toString()
        + "\n"
        + "Mor: "
        + mor.getFornavn()
        + " "
        + mor.getEtternavn()
        + "\n"
        + "Far: "
        + far.getFornavn()
        + " "
        + far.getEtternavn();
  }
}
