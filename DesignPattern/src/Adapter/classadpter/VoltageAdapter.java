package Adapter;

import Adapter.classadpter.IVoltage5V;
import Adapter.classadpter.Voltage220V;

//��������
public class VoltageAdapter extends Voltage220V implements IVoltage5V{


	@Override
	public int output5V() {
		int srcV = output220V();
		int dstV = srcV / 44 ; //ת�� 5v
		return dstV;
	}
}
