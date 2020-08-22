import java.util.*;
public class b1380{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        while (tests-- > 0){
            String seq = in.next();
            HashMap<Character, Integer> freq = new HashMap<>();
            for (int i = 0 ; i < seq.length(); i++){
                if (seq.charAt(i) == 'R'){
                    freq.put('R', freq.getOrDefault('R',0) + 1);
                } else if (seq.charAt(i) == 'S'){
                    freq.put('S', freq.getOrDefault('S',0) + 1);
                } else {
                    freq.put('P', freq.getOrDefault('P',0) + 1);
                }
            }
            int max = 0;
            char maxC = 'X';
            for (char c : freq.keySet()){
                if (freq.get(c) >  max){
                    max = freq.get(c);
                    maxC = c;
                }
            }
            if (maxC == 'R'){
                maxC = 'P';
            } else if (maxC == 'P'){
                maxC = 'S';
            } else {
                maxC = 'R';
            }
            for (int i = 0 ; i < seq.length(); i++){
                System.out.print(maxC);
            }
            System.out.println();
        }
        in.close();
    }
    private static void eval(){
        
    }
}