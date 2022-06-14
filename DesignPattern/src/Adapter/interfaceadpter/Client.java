package Adapter.interfaceadpter;

import java.sql.SQLOutput;

public class Client {
	public static void main(String[] args) {

		AbsAdapter absAdapter = new AbsAdapter(){
			@Override
			public void m1() {
				System.out.println("use the m1 method");
			}
		};
		absAdapter.m1();
	}
}
