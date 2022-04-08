package core.lesson1;

import java.util.Arrays;

public class Team {
    private int countMembers;
    private String nameTeam;
    private Human[] memberTeam;
    private String[] nameTeamMember;
    private int[] memberMaxDistanceOfRun;
    private int[] memberMaxDistanceOfJump;
    private boolean[] result;


    public Team(String nameTeam, int countMembers, Human[] memberTeam) {
        this.nameTeam = nameTeam;
        this.nameTeamMember = new String[countMembers];
        for (int i = 0; i < countMembers; i++) {
            this.nameTeamMember[i] = memberTeam[i].getName();
        }

        this.memberMaxDistanceOfRun = new int[countMembers];
        for (int i = 0; i < countMembers; i++) {
            this.memberMaxDistanceOfRun[i] = memberTeam[i].getMaxDistanceOfRun();
        }

        this.memberMaxDistanceOfJump = new int[countMembers];
        for (int i = 0; i < countMembers; i++) {
            this.memberMaxDistanceOfJump[i] = memberTeam[i].getMaxDistanceOfJump();
        }
        this.countMembers = countMembers;
        this.result = new boolean[countMembers];
        for (int i = 0; i < countMembers; i++) {
            this.result[i] = false;
        }
    }

    @Override
    public String toString() {
        return "Команда: " + nameTeam + "\n" + "Члены команды: " + Arrays.toString(nameTeamMember) + "\n" +
                "Максимальная дистанция, которую пробегаю члены команды: " + Arrays.toString(memberMaxDistanceOfRun) + "\n" +
                "Максимальная высота, которую берут члены команды: " + Arrays.toString(memberMaxDistanceOfJump) + "\n";
    }

    public int getCountMembers() {
        return countMembers;
    }

    public int[] getMemberMaxDistanceOfRun() {
        return memberMaxDistanceOfRun;
    }

    public int[] getMemberMaxDistanceOfJump() {
        return memberMaxDistanceOfJump;
    }

    public String[] getNameTeamMember() {
        return nameTeamMember;
    }

    public void resultMember(int i, boolean result) {
        this.result[i] = result;
    }

    public void showResults() {
        for (int i = 0; i < countMembers; i++) {
            if (result[i] == true) {
                System.out.printf(nameTeamMember[i] + " прошел(-а) дистанцию" + "\n");
            } else System.out.printf(nameTeamMember[i] + " НЕ прошел(-а) дистанцию" + "\n");
        }
        System.out.printf("Команда закончила проходить дистанцию" + "\n\n");
    }
}
