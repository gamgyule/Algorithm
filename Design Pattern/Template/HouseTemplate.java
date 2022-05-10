public abstract class HouseTemplate {
    // final 선언으로 Override 방지
    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }

    private void buildWindows(){
        System.out.println("Building glass Windows");
    }

    public abstract void buildWalls();
    public abstract void buildPillars();

    private void buildFoundation(){
        System.out.println("Building foundation with cement, orin rods and sand");
    }
}
