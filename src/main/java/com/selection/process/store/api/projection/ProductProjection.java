package com.selection.process.store.api.projection;

import java.math.BigDecimal;

public interface ProductProjection {
    Long getId();
    String getName();
    BigDecimal getPrice();
    String getDescription();
    Integer getQuantity();
}
