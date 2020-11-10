package com.jojodu.book.springboot.web;

import com.jojodu.book.springboot.service.SalesStatsService;
import com.jojodu.book.springboot.web.dto.SalesStatsResponseDto;
import com.jojodu.book.springboot.web.dto.SalesStatsSaveRequestDto;
import com.jojodu.book.springboot.web.dto.SalesStatsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SalesStatsApiController {

    private final SalesStatsService salesStatsService;

    @PostMapping("/api/v1/salesStats")
    public Long save(@RequestBody SalesStatsSaveRequestDto requestDto){
        return salesStatsService.save(requestDto);
    }

    @PutMapping("/api/v1/salesStats/{id}")
    public Long update(@PathVariable Long id, @RequestBody SalesStatsUpdateRequestDto requestDto){
        return salesStatsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/salesStats/{id}")
    public SalesStatsResponseDto findById(@PathVariable Long id){
        return salesStatsService.findById(id);
    }

    @DeleteMapping("/api/v1/salesStats/{id}")
    public Long delete(@PathVariable Long id) {
        salesStatsService.delete(id);
        return id;
    }

}
