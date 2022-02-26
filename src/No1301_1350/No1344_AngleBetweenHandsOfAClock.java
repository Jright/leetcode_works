package No1301_1350;

public class No1344_AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double circleAngle = 360.0;
        double hourAngle = 30.0;
        double m = 60.0;
        double h = 12.0;
        double limit = 180.0;
        double toZero = 1.0;
        double zero = 0.0;

        double mOffset = circleAngle * (minutes / m == toZero ? zero : minutes / m);
        double hOffset = circleAngle * (hour / h == toZero ? zero : hour / h) + (minutes / m * hourAngle);

        double res = Math.abs(mOffset - hOffset);
        if(res > limit){
            res = circleAngle - res;
        }
        return res;
    }
}
