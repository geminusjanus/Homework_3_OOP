import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopMain {
    public static void main(String[] args) {

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Food("Pizza", 800, "01.06.2023", 2));
        productList.add(new Food("Bread", 100, "05.06.2023", 2));
        productList.add(new Drink("Juice", 120, 0.5, "05.06.2023", 2));
        System.out.println("Без сортировки");
        for (Product p:productList) {
            System.out.println(p.toString());
        }

        System.out.println("Сортировка по имени(имплементация Comparable)");
        Collections.sort(productList);
        for (Product p:productList) {
            System.out.println(p.toString());
        }

        ArrayList<Product> sortedByPrice = sortedProductList(productList, "price");
        for (Product p:sortedByPrice) {
            System.out.println(p.toString());
        }

        ArrayList<Product> sortedByPriceRev = sortedProductList(productList, "priceReverse");
        for (Product p:sortedByPriceRev) {
            System.out.println(p.toString());
        }

        ArrayList<Product> sortedByPrDate = sortedProductList(productList, "prodDate");
        for (Product p:sortedByPrDate) {
            System.out.println(p.toString());
        }

        ArrayList<Product> sortedByPrDateRev = sortedProductList(productList, "prodDateRev");
        for (Product p:sortedByPrDateRev) {
            System.out.println(p.toString());
        }


    }

    static ArrayList<Product> sortedProductList(ArrayList<Product> products, String sortBy){
        switch (sortBy){
            case "price":
                System.out.println("Сортировка по цене(Comparator)");
                Comparator<Product> priceComparator = new ProductPriceComparator();
                products.sort(priceComparator);
                break;

            case "priceReverse":
                System.out.println("Сортировка по цене(Comparator) reversed");
                Comparator<Product> priceRevComparator = new ProductPriceComparator();
                products.sort(priceRevComparator.reversed());
                break;

            case "prodDate":
                System.out.println("Сортировка по дате производства(Comparator)");
                Comparator<Product> prDateComparator = new FoodProduceDateComparator();
                products.sort(prDateComparator);
                break;

            case "prodDateRev":
                System.out.println("Сортировка по дате производства(Comparator) reversed");
                Comparator<Product> prDateRevComparator = new FoodProduceDateComparator();
                products.sort(prDateRevComparator.reversed());
                break;
        }

        return products;
    }
}