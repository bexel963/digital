package day1;

public class ���ڿ� {

	public static void main(String[] args) {
		//���ڴ� 1����, ���ڿ��� 0���� �̻�
		// ���ڴ� �����ڵ�ǥ�� �ִ� ���� ���� ����ȴ�.
		char ch = 'A';
		System.out.println((int)ch);	//���� A�� ���� �����ڵ� ���� ���
		ch = '��';
		System.out.println((int)ch);	//���� '��'�� ���� �����ڵ� ���� ���
		ch = (char)66;
		System.out.println(ch);			//66�� ��ġ�ϴ� �����ڵ� ���ڰ� ���
		System.out.println("------------------------------------");
		//���ڿ��� �����ϱ� ���� Ŭ���� string
		//���ڿ��� ''�� �ƴ� ""�� �̿�
		String str = "";
		System.out.println("���ڿ�: " + str);
		str = "�ȳ��ϼ���";
		System.out.println("���ڿ�: " + str);

	}

}
