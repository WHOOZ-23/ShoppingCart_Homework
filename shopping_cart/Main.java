package shopping_cart;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();

        Product product1 = new Product("1", "칫솔", 5000);
        Product product2 = new Product("2", "치약", 12000);

        productSet.add(product1);
        productSet.add(product2);

        // 상품 목록 확인
        System.out.println("상품 목록 확인");
        for(Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        myCart.addProduct(product1, 2);
        myCart.addProduct(product2, 3);

        // 장바구니에서 상품 제거
        myCart.removeProduct(product1, 2);
        myCart.removeProduct(product2, 1);

        // 장바구니의 상품 모두 출력
        myCart.showItems();

        // 추가 테스트
        myCart.removeProduct(product1, 1);
        System.out.println(myCart.showItemsStream());

        myCart.addProduct(product1, 1);

        System.out.println(myCart.showItemsStream());
    }
}
