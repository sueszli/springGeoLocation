package geolocation.persistence;

import geolocation.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationJpaRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
}
