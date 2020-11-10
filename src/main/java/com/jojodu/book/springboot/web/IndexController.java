package com.jojodu.book.springboot.web;

import com.jojodu.book.springboot.domain.salesStats.SalesStats;
import com.jojodu.book.springboot.service.PostsService;
import com.jojodu.book.springboot.service.SalesStatsService;
import com.jojodu.book.springboot.web.dto.PostsResponseDto;
import com.jojodu.book.springboot.web.dto.SalesStatsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final SalesStatsService salesStatsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/salesStats/")
    public String index_salesStats(Model model){
        model.addAttribute("salesStats", salesStatsService.findAllDesc());
        return "salesStats";
    }

    @GetMapping("/salesStats/save")
    public String salesStatsSave(){
        return "salesStats-save";
    }

    @GetMapping("/salesStats/update/{id}")
    public String salesStatsUpdate(@PathVariable Long id, Model model) {
        SalesStatsResponseDto dto = salesStatsService.findById(id);
        model.addAttribute("salesStats", dto);

        return "salesStats-update";
    }

}
