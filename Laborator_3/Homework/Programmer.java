package laborator_3.homework;

public class Programmer extends Person{
    private int yearsOfExperience;

    public Programmer(String name, int dayOfBirth, int monthOfBirth, int yearOfBirth, int yearsOfExperience) {
        super(name, dayOfBirth, monthOfBirth, yearOfBirth);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience(){
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return super.toString() + ". He/She is a Programmer with " + yearsOfExperience + " years of experience.";
    }
}
