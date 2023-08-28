package by.aston.intensive.aap.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Positions")
public class Position extends OrganizationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long positionId;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionId.equals(position.positionId) && name.equals(position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionId, name);
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", name='" + name + '\'' +
                '}';
    }
}
