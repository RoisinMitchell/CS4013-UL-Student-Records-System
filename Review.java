public interface Review {

    public boolean determineStudentProgression(Transcript transcript);

    public String getAwardType(Student student);

    public String determineRepeatStatus(Transcript transcript);
}
