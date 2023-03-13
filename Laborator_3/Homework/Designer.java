package laborator_3.homework;

public class Designer extends Person{
    private int numbersOfProjects;

    public Designer(String name, int dayOfBirth, int monthOfBirth, int yearOfBirth, int numbersOfProjects) {
        super(name, dayOfBirth, monthOfBirth, yearOfBirth);
        this.numbersOfProjects = numbersOfProjects;
    }

    public int getNumbersOfProjects(){
        return this.numbersOfProjects;
    }

    @Override
    public String toString() {
        return super.toString() + ". He/She is a Designer who has worked on " + numbersOfProjects + " projects.";
    }
}
