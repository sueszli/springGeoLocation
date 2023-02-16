package geolocation.location.persistence;

import geolocation.location.model.dto.LocationSearchDto;
import geolocation.location.model.entity.Location;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LocationDaoImpl implements LocationDao {

    private final LocationJpaRepository locationJpaRepository;

    @Override
    public List<Location> searchLocations(LocationSearchDto query) {
        log.info("Searching locations: {}", query);
        if (query == null) {
            return locationJpaRepository.findAll();
        }

        var specification = buildSpecification(query);
        return locationJpaRepository.findAll(specification);
    }

    private boolean isInRectangle(LocationSearchDto.Point p1, LocationSearchDto.Point p2, double lat, double lng) {
        var minLat = Math.min(p1.getLat(), p2.getLat());
        var maxLat = Math.max(p1.getLat(), p2.getLat());
        var minLng = Math.min(p1.getLng(), p2.getLng());
        var maxLng = Math.max(p1.getLng(), p2.getLng());
        return minLat <= lat && lat <= maxLat && minLng <= lng && lng <= maxLng;
    }

    private Specification<Location> buildSpecification(LocationSearchDto query) {
        var template = Location.builder()
                .type(query.getType())
                .build();

        return null;
    }


}
