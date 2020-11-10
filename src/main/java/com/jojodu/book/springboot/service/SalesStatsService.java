package com.jojodu.book.springboot.service;

import com.jojodu.book.springboot.domain.salesStats.SalesStats;
import com.jojodu.book.springboot.domain.salesStats.SalesStatsRepository;
import com.jojodu.book.springboot.web.dto.SalesStatsListResponseDto;
import com.jojodu.book.springboot.web.dto.SalesStatsResponseDto;
import com.jojodu.book.springboot.web.dto.SalesStatsSaveRequestDto;
import com.jojodu.book.springboot.web.dto.SalesStatsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SalesStatsService {

    private final SalesStatsRepository salesStatsRepository;

    @Transactional
    public Long save(SalesStatsSaveRequestDto requestDto){
        return salesStatsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, SalesStatsUpdateRequestDto requestDto){
        SalesStats SalesStats = salesStatsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        SalesStats.update(requestDto.getSales_month(),
                        requestDto.getTap_code(),
                        requestDto.getSep(),
                        requestDto.getCountry(),
                        requestDto.getPhone_type(),
                        requestDto.getCarrier(),
                        requestDto.getUsd_charge(), requestDto.getKrw_charge());
        return id;
    }

    public SalesStatsResponseDto findById(Long id){
        SalesStats entity = salesStatsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));

        return new SalesStatsResponseDto(entity);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<SalesStatsListResponseDto> findAllDesc(){
        return salesStatsRepository.findAllDesc().stream().map(SalesStatsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        SalesStats SalesStats = salesStatsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다 id=" + id));

        salesStatsRepository.delete(SalesStats);
    }
}
