package acc;

public class SpecialAccount extends Account {
	String grade;
	public SpecialAccount(String id,String name,int money,String grade) {
		super(id,name,money);
		this.grade=grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString()+",���:"+getGrade();
	}
	
	@Override
	public boolean deposit(int money) {
		int inmoney = money;
		switch(grade.toUpperCase()) {
		case "VIP": inmoney += (int)(inmoney*0.04); break;
		case "GOLD": inmoney += (int)(inmoney*0.03); break;
		case "SILVER": inmoney += (int)(inmoney*0.02); break;
		case "NORMAL": inmoney += (int)(inmoney*0.01); break;
		}
		return super.deposit(inmoney);
	}

//	public static void main(String[] args) {
//		Account sacc1 = new SpecialAccount("10001","ȫ�浿",100000,"VIP");
//		Account sacc2 = new SpecialAccount("10002","��浿",200000,"Gold");
//		Account sacc3 = new SpecialAccount("10003","�ڱ浿",300000,"Silver");
//		Account sacc4 = new SpecialAccount("10004","�ϱ浿",400000,"Normal");
//		
//		System.out.println(sacc1);
//		System.out.println(sacc2);
//		System.out.println(sacc3);
//		System.out.println(sacc4);
//	}
}
//���¹�ȣ:10001,�̸�:ȫ�浿,�ܾ�:100000,���:VIP
//���¹�ȣ:10002,�̸�:��浿,�ܾ�:200000,���:Gold
//���¹�ȣ:10003,�̸�:�ڱ浿,�ܾ�:300000,���:Silver
//���¹�ȣ:10004,�̸�:�ϱ浿,�ܾ�:400000,���:Normal


