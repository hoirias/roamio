package com.jojodu.book.springboot.domain.salesStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesStatsRepository extends  JpaRepository<SalesStats, Long>{

    @Query("SELECT q FROM SalesStats q Order by q.id Desc")
    List<SalesStats> findAllDesc();

}

