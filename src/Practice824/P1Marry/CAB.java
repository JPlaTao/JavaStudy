package Practice824.P1Marry;

public class CAB {

    public static boolean canMarry(Person p1,Person p2){
        return p1.getAge() >= 22
                && p1.getGender().equals('男') && p2.getGender().equals('女')
                || p1.getGender().equals('女') && p2.getGender().equals('男')
                && !p1.isMarried()
                && p2.getAge() >= 20
                && !p2.isMarried();
    }
}
