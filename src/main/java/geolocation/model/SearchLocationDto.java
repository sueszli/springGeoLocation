package geolocation.model;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SearchLocationDto {

    @NotNull
    private Point p1;

    @NotNull
    private Point p2;

    @Nullable
    private LocationTypeEnum type;

    @Min(0)
    @Nullable
    private Integer limit;

    @Getter
    @Setter
    @ToString
    public static class Point {

        @NotNull
        @DecimalMin(value = "-90")
        @DecimalMax(value = "90")
        private Double lat;

        @NotNull
        @DecimalMin(value = "-180")
        @DecimalMax(value = "180")
        private Double lng;
    }
}