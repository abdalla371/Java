void main() {
    student s1=new student(6);
    try {
        s1.registerCourse("CA244");
    }
    catch (CourseFullException e){
        System.out.println(e.getMessage()+"; Limit is equal to: "+e.getLimit());
    }
}public class CourseFullException extends Exception{
    private int limit;
    CourseFullException(String message,int limit){
        super(message);
        this.limit=limit;
    }

    public int getLimit() {
        return limit;
    }



}
public class  student{
    int course;
    public student(int course){
        this.course=course;
    }
    public void registerCourse(String code) throws CourseFullException{
        if(course>=6)throw new CourseFullException("Maximum courses is 6: ",6);
        else course++;
    }
        }