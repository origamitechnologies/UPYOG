package org.travansoft.barrel.web.models.contract.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.travansoft.barrel.web.models.AuditDetails;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantRequest {
    private UUID id;
    private String code;
    private String tradeName;
    private String legalName;
    private String liquorLicenceNumber;
    private String pan;
    private String gstNumber;
    private String tinNo;
    private Integer districtId;
    private Long divisionId;
    private Long circleId;
    private String flLicenceId;
}
