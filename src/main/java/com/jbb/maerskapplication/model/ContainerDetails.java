package com.jbb.maerskapplication.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Data
@ToString
public class ContainerDetails {
    @NotNull
    private Integer containerSize;
    private String containerType;
    @NotNull
    @Range(min = 5, max = 20, message = "")
    private String origin;
    @NotNull
    @Range(min = 5, max = 20, message = "")
    private String destination;
    @NotNull
    @Range(min = 1, max = 100, message = "quantity should be min 5 and max 100")
    private Integer quantity;
    ZonedDateTime timestamp;
}
