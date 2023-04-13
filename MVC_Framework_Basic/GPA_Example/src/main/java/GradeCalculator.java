import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        //(학점수+교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;
        for (Course course:courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        //수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
            .mapToInt(Course::getCredit)
            .sum();

        return multipliedCreditAndCourseGrade/totalCompletedCredit;
    }
}
