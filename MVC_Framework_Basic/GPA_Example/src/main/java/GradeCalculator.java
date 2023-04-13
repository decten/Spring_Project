import java.util.List;

public class GradeCalculator {
    //1급 컬렉션 변수 생성
    private final Courses courses;
    //매개변수는 테스트 하려는 클래스
    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    // 1급 컬렉션으로 처음부터 받기
    public GradeCalculator(Courses courses){
        this.courses = courses;
    }

    public double calculateGrade() {
        //(학점수+교과목 평점)의 합계
        double totalmultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        //수강신청 총 학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalmultipliedCreditAndCourseGrade/totalCompletedCredit;
    }
}
