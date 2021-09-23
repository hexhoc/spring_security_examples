package com.geekbrains.demo.controller;

import com.geekbrains.demo.entity.Product;
import com.geekbrains.demo.repository.ProductRepository;
import com.geekbrains.demo.specification.ProductSpecification;
import com.geekbrains.demo.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/product")
public class ProductController {

    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public String getProductList(Model model,
                                 @RequestParam(name = "priceMin", required = false) Double priceMin,
                                 @RequestParam(name = "priceMax", required = false) Double priceMax,
                                 @RequestParam(name = "keyword", required = false) String keyword
    ) {
        Specification<Product> productSpecification = Specification.where(null);
        if (Objects.nonNull(priceMin)) {
            productSpecification = productSpecification.and(
                    new ProductSpecification(new SearchCriteria("price", ">", priceMin)));
        };

        if (Objects.nonNull(priceMax)) {
            productSpecification = productSpecification.and(
                    new ProductSpecification(new SearchCriteria("price", ">", priceMax)));
        };

        if (Objects.nonNull(keyword) && !keyword.isEmpty()) {
            productSpecification = productSpecification.and(
                    new ProductSpecification(new SearchCriteria("name", ":", keyword)));
        };

        List<Product> products = productRepository.findAll(productSpecification);

        model.addAttribute("products", products);
        model.addAttribute("priceMin", priceMin);
        model.addAttribute("priceMax", priceMax);
        model.addAttribute("keyword", keyword);

        return "product/list";
    }

    @GetMapping({"/show/{id}", "/new"})
    public String getProduct(@PathVariable(name = "id", required = false) Long id, Model model) {

        Product product = new Product();

        if (Objects.nonNull(id)) {
            product = productRepository.findById(id).get();
        }

        model.addAttribute("product", product);

        return "product/details";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/product/list";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/product/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam(name = "id") Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return "redirect:/product/list";
    }

}
