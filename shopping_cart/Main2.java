package shopping_cart;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();

        BufferedReader br = null;
        String line;
        String path = "C:\\Users\\User\\Desktop\\goorm\\과제\\백엔드 과제\\Homework\\src\\shopping_cart\\data.csv";
        List<Product> myProducts = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
            while((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                Product product = new Product(temp[0], temp[1], Integer.parseInt(temp[2]));
                productSet.add(product);
                myProducts.add(product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

        myCart.addProduct(myProducts.get(0), 2);
        myCart.addProduct(myProducts.get(1), 3);

        // 장바구니에서 상품 제거
        myCart.removeProduct(myProducts.get(0), 2);
        myCart.removeProduct(myProducts.get(1), 1);

        // 장바구니의 상품 모두 출력
        myCart.showItems();

        // 추가 테스트
        myCart.removeProduct(myProducts.get(0), 1);
        System.out.println(myCart.showItemsStream());

        myCart.addProduct(myProducts.get(0), 1);

        System.out.println(myCart.showItemsStream());
    }
}
