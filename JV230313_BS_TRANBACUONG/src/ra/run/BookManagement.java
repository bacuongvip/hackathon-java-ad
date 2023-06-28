package ra.run;

import ra.config.Config;
import ra.config.InputMethods;
import ra.model.CartItem;
import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagement {
    static List<Catalog> catalogs = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    static List<CartItem> carts = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục \n" +
                    "2. Quản lý sản phẩm \n" +
                    "3. Dành cho người dùng (***) \n" +
                    "4. Thoát ");
            System.out.println("Nhập vào lựa chọn của bạn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    menuCatalog();
                    break;
                case 2:
                    menuProduct();
                    break;
                case 3:
                    user();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Phải nhâp số từ 1 đến 4");
            }
        }
    }

    public static void menuCatalog(){
        byte choice = 0;
        while (choice != 5) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục [5 điểm]\n" +
                    "2. Hiển thị thông tin tất cả các danh mục [5 điểm]\n" +
                    "3. Sửa tên danh mục theo mã danh mục [5 điểm]\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) [5 điểm]\n" +
                    "5. Quay lại");
            System.out.println("Nhập vào lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    createCatalog();
                    break;
                case 2:
                    if(catalogs.isEmpty()){
                        System.err.println("Chưa có danh muc");
                    } else {
                        System.out.println(catalogs);
                    }
                    break;
                case 3:
                    editCatalog();
                    break;
                case 4:
                    removeCatalog();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 5");
            }
        }
    }
    public static void menuProduct(){
        byte choice = 0;
        while (choice != 7) {
            System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                    "1. Nhập số sản sản phẩm và nhập thông tin sản phẩm [5 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [5 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần [5 điểm]\n" +
                    "4. Xóa sản phẩm theo mã [5 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi thông tin của sách theo mã sách [10 điểm]\n" +
                    "7. Quay lại");
            System.out.println("Nhập vào  lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    if(products.isEmpty()){
                        System.err.println("Chưa có sản pham");
                    } else {
                        System.out.println(products);
                    }
                    break;
                case 3:
                    Collections.sort(products);
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 7");
                    break;
            }
        }
    }

    public static void createCatalog() {
        // nhập vào số lượng danh muc cần thêm mới
        System.out.println("Nhập số lượng danh mục cần thêm mới");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin danh mục thứ " + (i + 1));
            Catalog catalog = new Catalog();
            System.out.println("Nhập id danh mục:");
            catalog.setCatalogId(InputMethods.getInteger());
            System.out.println("Nhập tên danh mục:");
            catalog.setCatalogName(InputMethods.getString());
            catalogs.add(catalog);
        }
    }

    public static void editCatalog(){
        System.out.println("Nhập mã danh mục: ");
        List<Integer> numbers = new ArrayList<>();
        for (Catalog catalog : catalogs) {
            numbers.add(catalog.getCatalogId());
        }
        int input = InputMethods.getInteger();
        for (Catalog catalog : catalogs) {
            if(catalog.getCatalogId() == input) {
                System.out.println("Nhập ten danh mục muốn thay đổi: ");
                String newName = InputMethods.getString();
                catalog.setCatalogName(newName);
                System.out.println("Sửa thành công");
                break;
            }
        }
    }

    public static void removeCatalog(){
        System.out.println("Nhập mã danh mục: ");
        List<Integer> numbers = new ArrayList<>();
        for (Catalog catalog : catalogs) {
            numbers.add(catalog.getCatalogId());
        }
        int input = InputMethods.getInteger();
        for (Catalog catalog : catalogs) {
            if(catalog.getCatalogId() == input) {
                catalogs.remove(catalog);
                System.out.println("Xoa thanh cong");
                break;
            }
        }
    }

    public static void createProduct() {
        // nhập vào số lượng sản phẩm cần thêm mới
        System.out.println("Nhập số lượng sản phẩm cần thêm mới");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phâm thứ " + (i + 1));
            Product product = new Product();
            System.out.println("Nhập id sản phẩm:");
            product.setProductId(InputMethods.getString());
            System.out.println("Nhập tên sản phẩm:");
            product.setProductName(InputMethods.getString());
            System.out.println("Nhập giá sản phẩm:");
            product.setProductPrice(InputMethods.getDouble());
            System.out.println("Nhập mô tả sản phẩm:");
            product.setDescription(InputMethods.getString());
            System.out.println("Nhập stock sản phẩm:");
            product.setStock(InputMethods.getInteger());

            while (true){
                boolean flag = false;
                System.out.println("Nhap catalog sản phẩm");
                int id = InputMethods.getInteger();
                for (Catalog au: catalogs) {
                    if(au.getCatalogId()==id){
                        product.setCatalog(au);
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
                System.err.println("Id not found");
            }
            System.out.println("Nhập trạng thái sản phẩm:");
            product.setStatus(InputMethods.getBoolean());
            products.add(product);
        }
    }

    public static void removeProduct(){
        System.out.println("Nhập mã sản phẩm: ");
        List<String> strings = new ArrayList<>();
        for (Product product : products) {
            strings.add(product.getProductId());
        }
        String input = InputMethods.getString();
        for (Product product : products) {
            if(product.getProductId().equals(input)) {
                products.remove(product);
                System.out.println("Xoa thanh cong");
                break;
            }
        }
    }

    // User
    public static void user(){
        byte choice = 0;
        while (choice != 7) {
            System.out.println("**************************MENU-USER**************************\n" +
                    "1. Xem danh sách sản phẩm\n" +
                    "2. Thêm vào giỏ hàng\n" +
                    "3. Xem tất cả sản phẩm giỏ hàng\n" +
                    "4. Thay đổi số lượng sản phẩm trong giỏ hàng\n" +
                    "5. Xóa 1 sản phẩm trong giỏ hàng\n" +
                    "6. Xóa toàn bộ sản phẩm trong giỏ hàng\n" +
                    "7. Quay lại");
            System.out.println("Nhập vào lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    showProduct();
                    break;
                case 2:
                    addCart();
                    break;
                case 3:
                    if(carts.isEmpty()){
                        System.err.println("Giỏ hàng không có sản phẩm");
                    } else {
                        System.out.println(carts);
                    }
                    break;
                case 4:
                    updateQuantity();
                    break;
                case 5:
                    removeCart();
                    break;
                case 6:
                    removeAll();
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 7");
            }
        }
    }

    public static void showProduct(){
        if(products.isEmpty()){
            System.err.println("Không có sản phẩm nào được bán");
        } else {
            System.out.println("Sản phẩm đang được bán: ");
            for(Product product : products){
                if(product.isStatus()){
                    System.out.println(product);
                }
            }
        }
    }

    public static void addCart(){
        System.out.println("Nhập vào id sản phẩm muốn thêm vào giỏ hàng: ");
        String input = InputMethods.getString();
        List<String > idProduct = new ArrayList<>();
        for (Product product : products) {
            if(product.isStatus()) {
                idProduct.add(product.getProductId());
            }
        }
        List<String> idCart = new ArrayList<>();
        for (CartItem cartItem : carts) {
            idCart.add(cartItem.getProduct().getProductId());
        }
        if(idProduct.contains(input) && !idCart.contains(input)) {
            CartItem cartItem = new CartItem();
            cartItem.setCartItemId(carts.size() + 1);
            for (Product product : products) {
                if (product.getProductId().equals(input) && product.getStock() > 0) {
                    cartItem.setProduct(product);
                    cartItem.setPrice(product.getProductPrice());
                    product.setStock(product.getStock() - 1);
                    break;
                } else if (product.getProductId().equals(input) && product.getStock() <= 0){
                    System.err.println("Sản phẩm hết hàng");
                    return;
                }
            }
            cartItem.setQuantity(1);
            carts.add(cartItem);
            System.out.println("thêm giỏ hàng thành công");
        } else if(idProduct.contains(input) && idCart.contains(input)){
            for (CartItem cartItem : carts) {
                if(cartItem.getProduct().getProductId().equals(input) && cartItem.getProduct().getStock() > 0) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItem.getProduct().setStock(cartItem.getProduct().getStock() - 1);
                } else if(cartItem.getProduct().getProductId().equals(input) && cartItem.getProduct().getStock() <= 0){
                    System.err.println("Sản phẩm hết hàng");
                    return;
                }
            }
            System.out.println("thêm giỏ hàng thành công");
        } else {
            System.err.println("id sản phẩm không hợp lệ");
        }
    }

    public static void updateQuantity(){
        System.out.println("Nhập id giỏ hàng");
        int id = InputMethods.getInteger();
        System.out.println("Nhập số lượng sản phâm");
        int qty = InputMethods.getInteger();
        for(CartItem cartItem: carts){
            if(cartItem.getCartItemId() == id && cartItem.getProduct().getStock() >= qty){
                cartItem.getProduct().setStock(cartItem.getProduct().getStock() - qty + cartItem.getQuantity());
                cartItem.setQuantity(qty);
            } else if(cartItem.getCartItemId() == id && cartItem.getProduct().getStock() < qty){
                System.err.println("Số lượng không đủ");
            }
        }
    }

    public static void removeCart(){
        System.out.println("Nhập id giỏ hàng");
        int id = InputMethods.getInteger();
        for(int i = 0; i < carts.size(); i++){
            if(carts.get(i).getCartItemId() == id){
                carts.get(i).getProduct().setStock(carts.get(i).getProduct().getStock() + carts.get(i).getQuantity());
                carts.remove(i);
                System.out.println("Xoá thành công");
                break;
            } else {
                System.err.println("ID không hợp lệ");
            }
        }
    }

    public static void removeAll(){
        for (CartItem cartItem : carts) {
            cartItem.getProduct().setStock(cartItem.getProduct().getStock() + cartItem.getQuantity());
        }
        carts.clear();
        System.out.println("Xoá sạch giỏ hàng thành công");
    }
}
