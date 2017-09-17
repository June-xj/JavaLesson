package pro1;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class EleArithmetic {
	public static boolean flag;
	public static int score=0;
	
	public static int time = 60 * 60 * 60;
	public static Calendar c;
	public static long endTime;
	public static Date date;
	public static long startTime;
	public static long midTime;
	private static Scanner sc1=null;
	
	
	public static void show_main(){
		System.out.println("1.直接开始下一题\n2.显示结果\n3.累计分数(一道题5分)\n4.结束");
		System.out.println("请输入你的选择：");
	}
	public static String compare(double result){
		System.out.println("请输入结果：");
		Scanner scan=new Scanner(System.in);
		double scan1=scan.nextDouble();
		if(result==scan1){
			flag=true;
			score=score+5;
			return "恭喜你算对了！";
		}else{
			flag=false;
			return "很遗憾，你答错了！";
		}
	}
	public static void main(String[] args) {
		
		c = Calendar.getInstance();
		endTime = c.getTimeInMillis()+10000;
		date = new Date();
		startTime = date.getTime();
		midTime = (endTime - startTime) / 1000;
		
		
		System.out.println("请选择要随机生成的算法：");
		System.out.println("1.加法\t2.减法\t3.乘法\t4.除法\t");
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		double result=0;
		Random r=new Random();
		int a=r.nextInt(100);
		int b=r.nextInt(100);
		while(b==0){
			b=r.nextInt(100);
		}
		switch(s){
		case 1:
			System.out.println(a+"+"+b+"=?");
			time();
			result=a+b;
			System.out.println(compare(result));
			show_main();
			break;
		case 2:
			System.out.println(a+"-"+b+"=?");
			time();
			result=a-b;
			System.out.println(compare(result));
			show_main();
			break;
		case 3:
			System.out.println(a+"*"+b+"=?");
			time();
			result=a*b;
			System.out.println(compare(result));
			show_main();
			break;
		case 4:
			System.out.println(a+"/"+b+"=?");
			time();
			float c=a;
			float d=b;
			result=c/d;
			System.out.println(compare(result));
			show_main();
			break;
		default:
			System.out.println("输入有误，重新开始！");
			main(null);
			break;
		}
		sc1=new Scanner(System.in);
		int s1=sc1.nextInt();
		switch(s1){
		case 2:
			System.out.println("本题的结果："+result);
			main(null);
			break;
		case 1:
			main(null);
			break;
		case 3:
			System.out.println("当前总分数："+score);
			main(null);
			break;
		case 4:
			System.out.println("当前总分数："+score);
			System.out.println("谢谢参与！");
			break;
		default:
			System.out.println("输入有误，重新开始！\n");
			main(null);
			break;
		}
		
	}
	private static void time() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				midTime--;
				long ss = midTime % 60;
				if(ss==0){
					System.out.println("对不起，时间到！");
					main(null);
				}
				System.out.println("还剩"+ ss + "秒");
				}
			}, 0, 1000);
		//这个是用来停止此任务的,否则就一直循环执行此任务     
		while(true){
            try{     
                Integer in = System.in.read();    
                if(in != null){     
                    timer.cancel();//使用这个方法退出任务     
                    break;  
                }     
            } catch (IOException e){     
                // TODO Auto-generated catch block     
                e.printStackTrace();     
            }     
        }
	}
}
