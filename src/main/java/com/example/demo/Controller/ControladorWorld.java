package com.example.demo.Controller;


import com.example.demo.Model.World;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Define a clase como un controlador REST => @Controller e @ResponseBody
 */
@RestController
@RequestMapping("api")
@Api(
        tags = "Servicio World",
        description = "Descripcion",
        produces = "application/json"
)
public class ControladorWorld {

    // Definición en swagger
    @ApiOperation("Obtener objeto world")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "ERROR")
    })
    @GetMapping(
            path = "/world",
            produces = "application/json"
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<World> getWorld() {

        ResponseEntity.BodyBuilder response = ResponseEntity.ok();
        World world = new World();
        world.getMessage();
        world.getId();

        return response.body(world);
    }

}
