package geolocation.location.controller;

import geolocation.location.model.LocationMapper;
import geolocation.location.model.dto.LocationCreateDto;
import geolocation.location.model.dto.LocationSearchDto;
import geolocation.location.model.entity.Location;
import geolocation.location.persistence.LocationDao;
import geolocation.location.persistence.LocationJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class LocationController {

    LocationMapper locationMapper;
    LocationJpaRepository locationJpaRepository;
    LocationDao locationDao;

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody LocationCreateDto dto) {
        log.info("Creating location: {}", dto);
        var entity = locationMapper.dtoToEntity(dto);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(locationJpaRepository.save(entity));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> searchLocations(@RequestBody LocationSearchDto query) {
        log.info("Searching locations: {}", query);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(locationDao.searchLocations(query));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
