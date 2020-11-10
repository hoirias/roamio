package com.jojodu.book.springboot.web.dto;

import com.jojodu.book.springboot.domain.salesStats.SalesStats;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SalesStatsSaveRequestDto {

    private String sales_month;
    private String tap_code;
    private String sep;
    private String usd_charge;
    private String krw_charge;
    private String phone_type;
    private String country;
    private String carrier;

    @Builder
    public SalesStatsSaveRequestDto(String sales_month, String tap_code, String sep,
                                    String usd_charge, String krw_charge, String phone_type, String country, String carrier){
        this.sales_month = sales_month;
        this.tap_code = tap_code;
        this.sep = sep;
        this.usd_charge = usd_charge;
        this.krw_charge = krw_charge;
        this.phone_type=phone_type;
        this.country=country;
        this.carrier=carrier;
    }

    public SalesStats toEntity()
    {
        return
                SalesStats.builder()
                        .sales_month(sales_month)
                        .tap_code(tap_code)
                        .sep(sep)
                        .usd_charge(usd_charge)
                        .krw_charge(krw_charge)
                        .phone_type(phone_type)
                        .carrier(carrier)
                        .country(country)
                        .build();

    }
}
