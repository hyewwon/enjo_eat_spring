package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eatery-selection-api")
public class EaterySelectionAPIController {
    EateryService eateryService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EaterySelectionAPIController(EateryService eateryService){
        this.eateryService = eateryService;
    }

    @GetMapping("/eatery-select/{eateryId}")
    public ResponseEntity<SuccessResponse<EateryDTO.SelectionResponseDTO>> getSelectedEatery(@PathVariable Long eateryId){
        EateryDTO.SelectionResponseDTO selectionResponseDTO = eateryService.getSelectedEatery(eateryId);
        SuccessResponse<EateryDTO.SelectionResponseDTO> response = SuccessResponse.of(SuccessCode.SELECT_SUCCESS, selectionResponseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get-eatery-location-list")
    public ResponseEntity<SuccessResponse<List<String>>> getEateryLocationList(){
        List<String> eateryLocationList = eateryService.getAllEateryLocationList();
        SuccessResponse<List<String>> response = SuccessResponse.of(SuccessCode.SELECT_SUCCESS, eateryLocationList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
