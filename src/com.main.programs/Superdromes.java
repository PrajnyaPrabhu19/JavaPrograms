import java.io.*;
import java.util.*;
import java.lang.*;


public class Superdromes {

    public static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println("n::"+n);
            int out_ = solve(n);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    public static int checkPal(String s){
        int l = s.length()-1;
        int i=0;
        while(i<l){
            if(s.charAt(i)==s.charAt(l)){
                i++; l--;
            }
            else{
                return 0;
            }
        }
        return 1;
    }

    static int solve(int n){
        // Write your code here
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            if(n==1){
                map.put(n,1);
            }
            for(int i =2;i<=n;i++){
                if(!map.containsKey(i)){
                    int p = checkPal(Integer.toBinaryString(i));
                    map.put(i, p+map.get(i-1));
                }
            }
            return map.get(n);
        }
    }
}