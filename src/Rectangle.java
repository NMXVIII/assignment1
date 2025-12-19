public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen ;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++;
    }

    public Rectangle (double width , double height ) {
        this();
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width <= 0 ) {
            throw new IllegalArgumentException("Width must be positive. ");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0 ) {
            throw new IllegalArgumentException("Height must be positive. ");
        }
        this.height = height;
    }

    public int GetId(){
        return id;
    }

    public double area() {
        return width * height ;
    }

    public double perimeter() {
        return 2 * ( width + height );
    }
    @Override
    public String toString(){
        return "Rectangle [ID : " + id + ", Width : " + width + ", Height : " + height + "]";
    }
}

