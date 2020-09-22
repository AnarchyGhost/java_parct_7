package com.company;

import java.util.Stack;

public class Play {
    public int playing(Stack<Integer> p1Cards, Stack<Integer> p2Cards){
        int steps=0;
        Integer hlp;
        Stack<Integer> tmp=new Stack<>();
        while(!p1Cards.empty()&&!p2Cards.empty()&&steps!=106){
            if((p1Cards.peek()>p2Cards.peek()&&!(p1Cards.peek()==0&&p2Cards.peek()==9))||(p1Cards.peek()==0&&p2Cards.peek()==9)){
                hlp=p1Cards.pop();
                while(!p1Cards.empty()) tmp.add(p1Cards.pop());
                p1Cards.add(p2Cards.pop());
                p1Cards.add(hlp);
                while (!tmp.empty()) p1Cards.add(tmp.pop());
            }else{
                hlp=p2Cards.pop();
                while(!p2Cards.empty()) tmp.add(p2Cards.pop());
                p2Cards.add(p1Cards.pop());
                p2Cards.add(hlp);
                while (!tmp.empty()) p2Cards.add(tmp.pop());
            }
            steps++;
        }
        if(p1Cards.empty())return steps*10+2;
        if(p2Cards.empty())return steps*10+1;
        return 1060;
    }
}
