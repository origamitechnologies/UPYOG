package org.travansoft.barrel.service;
import digit.models.coremodels.IdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.travansoft.barrel.repository.RestaurantDetailsRepository;
import org.travansoft.barrel.web.models.AuditDetails;
import org.travansoft.barrel.web.models.RestaurantDetails;
import org.travansoft.barrel.web.models.ServiceRequest;
import org.travansoft.barrel.web.models.contract.request.RestaurantRequest;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {
    private final RestaurantDetailsRepository restaurantDetailsRepository;
    public RestaurantDetails create(RestaurantRequest restaurantRequest) {
        ServiceRequest service = new ServiceRequest();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true);
        RestaurantDetails restaurantDetail = modelMapper.map(restaurantRequest, RestaurantDetails.class);
        AuditDetails auditDetails = getAuditDetails(UUID.randomUUID().toString(), restaurantDetail,true);

        restaurantDetail.setAuditDetails(auditDetails);
        restaurantDetail.setId(UUID.randomUUID());
        restaurantDetail.setActive(Boolean.TRUE);
        service.setRestaurantDetail(restaurantDetail);
        restaurantDetailsRepository.save(service);
        return restaurantDetail;

    }

    public RestaurantDetails update(RestaurantRequest restaurantRequest) {
        ServiceRequest service = new ServiceRequest();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true);
        RestaurantDetails restaurantDetail = modelMapper.map(restaurantRequest, RestaurantDetails.class);
        restaurantDetail.setAuditDetails(getAuditDetails(UUID.randomUUID().toString(), restaurantDetail,true));
        restaurantDetail.setActive(Boolean.TRUE);
        service.setRestaurantDetail(restaurantDetail);
        restaurantDetailsRepository.update(service);
        return restaurantDetail;
    }
    /**
     * Method to return auditDetails for create/update flows
     *
     * @param by
     * @param isCreate
     * @return AuditDetails
     */
    public AuditDetails getAuditDetails(String by, RestaurantDetails restaurantDetail, Boolean isCreate) {
        Long time = System.currentTimeMillis();
        if(isCreate)
            return AuditDetails.builder().createdBy(by).lastModifiedBy(by).createdTime(time).lastModifiedTime(time).build();
        else
            return AuditDetails.builder().createdBy(restaurantDetail.getAuditDetails().getCreatedBy()).lastModifiedBy(by)
                    .createdTime(restaurantDetail.getAuditDetails().getCreatedTime()).lastModifiedTime(time).build();
    }

}
