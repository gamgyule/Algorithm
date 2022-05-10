class Main {
    public static void main(String[] args) {
        HouseTemplate houseType = new WoodenHouse();

        houseType.buildHouse();

        System.out.println("\n-------------");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }

}