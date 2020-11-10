package com.jojodu.book.springboot.web.dto;
import com.jojodu.book.springboot.domain.salesStats.SalesStats;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SalesStatsListResponseDto {
    private Long id;
    private String sales_month;
    private String tap_code;
    private String sep;
    private String phone_type;
    private String country;
    private String carrier;
    private String usd_charge;
    private String krw_charge;
    private LocalDateTime modifiedDate;

    public SalesStatsListResponseDto(SalesStats entity) {
        this.id = entity.getId();
        this.sales_month = entity.getSales_month();
        this.tap_code = entity.getTap_code();
        this.sep = entity.getSep();
        this.usd_charge = entity.getUsd_charge();
        this.krw_charge = entity.getKrw_charge();
        this.modifiedDate = entity.getModifiedDate();
        this.phone_type = entity.getPhone_type();
        this.country=entity.getCountry();
        this.carrier=entity.getCarrier();
    }
}