package HomeTasks.SideClasses;

public class DaysOfWeekExample implements DayInfo{
    DayOfWeek ex = DayOfWeek.FRIDAY;
    @Override
    public void printInfo() {
        System.out.println(ex);
    }
}
