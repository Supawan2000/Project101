package dessert;

public class TestDessert {
     public static void main(String[] args) {
        Dessert s = new Dessert("Strawberry pie", 150.9, 10);
        Dessert b = new Dessert("Banana Cake", 48.52, 6);
        System.out.println(s);
        System.out.println(s.equals(b));
        System.out.println(s.compare(b));

       DessertCollectionGroup fc = new DessertCollectionGroup(2);
        fc.addDessert("Chocolate", 85.179, 8);
        fc.addDessert("Custard", 94.62, 9);
        fc.expand(1);
        fc.addDessert("Pudding", 64.93, 7);
        for (int i = 0; i < fc.getCount(); i++) {
            System.out.println("No:" + i + " :: " + fc.getDessertAt(i));
        }
        int search = fc.searchForDessertName("Chocolate");
        if (search>=0) {
            System.out.println(fc.getDessertAt(search));
        }
    }
}
