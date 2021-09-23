package com.geekbrains.demo.specification;

import com.geekbrains.demo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

    SearchCriteria searchCriteria;

    public ProductSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if(searchCriteria.getOperation().equals(">")) {
           return criteriaBuilder.greaterThanOrEqualTo(
                   root.get(searchCriteria.getKey().toString()), searchCriteria.getValue().toString());
        } else if (searchCriteria.getOperation().equals("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(searchCriteria.getKey().toString()), searchCriteria.getValue().toString());
        } else if (searchCriteria.getOperation().equals(":")) {
            if (root.get(searchCriteria.getKey()).getJavaType().equals(String.class)) {
                return criteriaBuilder.like(
                        root.get(searchCriteria.getKey().toString()), "%" + searchCriteria.getValue().toString() + "%");
            } else {
                return criteriaBuilder.equal(
                        root.get(searchCriteria.getKey().toString()), searchCriteria.getValue().toString());
            }
        } else {
            return null;
        }

    }
}
