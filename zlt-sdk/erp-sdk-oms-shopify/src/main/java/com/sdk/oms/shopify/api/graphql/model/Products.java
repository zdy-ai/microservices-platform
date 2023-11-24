package com.sdk.oms.shopify.api.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonRootName(value = "products")
public class Products {

    public static String NODE_NAME = "products";

    @JsonProperty("edges")
    private ArrayList<ProductNode> productNodes;


    /**
     * @return List<Product>
     */
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        for (ProductNode productNode : productNodes) {
            products.add(productNode.getProduct());
        }
        return products;
    }

}
