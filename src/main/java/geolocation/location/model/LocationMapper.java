package geolocation.location.model;

import geolocation.location.model.dto.CreateLocationDto;
import geolocation.location.model.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class LocationMapper {
    public abstract Location dtoToEntity(CreateLocationDto dto);
}
