package Bridge;


//�۵�ʽ�ֻ��࣬�̳� ������ Phone
public class FoldedPhone extends Phone {

	public FoldedPhone(Brand brand) {
		super(brand);
	}

	@Override
	protected void open() {
		System.out.println("FoldedPhone...");
		super.open();
	}

	@Override
	protected void close() {
		System.out.println("FoldedPhone...");
		super.close();
	}

	@Override
	protected void call() {
		System.out.println("FoldedPhone...");
		super.call();
	}
}
