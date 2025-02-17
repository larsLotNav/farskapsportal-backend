package no.nav.farskapsportal.backend.libs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Forelder implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NaturalId
  @Column(updatable = false)
  private String foedselsnummer;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "mor", cascade = CascadeType.MERGE)
  private final Set<Farskapserklaering> erklaeringerMor = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "far", cascade = CascadeType.MERGE)
  private final Set<Farskapserklaering> erklaeringerFar = new HashSet<>();

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (foedselsnummer == null ? 0 : foedselsnummer.hashCode());
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
    final Forelder other = (Forelder) obj;
    return foedselsnummer.equals(other.foedselsnummer);
  }
}
