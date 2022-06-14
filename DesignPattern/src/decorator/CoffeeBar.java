package decorator;

public class CoffeeBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

//		// 1. 点一份 LongBlack
//		Drink order = new LongBlack();
//		System.out.println("费用1=" + order.cost());
//		System.out.println("描述=" + order.getDes());
//
//		// 2. order 加入一份牛奶
//		order = new Milk(order);
//
//		System.out.println("order 加入一份牛奶 费用 =" + order.cost());
//		System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

		Drink order = new LongBlack();
		System.out.println("费用1=" + order.cost());
		System.out.println("描述=" + order.getDes());

		//加一份牛奶
		order = new Milk(order);
		System.out.println("cost  "+order.cost());
		System.out.println("des   "+order.getDes());


	}

}
