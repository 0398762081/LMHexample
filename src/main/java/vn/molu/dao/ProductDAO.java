package vn.molu.dao;

import vn.molu.entity.Products;

import java.util.List;

public interface ProductDAO {

    public List<Products> getProductHot();
    public List<Products> getProductByCategory(String categoryCode);
    public List<Products> getProductByCategoryLimit4(String categoryCode);
}
