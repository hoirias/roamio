package com.jojodu.book.springboot.domain.salesStats;
import com.jojodu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class SalesStats extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT", nullable = false)
    private String sales_month;
    private String tap_code;
    private String phone_type;
    private String country;
    private String carrier;
    private String sep;
    private String usd_charge;
    private String krw_charge;

    @Builder
    public SalesStats(String sales_month, String tap_code, String sep,
                      String usd_charge, String krw_charge, String carrier, String country, String phone_type){
        this.sales_month = sales_month;
        this.tap_code = tap_code;
        this.sep = sep;
        this.country=country;
        this.phone_type = phone_type;
        this.carrier=carrier;
        this.usd_charge = usd_charge;
        this.krw_charge = krw_charge;
    }

    public void update(String sales_month, String tap_code, String sep,
                       String usd_charge, String krw_charge, String carrier, String country, String phone_type){
        this.sales_month = sales_month;
        this.tap_code = tap_code;
        this.sep = sep;
        this.country=country;
        this.phone_type = phone_type;
        this.carrier=carrier;
        this.usd_charge = usd_charge;
        this.krw_charge = krw_charge;
    }
}
