import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;

public class Bank {
	Account[] accs = new Account[100];
	int cnt;
	Scanner sc = new Scanner(System.in);
	
	int selectMenu() {
		System.out.println("[�ڽ�Ÿ ����]");
		System.out.println("1.���°���");
		System.out.println("2.�Ա�");
		System.out.println("3.���");
		System.out.println("4.������ȸ");
		System.out.println("5.��ü������ȸ");
		System.out.println("6.������ü");
		System.out.println("0.����");
		System.out.print("����>>");
		int sel = Integer.parseInt(sc.nextLine());
		return sel;
	}
	
	void selMakeAccount() {
		System.out.println("[���°���]");
		System.out.println("1.�Ϲݰ���");
		System.out.println("2.Ư������");
		System.out.print("����>>");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel==1) makeAccount();
		else if(sel==2) makeSpecialAccount();
	}
	
	void makeAccount() {
		System.out.println("[�Ϲݰ��°���]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = new Account(id,name,money);
		accs[cnt++] = acc;		
	}
	
	void makeSpecialAccount() {
		System.out.println("[Ư�����°���]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("���(VIP,Gold,Silver,Normal):");
		String grade =sc.nextLine();
		Account acc = new SpecialAccount(id,name,money,grade);
		accs[cnt++] = acc;		
	}

	Account searchAccById(String id) {
		Account acc = null;
		for(int i=0; i<cnt; i++) {
			if(accs[i].getId().equals(id)) {
				acc = accs[i];
				break;
			}
		}
		return acc;
	}
	
	void deposit() {
		System.out.println("[�Ա�]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		//���¸� accs���� ã�´�
		Account acc = searchAccById(id);
		if(acc==null) {
			System.out.println("���¹�ȣ�� Ʋ���ϴ�.");
			return;
		}
		System.out.print("�Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		acc.deposit(money);
	}
	
	void withdraw() {
		System.out.println("[���]");
		System.out.print("���¹�ȣ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if(acc==null) {
			System.out.println("���¹�ȣ�� Ʋ���ϴ�.");
			return;
		}
		System.out.print("��ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		acc.withdraw(money);
	}
	
	void accInfo() {
		System.out.println("[������ȸ]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if(acc==null) {
			System.out.println("���¹�ȣ�� Ʋ���ϴ�.");
			return;
		}
		System.out.println(acc);
	}
	
	void transfer() {
		System.out.println("[������ü]");
		System.out.print("������ ���¹�ȣ:");
		String sid = sc.nextLine();
		Account sacc = searchAccById(sid);
		if(sacc==null) {
			System.out.println("������ ���¹�ȣ�� Ʋ���ϴ�.");
			return;
		}
		System.out.print("�޴� ���¹�ȣ:");
		String rid = sc.nextLine();
		Account racc = searchAccById(rid);
		if(racc==null) {
			System.out.println("�޴� ���¹�ȣ�� Ʋ���ϴ�.");
			return;
		}
		System.out.print("��ü�ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		if(!sacc.withdraw(money)) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		racc.deposit(money);		
	}
	
	void allAccInfo() {
		System.out.println("[��ü������ȸ]");
		for(int i=0; i<cnt; i++) {
			System.out.println(accs[i]);
		}
	}
}
