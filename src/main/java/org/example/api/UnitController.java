package org.example.api;


import org.example.model.units.Unit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("units")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> handleUnitInstance(@PathVariable("id") String id){
        try{
            return ResponseEntity.ok(unitService.getUnitInstance(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit notfound", e);
        }
    }
}
