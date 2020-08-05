import java.util.*;
public class c1380{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            int x = in.nextInt();
            ArrayList<Integer>skills = new ArrayList<>();
            for (int j = 0 ; j < n; j++){
                skills.add(in.nextInt());
            }
            System.out.println(eval(skills, x));
        }
        in.close();
    }
    private static int eval(ArrayList<Integer> skills, int x){
        int teams = 0;
        for (int i = skills.size() - 1 ; i >= 0; i--){
            if (skills.get(i) >= x){
                teams++;
                skills.remove(i);
            }
        }
        if (skills.size() > 0){
            Collections.sort(skills);
            int curSize = 0;
            for (int i = skills.size() - 1; i >= 0; i--){
                curSize++;
                if (skills.get(i)*curSize >= x){
                    teams++;
                    curSize = 0;
                }
            }
        }


        return teams;
    }
}