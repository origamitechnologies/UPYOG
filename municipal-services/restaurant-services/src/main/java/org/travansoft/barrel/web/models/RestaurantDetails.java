package org.travansoft.barrel.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDetails {

    @JsonProperty("id")
    private UUID id=null;

    @JsonProperty("code")
    private String code;

    @JsonProperty("trade_name")
    private String tradeName;

    @JsonProperty("legal_name")
    private String legalName;

    @JsonProperty("liquor_licence_number")
    private String liquorLicenceNumber;

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("gst_number")
    private String gstNumber;

    @JsonProperty("tin_no")
    private String tinNo;

    @JsonProperty("district_id")
    private Integer districtId ;

    @JsonProperty("division_id")
    private Long divisionId;

    @JsonProperty("circle_id")
    private Long circleId;

    @JsonProperty("fl_licence_id")
    private String flLicenceId;

    @JsonProperty("active")
    private Boolean active;

    private AuditDetails auditDetails = null;

}
