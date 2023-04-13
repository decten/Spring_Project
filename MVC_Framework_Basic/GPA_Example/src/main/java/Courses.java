import java.util.List;

public class Courses {
    private final List<Course> courses; // 이것 외에 다른 변수 가지면 안 된다
    /*Course 리스트와 관련된 것들은 모두 여기서 처리한다*/
    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndCourseGrade = 0;
        for (Course course:courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
            .mapToInt(Course::getCredit)
            .sum();
    }
}
