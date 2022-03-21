package core.lesson1;

public class Course {
    private int distanceOfRun;
    private int heightOfJump;

    Course(int distanceOfRun, int heightOfJump){
        this.distanceOfRun = distanceOfRun;
        this.heightOfJump = heightOfJump;
    }

    public void doIt (Team team){
        for (int i = 0; i < team.getCountMembers(); i++){
            if (distanceOfRun <= team.getMemberMaxDistanceOfRun()[i] && heightOfJump <= team.getMemberMaxDistanceOfJump()[i]){
                team.resultMember(i, true);
            } else team.resultMember(i, false);
        }
    }
}
