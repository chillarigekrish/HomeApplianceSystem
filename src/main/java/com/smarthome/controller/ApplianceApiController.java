package com.smarthome.controller;

import com.smarthome.exceptions.InvalidApplianceTypeException;
import com.smarthome.service.SmartHomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appliances")
public class ApplianceApiController {

    @Autowired
    private SmartHomeService service;

    @PostMapping("/init")
    @Operation(summary = "Initialize and register specified appliances")
    @ApiResponse(responseCode = "200", description = "Specified appliances initialized")
    public ResponseEntity<String> initialize(
            @RequestBody
            @Schema(description = "List of appliances to initialize", allowableValues = {"LIGHT", "FAN", "AC"}, example = "[\"LIGHT\", \"FAN\", \"AC\"]")
            List<String> appliances) {
        try {
            if (appliances.isEmpty()) {
                throw new Exception("Appliances list is empty");
            }
            return ResponseEntity.ok(service.initialize(appliances));
        } catch (InvalidApplianceTypeException e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + " Appliance is not found\"}");
        } catch(Exception e)
    {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
    }

    @PostMapping("/light/on")
    @Operation(summary = "Turn ON the light")
    public ResponseEntity<String> turnOnLight() {
        try {
            return ResponseEntity.ok(service.turnOnLight());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to turn on light.");
        }
    }

    @PostMapping("/light/off")
    @Operation(summary = "Turn OFF the light")
    public ResponseEntity<String> turnOffLight() {
        try {
            return ResponseEntity.ok(service.turnOffLight());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to turn off light.");
        }
    }

    @PostMapping("/fan/speed")
    @Operation(summary = "Set fan speed (0 = off, 1, 2)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fan speed set successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid fan speed")
    })
    public ResponseEntity<String> setFanSpeed(@RequestParam int speed) {
        try {
            return ResponseEntity.ok(service.setFanSpeed(speed));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to set fan speed.");
        }
    }

    @PostMapping("/ac/on")
    @Operation(summary = "Turn ON the Air Conditioner")
    public ResponseEntity<String> turnOnAC() {
        try {
            return ResponseEntity.ok(service.turnOnAC());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to turn on AC.");
        }
    }

    @PostMapping("/ac/off")
    @Operation(summary = "Turn OFF the Air Conditioner")
    public ResponseEntity<String> turnOffAC() {
        try {
            return ResponseEntity.ok(service.turnOffAC());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to turn off AC.");
        }
    }

    @Operation(
            summary = "Get the status of specified appliances",
            description = "Returns the ON/OFF status of the appliances provided in the request body. If an appliance is not found, it returns 'No Appliance initialized'.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Status map of requested appliances"),
            }
    )
    @PostMapping("/status")
    public ResponseEntity<List<String>> getApplianceStatuses() throws Exception {

        List<String> statusMap = service.getStatus();
        return ResponseEntity.ok(statusMap);
    }
}
