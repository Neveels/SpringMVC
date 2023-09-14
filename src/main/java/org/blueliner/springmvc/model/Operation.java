package org.blueliner.springmvc.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:36
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfCreation;
    private Long sumOfOperation;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    public static enum OperationType {
        ADD("Пополнение"),
        WITHDRAWAL("Снятие");

        public String url;

        OperationType(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "OperationType{" +
                "url='" + url + '\'' +
                '}';
        }
    }
    @PrePersist
    private void init() {
        dateOfCreation = LocalDate.now();
    }
}
