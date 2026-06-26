package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.models.Category;
import org.yearup.models.Product;
import org.yearup.service.CategoryService;
import org.yearup.service.ProductService;

import java.util.List;

// add the annotations to make this a REST controller
@RestController
// add the annotation to make this controller the endpoint for the following url
@RequestMapping("/categories")
// add annotation to allow cross site origin requests
@CrossOrigin(origins = "*")
public class CategoriesController
{
    private CategoryService categoryService;
    private ProductService productService;

    // create an Autowired constructor to inject the categoryService and productService
    @Autowired
    public CategoriesController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


    /**
     * Gets all categories from the database.
     * Endpoint requires no authentication.
     *
     * @return ResponseEntity containing a list of all categories with HTTP 200 OK status
     */
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        // find and return all categories
//        categoryService.getAllCategories();
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    /**
     * Gets a single category by its id.
     * Endpoint requires no authentication.
     *
     * @param id The id of the category to get
     * @return ResponseEntity containing the specific category with HTTP 200 OK if found,
     *         or HTTP 404 Not Found if the category doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id)
    {
        // get the category by id
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get all products that belong to a specific category.
     * Example URL: https://localhost:8080/categories/1/products
     * Endpoint requires no authentication.
     *
     * @param categoryId The id of the category whose products are to be retrieved
     * @return ResponseEntity containing a list of products with HTTP 200 OK status
     */
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable int categoryId){
        // get a list of product by categoryId
        return ResponseEntity.ok(productService.getProductByCategory(categoryId));
    }

    /**
     * Creates a new category in the system.
     * Endpoint requires ADMIN role authorization.
     *
     * @param category The Category object containing the details of the category to create
     * @return ResponseEntity containing the created Category object with HTTP 201 Created status
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        // insert the category and return it with status 201 Created
        Category created = categoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Updates an existing category by its id.
     * Endpoint requires ADMIN role authorization.
     *
     * @param id The id of the category to update
     * @param category The Category object containing the updated details
     * @return ResponseEntity containing the updated category with HTTP 200 OK if successful,
     *         or HTTP 404 Not Found if the category doesn't exist
     */
    @PutMapping("/{id}")
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        // update the category by id and return the updated category (200 OK)
        return categoryService.update(id,category)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    /**
     * Deletes a category by its id.
     * Endpoint requires ADMIN role authorization.
     *
     * @param id The id of the category to delete
     * @return ResponseEntity with HTTP 204 No Content if deletion was successful,
     *         or HTTP 404 Not Found if the category doesn't exist
     */
    @DeleteMapping("/{id}")
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        // delete the category by id and return status 204 No Content
        if (categoryService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
