package br.com.teste.rest.controllers;

import br.com.teste.rest.controllers.exceptions.StandardError;
import br.com.teste.rest.models.Costumer;
import br.com.teste.rest.models.StandardResponse;
import br.com.teste.rest.services.ICostumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "API Rest para consumo por SPA", tags = {"Costumers"})
public class CostumerController {

    private ICostumerService costumerService;

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Add Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer",
            position = 1)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi criado satisfatoriamente", response = StandardResponse.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class)})
    @PostMapping(value = "/costumers/add", produces = {"APPLICATION/JSON"},consumes = {"APPLICATION/JSON"} )
    public ResponseEntity<Object> addCostumer(@RequestBody Costumer costumerIn){
            Long costumerID = costumerService.addCostumer(costumerIn);
            StandardResponse result = new StandardResponse(String.format("Criado corretamente o Cliente com ID: %d",costumerID));
            return ResponseEntity.ok().body(result);
    }

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Update Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer",
            position = 2)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi atualizado satisfatoriamente", response = StandardResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PutMapping(value = "/costumers/update", produces = {"APPLICATION/JSON"},consumes = {"APPLICATION/JSON"} )
    public ResponseEntity<Object> updateCostumer(@RequestBody Costumer costumerIn){
            boolean updated = costumerService.updateCostumer(costumerIn);
            Long costumerID = costumerIn.getCostumerid();
            StandardResponse result = new StandardResponse(String.format("%s atualizado o Cliente com ID: %d",(updated?"Foi":"Não foi"),costumerID));
            return ResponseEntity.ok().body(result);
    }

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Delete Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer",
            position = 3)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi apagado satisfatoriamente", response = StandardResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @DeleteMapping(value = "/costumers/delete/{costumerId}", produces = {"APPLICATION/JSON"})
    public ResponseEntity<Object> deleteCostumer(@PathVariable Long costumerId) {
            boolean deleted = costumerService.deleteCostumer(costumerId);
            StandardResponse result = new StandardResponse(String.format("%s apagado o Cliente com ID: %d", (deleted ? "Foi" : "Não foi"), costumerId));
            return ResponseEntity.ok().body(result);
    }

    @ApiOperation(
            tags = {"Costumers"},
            value = "List of Costumer of DataBase",
            notes = "This endpoint not need parameter",
            position = 4)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar ", response = StandardResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping(value = "/costumers/list", produces = {"APPLICATION/JSON"} )
    public ResponseEntity<List<Costumer>> listCostumers(){
        return ResponseEntity.ok().body(costumerService.costumerList());
    }

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Get one Costumer of DataBase",
            notes = "This endpoint needs parameter IN Costumer",
            position = 5)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success ", response = StandardResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping(value = "/costumers/{id}/costumer", produces = {"APPLICATION/JSON"} )
    public ResponseEntity<Costumer> getCostumer(@PathVariable Long id){
        return ResponseEntity.ok().body(costumerService.getCostumer(id));
    }

    @Autowired
    private CostumerController(ICostumerService costumerService){
        this.costumerService = costumerService;
    }
}
