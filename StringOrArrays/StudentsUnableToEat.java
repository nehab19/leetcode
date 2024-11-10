package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class StudentsUnableToEat {
    public static int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        int [] array=new int[2];
        //array[0] will have students who like 0 sandwitch
        //array[1] will have students who like 1 sandwitch
        for(int x: students){
            array[x]++;
        }
        for(int i=0;i<n;i++){
            int sandwitch=sandwiches[i];
            //to get the array if that sandwitch is available or not
            if(array[sandwitch]==0){
                return n-i;
            }
            array[sandwitch]--;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,0,0},new int[]{0,1,0,1}));
    }
}
