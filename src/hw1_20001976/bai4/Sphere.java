package hw1_20001976.bai4;

public class Sphere {
    private double centerX;
    private double centerY;
    private double centerZ;
    private double radius;

    public Sphere(double centerX, double centerY, double centerZ, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        if (radius <= 0) throw new NumberFormatException("Ban kinh phai lon hon 0");
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getCenterZ() {
        return centerZ;
    }

    public void setCenterZ(double centerZ) {
        this.centerZ = centerZ;
    }

    public double getRadius() {
        if (radius <= 0) throw new NumberFormatException("Ban kinh phai lon hon 0");
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "(" + centerX +
                ", " + centerY +
                ", " + centerZ +
                "), radius=" + radius +
                '}';
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double getVolume() {
        return 4 * Math.PI * radius * radius * radius / 3;
    }

    public String getPositionWith(Sphere sphere) {
        double distance = Math.sqrt((centerX - sphere.centerX) * (centerX - sphere.centerX)
                + (centerY - sphere.centerY) * (centerY - sphere.centerY)
                + (centerZ - sphere.centerZ) * (centerZ - sphere.centerZ));
        System.out.println(distance);
        if (distance > radius + sphere.radius) {
            return "Khong tiep xuc";
        } else if (distance == radius + sphere.radius) {
            return "Tiep xuc ngoai";
        } else if (distance < radius + sphere.radius && distance > Math.abs(radius - sphere.radius)) {
            return "2 cau giao nhau";
        } else if (distance == Math.abs(radius - sphere.radius)) {
            if (radius > sphere.radius) {
                return "ben trong va tiep xuc";
            } else if (radius < sphere.radius) {
                return "tiep xuc trong";
            } else
                return "Hai cau dong tam";
        } else if (distance < Math.abs(radius - sphere.radius)) {
            if (radius > sphere.radius) {
                return "bao ben ngoai";
            } else if (radius < sphere.radius) {
                return "o ben trong";
            }
        }
        return "khong ro vi tri";
    }
}
