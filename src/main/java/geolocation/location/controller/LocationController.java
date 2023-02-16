package geolocation.location.controller;

import geolocation.location.model.LocationMapper;
import geolocation.location.model.dto.LocationCreateDto;
import geolocation.location.model.dto.LocationSearchDto;
import geolocation.location.model.entity.Location;
import geolocation.location.persistence.LocationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {

    LocationMapper locationMapper;
    LocationJpaRepository locationJpaRepository;

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody LocationCreateDto dto) {
        try {
            Location entity = locationMapper.dtoToEntity(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(locationJpaRepository.save(entity));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> searchLocations(@RequestBody LocationSearchDto query) {



        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
