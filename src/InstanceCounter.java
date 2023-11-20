public class InstanceCounter {
//    java modifiers public, protected, and private
//    static, final, abstract, synchronized and volatile
//    public gives access to all, protected gives to all, except classes outside the package, default
//    gives to all except classes outside package and subclasses outside the same package
//    private only works for access from the same class

    private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] args) {
        System.out.println("Starting with " + InstanceCounter.getCount() + " objects");
        for (int i = 0; i < 500; ++i) {
            new InstanceCounter();
        }
        System.out.println("Created " + InstanceCounter.getCount() + " objects");
    }
}
