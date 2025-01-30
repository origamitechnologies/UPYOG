package org.travansoft.barrel.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.travansoft.barrel.config.BarrelConfiguration;
import org.travansoft.barrel.kafka.Producer;
import org.travansoft.barrel.web.models.RestaurantDetails;
import org.travansoft.barrel.web.models.ServiceRequest;
import org.travansoft.barrel.web.models.contract.request.RestaurantRequest;

@Slf4j
@Repository
@AllArgsConstructor
public class RestaurantDetailsRepository {

   private final Producer producer;
   private final BarrelConfiguration config;
    private final JdbcTemplate jdbcTemplate;
//    AssetDisposalRowMapper  assetDisposalRowMapper;
//    private AssetDisposalQueryBuilder queryBuilder;

    public void save(ServiceRequest serviceRequest) {
        producer.push(config.getSaveTopic(), serviceRequest);
    }

    public void update(ServiceRequest serviceRequest) {
        producer.push(config.getUpdateTopic(), serviceRequest);
    }

//    public List<AssetDisposal> search(AssetDisposalSearchCriteria searchCriteria) {
//        List<Object> preparedStmtList = new ArrayList<>();
//        String query = null;
//        if (searchCriteria != null) {
//            query = queryBuilder.getDisposalSearchQuery(searchCriteria, preparedStmtList);
//            log.info("Final asset disposal search query: {}", query);
//            return jdbcTemplate.query(query, preparedStmtList.toArray(), assetDisposalRowMapper);
//        }
//        return  null;
//    }
}
