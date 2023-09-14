package org.blueliner.springmvc.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OwnDepositsResponse {
    private String depositName;
    private Long percent;
    private Long sum;
    private LocalDate dateOfOpening;
}
