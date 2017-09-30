package com.chenyee.common.utils;

public class ShutdownHook {
	
	public static void main(String[]  args){
		new Thread(){
			@Override
			public void run() {
				System.out.println("执行普通线程 start");
		    	try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	System.out.println("执行普通线程 end");
			}
		}.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		    	System.out.println("执行  addShutdownHook 退出线程 start");
		    	try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	System.out.println("执行  addShutdownHook 退出线程 end");
		    }
		});
		Runtime.getRuntime().exit(0);
	}
}	
