package org.yearup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.models.Product;
import org.yearup.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductsController
{
    private final ProductService productService;

    public ProductsController(ProductService productService)
    {
        this.productService = productService;
    }

    /**
     * Searches for products using optional filter criteria.
     * Public endpoint accessible without authentication.
     *
     * @param categoryId  Optional. Filters products by category id.
     * @param minPrice    Optional. Filters products with price >= inputted value.
     * @param maxPrice    Optional. Filters products with price <= inputted value.
     * @param subCategory Optional. Filters products by subcategory name.
     *
     * @return List of products matching all provided criteria, or all products if no filters applied.
     */
    @GetMapping("")
    @PreAuthorize("permitAll()")
    public List<Product> search(@RequestParam(name="cat", required = false) Integer categoryId,
                                @RequestParam(name="minPrice", required = false) Double minPrice,
                                @RequestParam(name="maxPrice", required = false) Double maxPrice,
                                @RequestParam(name="subCategory", required = false) String subCategory)
    {
        return productService.search(categoryId, minPrice, maxPrice, subCategory);
    }

    /**
     * Gets a single product by its id.
     * Endpoint requires no authentication.
     *
     * @param id The id of the product to get
     * @return ResponseEntity containing the specific product with HTTP 200 OK if found,
     *         or HTTP 404 Not Found if the product doesn't exist
     */
    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public Product getById(@PathVariable int id)
    {
        Product product = productService.getById(id);

        if (product == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return product;
    }

    /**
     * Creates a new product in the system.
     * Endpoint requires ADMIN role authorization.
     *
     * @param product The Product object containing the details of the product to create
     * @return ResponseEntity containing the created Product object with HTTP 201 Created status
     */
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        Product saved = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Updates an existing product by its id.
     * Endpoint requires ADMIN role authorization.
     *
     * @param id The id of the product to update
     * @param product The Product object containing the updated details
     * @return ResponseEntity containing the updated product with HTTP 200 OK if successful,
     *         or HTTP 404 Not Found if the product doesn't exist
     */
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        if (productService.getById(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return productService.update(id, product);
    }

    /**
     * Deletes a product by its id.
     * Endpoint requires ADMIN role authorization.
     *
     * @param id The id of the product to delete
     * @return ResponseEntity with HTTP 204 No Content if deletion was successful,
     *         or HTTP 404 Not Found if the category doesn't exist
     */
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id)
    {
        if (productService.getById(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
