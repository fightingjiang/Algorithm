package decorator;

public class CoffeeBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// װ����ģʽ�µĶ�����2���ɿ���+һ��ţ�̵�LongBlack

//		// 1. ��һ�� LongBlack
//		Drink order = new LongBlack();
//		System.out.println("����1=" + order.cost());
//		System.out.println("����=" + order.getDes());
//
//		// 2. order ����һ��ţ��
//		order = new Milk(order);
//
//		System.out.println("order ����һ��ţ�� ���� =" + order.cost());
//		System.out.println("order ����һ��ţ�� ���� = " + order.getDes());

		Drink order = new LongBlack();
		System.out.println("����1=" + order.cost());
		System.out.println("����=" + order.getDes());

		//��һ��ţ��
		order = new Milk(order);
		System.out.println("cost  "+order.cost());
		System.out.println("des   "+order.getDes());


	}

}
