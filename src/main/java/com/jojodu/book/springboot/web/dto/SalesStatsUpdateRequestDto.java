package com.jojodu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SalesStatsUpdateRequestDto {

    private String sales_month;
    private String tap_code;
    private String sep;
    private String usd_charge;
    private String krw_charge;
    private String phone_type;
    private String country;
    private String carrier;

    @Builder
    public SalesStatsUpdateRequestDto(String sales_month, String tap_code, String sep, String usd_charge,
                                      String krw_charge, String phone_type, String carrier, String country){

        this.sales_month = sales_month;
        this.tap_code = tap_code;
        this.sep = sep;
        this.usd_charge = usd_charge;
        this.krw_charge = krw_charge;
        this.phone_type=phone_type;
        this.carrier=carrier;
        this.country=country;
    }
}
