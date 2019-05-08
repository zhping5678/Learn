package bishi;

import java.util.*;

/*
小明是一个数学家，他喜欢用数字给事物命名编号，他给自己编号为1，同时在2019年小明开办了一个农场，准备开始养母猪，他专门给农场的母猪用以下数列
2，3，4，5，7，9，12，16，21，28，37，49，65，86，114，151...进行命名。假设农场的母猪永远不会死，小母猪出生后3年后成熟，
成熟后从第三年开始每年只会生一只小母猪。第一年农场，有一只刚刚出生的小母猪和一只成熟的母猪(本年不再生小猪，下一年开始生小猪)，
并给他们编号为2和3。请问，第m只母猪编号为多少？其是哪一年出生的？小明还准备了1份礼物，专门颁给农场第1到m只的母猪颁奖，
颁奖规则如下:选出第1到m只的母猪翻转编号(114编号翻转为411)为第k大的母猪进行颁奖，请问是第几只猪获奖？提示: f(n)=f(n-2)+f(n-3)
*/
public class CountPig {

    static String calculate(int m, int k) {
        int m_id=0;
        int year=2019;

        Map<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> integers=new ArrayList<>();
        if(m==1){
            m_id=2;
        }else
        if(m==2){
            m_id=3;
        }else
        if(m==3){
            m_id=4;
            year++;
        }
        else{
            int f1=2,f2=3,f3=4;
            int temp;
            for(int i=4;i<=m;i++){
                m_id=f1+f2;
                f1=f2;
                f2=f3;
                f3=m_id;
                temp=reverseK(m_id);
                map.put(i,temp);
                integers.add(temp);
            }
        }
        map.put(1,2);
        integers.add(2);
        map.put(2,3);
        integers.add(3);
        map.put(3,4);
        integers.add(4);

        Collections.sort(integers);
        int win_id=integers.get(m-k-1);
        for(int i:integers){
            System.out.print(i+" ");
        }
        int win=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==win_id){
                win=entry.getKey();
            }
        }
        return m_id+","+year+","+win;
    }

    static int reverseK(int k){
        String s=String.valueOf(k);
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            stringBuffer.append(s.charAt(i));
        }
        return Integer.valueOf(stringBuffer.toString());
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        System.out.println(calculate(m, k));

    }
}
