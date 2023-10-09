package problems.company.tesla;

// https://leetcode.com/problems/maximum-value-after-insertion/

public class D {

    public String maxValue(String n, int x) {
        char c=n.charAt(0);
        if(c!='-'){
            for(int i=0;i<n.length();i++){
                c=n.charAt(i);
                int num=c-48;
                if(num<x)
                    return n.substring(0,i) + x + n.substring(i);
            }
        }else{
            for(int i=0;i<n.length();i++){
                c=n.charAt(i);
                int num=c-48;
                if(num>x)
                    return n.substring(0,i) + x + n.substring(i);
            }
        }
        return n+x;
    }

    public static void main(String[] args) {
        System.out.println(new D().maxValue("99", 9));
    }

}
