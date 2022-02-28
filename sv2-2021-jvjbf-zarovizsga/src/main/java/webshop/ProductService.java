package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        int realAmount = productRepository.findProductById(id).getStock();
        if (realAmount < amount) {
            throw new IllegalArgumentException("Don't enough in stock!");
        }
        productRepository.updateProductStock(id, amount);

    }
}
