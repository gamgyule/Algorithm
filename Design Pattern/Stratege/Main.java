class Main {
    public static void main(String[] args) {
        
        Car car = new Car(new UpBehavior());
        car.move();
    }

}