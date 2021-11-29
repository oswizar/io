
package com.oswizar.innerclass;

public class PrintTest {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Circle.Draw draw = circle.new Draw();
        draw.drawSahpe();
    }
}

class Circle {
    double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println("drawshape and 参数radius=" + radius);
        }
    }
}
