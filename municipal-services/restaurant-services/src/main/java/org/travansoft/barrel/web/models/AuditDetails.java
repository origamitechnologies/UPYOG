package org.travansoft.barrel.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * Collection of audit related fields used by most models
 */
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-04-12T12:56:34.514+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditDetails {
    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("last_modified_by")
    private String lastModifiedBy = null;

    @JsonProperty("created_time")
    private Long createdTime = null;

    @JsonProperty("last_modified_time")
    private Long lastModifiedTime = null;

}

