package org.travansoft.barrel.service;

import digit.models.coremodels.IdResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.travansoft.barrel.config.BarrelConfiguration;
import org.travansoft.barrel.repository.IdGenRepository;
import org.travansoft.barrel.util.BarrelErrorConstants;
import org.travansoft.barrel.web.models.RestaurantDetails;
import org.travansoft.barrel.web.models.contract.request.RestaurantRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class EnrichmentService {

    private BarrelConfiguration config;
    private IdGenRepository idGenRepository;
    /**
     * Generates and sets application numbers for the given Asset request using the ID generation service.
     *
     * @param request The Asset request for which application numbers need to be generated.
     */
    private void setIdgenIds(RestaurantRequest request) {

        String tenantId = "kl";
        RestaurantDetails restaurantDetails = new RestaurantDetails();
        RequestInfo requestInfo =new RequestInfo();  // Replace with user token
        // Generate application numbers using ID generation service
        List<String> applicationNumbers = getIdList(requestInfo, tenantId, config.getApplicationNoIdgenName(),
                config.getApplicationNoIdgenFormat(), 1);

        if (applicationNumbers.isEmpty()) {
            throw new CustomException(BarrelErrorConstants.IDGEN_ERROR, "No IDs returned from ID generation service");
        }

        // Set the application number for the asset
        restaurantDetails.setCode(applicationNumbers.get(0));
    }

    /**
     * Fetches a list of IDs from the ID generation service.
     *
     * @param requestInfo Request information for the service call.
     * @param tenantId    Tenant ID for which IDs are generated.
     * @param idKey       Key used for ID generation.
     * @param idformat    Format of the IDs to be generated.
     * @param count       Number of IDs to generate.
     * @return A list of generated IDs.
     */
    private List<String> getIdList(RequestInfo requestInfo, String tenantId, String idKey, String idformat, int count) {
        List<IdResponse> idResponses = idGenRepository.getId(requestInfo, tenantId, idKey, idformat, count)
                .getIdResponses();

        if (CollectionUtils.isEmpty(idResponses)) {
            throw new CustomException(BarrelErrorConstants.IDGEN_ERROR, "No IDs returned from ID generation service");
        }

        // Extract and return IDs from the response
        return idResponses.stream().map(IdResponse::getId).collect(Collectors.toList());
    }

}
