import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            Coordinate[] points = new Coordinate[4];
            for(int i=0; i<4; i++) {
                points[i] = new Coordinate(scanner.nextDouble(),scanner.nextDouble());
            }
            sortPoints(points);
            System.out.println(solution(points));
        }
    }

    public static double distance(Coordinate a, Coordinate b) {
        return Math.sqrt((Math.pow(a.x - b.x, 2)) + (Math.pow(a.y - b.y, 2)));
    }

    public static double slope(Coordinate a, Coordinate b) {
        return (a.y - b.y) / ((a.x - b.x) * (1.0));
    }

    public static void sortPoints(Coordinate[] points) {
        // tasneem taught me the concept
        for (int i=0; i<3; i++) {
            for (int j=0; j<3-i; j++) {
                if (points[j+1].x < points[j].x) {
                    Coordinate temp = points[j+1];
                    points[j+1] = points[j];
                    points[j] = temp;
                } else if (points[j+1].x == points[j].x) {
                    if (points[j+1].y < points[j].y) {
                        Coordinate temp = points[j+1];
                        points[j+1] = points[j];
                        points[j] = temp;
                    }
                }
            }
        }
    }

    public static String solution(Coordinate[] points ) {
        double d12 = distance(points[0],points[1]);
        double d13 = distance(points[0],points[2]);
        double d14 = distance(points[0],points[3]);
        double d23 = distance(points[1],points[2]);
        double d24 = distance(points[1],points[3]);
        double d34 = distance(points[2],points[3]);

        double s12 = slope(points[0],points[1]);
        double s13 = slope(points[0],points[2]);
        double s14 = slope(points[0],points[3]);
        double s23 = slope(points[1],points[2]);
        double s24 = slope(points[1],points[3]);
        double s34 = slope(points[2],points[3]);

        if(d12 == d13){
            if(d14 == d23) return "Square";
            else return "Rhombus";
        }
        else if (d12 == d34 && d13 == d24 && s12 == s34 && s13 == s24){
            if(d14 == d23) return "Rectangle";
            else return "Parallelogram";
        }
        else if (s12 == s34 || s13 == s24 || s14 == s23 ) {
            return "Trapezium";
        }
        else return "Ordinary Quadrilateral";
    }
}

class Coordinate {
    double x, y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
