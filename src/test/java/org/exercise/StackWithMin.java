package org.exercise;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/14.
 *
 * 最小栈的实现--利用辅助栈结构来实现存储转移  每次栈里面最小的元素的下标
 */
public class StackWithMin<E extends Comparable> extends Stack<E>
{
    Stack<E> stackAssitance;
   public StackWithMin(){
        stackAssitance=new Stack();//完成辅助栈的初始化操作
    }
    @Override
    public E push(E item) {
        if (isEmpty()) {
            stackAssitance.push(item);
        }
        if (min()!=null) {
            if(item.compareTo(min())<0){
                //原来的最小成为备胎 有了新的最小
                stackAssitance.push(item);
            }
        }


        //维持最小栈结构不变---直接push新进来的元素
        return super.push(item);
    }

    /**
     *   用于记录每次更新状态后栈里面最小节点的下标
     * @return
     */
    public  E min() {
        if(stackAssitance.isEmpty()){
            return null;
        }
        else return stackAssitance.peek();//返回栈顶元素
    }
    //直接弹栈结构 同时 更新辅助栈结构
    @Override
    public synchronized E pop() {
        E item=super.pop();
        if(item.equals(min()))
        {
            stackAssitance.pop();
        }
        return item;
    }
    @Test
    public void setStackAssitance(){
            StackWithMin<Integer> ss=new StackWithMin<Integer>();
            ss.push(3);
            ss.push(6);
            ss.push(4);

       Integer s=     ss.pop();
       Integer s2=ss.min();
        System.out.println("");
    }
}
