package exercise;

// BEGIN
public final class Segment {
    public final Point BEGIN_POINT;
    public final Point MID_POINT;
    public final Point END_POINT;

    public Segment(Point beginPoint, Point endPoint) {
        BEGIN_POINT = beginPoint;
        MID_POINT = calculateMidPoint(beginPoint, endPoint);
        END_POINT = endPoint;
    }

    public Point getBeginPoint() {
        return BEGIN_POINT;
    }

    public Point getMidPoint() {
        return MID_POINT;
    }

    public Point getEndPoint() {
        return END_POINT;
    }

    private Point calculateMidPoint(Point beginPoint, Point endPoint) {
        int newX = (beginPoint.getX() + endPoint.getX()) / 2;
        int newY = (beginPoint.getY() + endPoint.getY()) / 2;

        return new Point(newX, newY);
    }
}
// END
