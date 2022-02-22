package hw1_20001976_PhamBaThang.bai4;

public class Test {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(1, 1, 1, 4);
        System.out.println(sphere + ", surface area: " + sphere.getSurfaceArea() + ", volume: " + sphere.getVolume());
        System.out.println(sphere.getPositionWith(new Sphere(3, 7, 8, 5.433981132056603)));
    }
}
