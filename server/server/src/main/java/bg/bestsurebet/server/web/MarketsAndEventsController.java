package bg.bestsurebet.server.web;

import bg.bestsurebet.server.model.dto.Market1x2DTO;
import bg.bestsurebet.server.service.Market1x2Service;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bets")
public class MarketsAndEventsController {

    private final Market1x2Service market1x2Service;

    @Autowired//Autowired not required on constructor
    public MarketsAndEventsController(Market1x2Service market1x2Service) {
        this.market1x2Service = market1x2Service;
    }

    @Tag(name = "Get all markets1x2", description = "return all markets1x2")
    @ApiResponse(
            responseCode = "200",
            description = "If the markets1x2 were retrieved successfully"
    )
    @ApiResponse(
            responseCode = "404",
            description = "If no markets1x2 were not found"
    )
    @GetMapping
    public ResponseEntity<List<Market1x2DTO>> getAllMarkets1x2() {
        return ResponseEntity
                .ok(market1x2Service.getAllMarkets1x2());
    }

}
