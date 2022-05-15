package com.satori.controller;

import com.satori.dto.ClubAdd;
import com.satori.dto.ClubPageDto;
import com.satori.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/clubs")
@CrossOrigin
public class ClubController {

    private final ClubService clubService;

    @GetMapping()
    public ResponseEntity<ClubPageDto> getPage(
            @RequestParam("page") @Min(0) Integer page,
            @RequestParam("size") @Min(1) Integer size,
            @RequestParam(value = "sort", required = false) Sort.Direction sort,
            @RequestParam(value = "column", required = false) String column
    ) {
        return ResponseEntity.ok(clubService.getPage(page, size, sort, column));
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody ClubAdd clubAdd) {
        clubService.save(clubAdd);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}