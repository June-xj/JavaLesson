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
		System.out.println("1.ֱ�ӿ�ʼ��һ��\n2.��ʾ���\n3.�ۼƷ���(һ����5��)\n4.����");
		System.out.println("���������ѡ��");
	}
	public static String compare(double result){
		System.out.println("����������");
		Scanner scan=new Scanner(System.in);
		double scan1=scan.nextDouble();
		if(result==scan1){
			flag=true;
			score=score+5;
			return "��ϲ������ˣ�";
		}else{
			flag=false;
			return "���ź��������ˣ�";
		}
	}
	public static void main(String[] args) {
		
		c = Calendar.getInstance();
		endTime = c.getTimeInMillis()+10000;
		date = new Date();
		startTime = date.getTime();
		midTime = (endTime - startTime) / 1000;
		
		
		System.out.println("��ѡ��Ҫ������ɵ��㷨��");
		System.out.println("1.�ӷ�\t2.����\t3.�˷�\t4.����\t");
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
			System.out.println("�����������¿�ʼ��");
			main(null);
			break;
		}
		sc1=new Scanner(System.in);
		int s1=sc1.nextInt();
		switch(s1){
		case 2:
			System.out.println("����Ľ����"+result);
			main(null);
			break;
		case 1:
			main(null);
			break;
		case 3:
			System.out.println("��ǰ�ܷ�����"+score);
			main(null);
			break;
		case 4:
			System.out.println("��ǰ�ܷ�����"+score);
			System.out.println("лл���룡");
			break;
		default:
			System.out.println("�����������¿�ʼ��\n");
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
					System.out.println("�Բ���ʱ�䵽��");
					main(null);
				}
				System.out.println("��ʣ"+ ss + "��");
				}
			}, 0, 1000);
		//���������ֹͣ�������,�����һֱѭ��ִ�д�����     
		while(true){
            try{     
                Integer in = System.in.read();    
                if(in != null){     
                    timer.cancel();//ʹ����������˳�����     
                    break;  
                }     
            } catch (IOException e){     
                // TODO Auto-generated catch block     
                e.printStackTrace();     
            }     
        }
	}
}