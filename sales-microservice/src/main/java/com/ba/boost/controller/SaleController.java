package com.ba.boost.controller;

import com.ba.boost.dto.request.BaseRequestDto;
import com.ba.boost.repository.entity.Sale;
import com.ba.boost.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ba.boost.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SALES)
public class SaleController {

    private final SaleService saleService;

    @PostMapping(GETALL)
    public ResponseEntity<List<Sale>> getAll(@RequestBody @Valid BaseRequestDto dto){
        return ResponseEntity.ok(saleService.findAll());
    }
}
