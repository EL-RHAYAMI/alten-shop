package com.alten.shop.controllers.api;

import com.alten.shop.dots.requests.ProductReqDto;
import com.alten.shop.dots.responses.ErrorDto;
import com.alten.shop.dots.responses.ProductResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Product")
public interface ProductApi {

    @Operation(
            summary = "Create product",
            description = "This method allows adding a product.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product Created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(
                                                    implementation = ProductResDto.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "302",
                            description = "Product already exist",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(
                                                    implementation = ErrorDto.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid object",
                            content = {
                                    @Content(
                                            array = @ArraySchema(
                                                    schema = @Schema(
                                                            implementation = String.class
                                                    )
                                            )
                                    )
                            }
                    )
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResDto> create(@RequestBody ProductReqDto dto);

    @Operation(
            summary = "Retrieve the list of products.",
            description = "This method allows searching and returning the list of products that exist in the database.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of products / Empty list"
                    )
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductResDto>> retrieveAll();

    @Operation(
            summary = "Search by ID",
            description = "This method allows searching for a product by ID.",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH, name = "productId",
                            description = "ID of product to return"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The product has been found in the database."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No product was found in the database with the provided ID.",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(
                                                    implementation = ErrorDto.class
                                            )
                                    )
                            }
                    )
            }
    )
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResDto> retrieveDetails(@PathVariable("productId") Long id);

    @Operation(
            summary = "Update product by ID",
            description = "Update an existing product by ID.",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = "productId",
                            description = "Product id that need to be updated"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The product has been updated.",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(
                                                    implementation = ProductResDto.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid object.",
                            content = {
                                    @Content(
                                            array = @ArraySchema(
                                                    schema = @Schema(
                                                            implementation = String.class
                                                    )
                                            )
                                    )
                            }
                    )
            }
    )
    @PatchMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResDto> update(@PathVariable("productId") Long id,
                                         @RequestBody Map<String, Object> fields);

    @Operation(
            summary = "Delete a product",
            description = "This method allows deleting a product by ID.",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = "productId",
                            description = "Product ID to delete"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "The product has been deleted."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No product was found in the database with the provided ID.",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(
                                                    implementation = ErrorDto.class
                                            )
                                    )
                            }
                    )
            }
    )
    @DeleteMapping(value = "/{productId}")
    ResponseEntity<Void> remove(@PathVariable("productId") Long id);

}