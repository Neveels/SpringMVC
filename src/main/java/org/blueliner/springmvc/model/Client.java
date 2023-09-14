package org.blueliner.springmvc.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.internal.build.AllowPrintStacktrace;

import java.util.List;
import java.util.Objects;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:30
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Long balance;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Operation> operationList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
