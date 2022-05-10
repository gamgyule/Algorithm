public class Instance {

    private Instance(){}
    private static class InnerInstanceClass{
        private static final Instance instance = new Instance();
    }

    public static Instance getInstance(){
        return InnerInstanceClass.instance;
    }

    public void say(){
        System.out.println("Hello, World");
    }


}
