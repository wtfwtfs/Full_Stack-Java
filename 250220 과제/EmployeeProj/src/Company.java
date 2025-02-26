import emp.Employee;
import emp.IBusinessTrip;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	Employee[] emps = new Employee[100];
	int cnt;
	
	void addEmployee(Employee emp) {
		emps[cnt++] = emp;
	}
	
	void allEmployeeInfo() {
		for(int i=0; i<cnt; i++) {
			System.out.println(emps[i]);
		}
	}
	
	int getAllTotalPay() {
		int total=0;
		for(int i=0; i<cnt; i++) {
			total += emps[i].getPay();
		}
		return total;
	}

	//�������� ������� ���� ����� �����ϴ�.
	//�������� �Ϸ�� 20������ �޿��� �����Ѵ�.
	//������� �ð��� 24�ð� �߰� �ٹ��� ���Խ�Ų��.
	public void regBusinessTrip(IBusinessTrip emp, int day) {
		emp.goBusinessTrip(day);
	}

	public static void main(String[] args) {
		Company com = new Company();
		Permanent per1=new Permanent("101","ȫ�浿",1800000);
		Sales sal1=new Sales("102","��浿",1000000,500000);
		PartTime pt1 =new PartTime("103","�ϱ浿",160,10000);
		com.addEmployee(per1);
		com.addEmployee(sal1);
		com.addEmployee(pt1);
		
		//com.regBusinessTrip(per1,2); //error
		com.regBusinessTrip(sal1,1); 
		com.regBusinessTrip(pt1,1); 
		
		com.allEmployeeInfo();
		System.out.println("������ �� �޿���:"+com.getAllTotalPay());
	}
}
//���:101,�̸�:ȫ�浿,�޿�:1800000
//���:102,�̸�:��浿,�޿�:1700000
//���:103,�̸�:�ϱ浿,�޿�:1840000
//������ �� �޿���:5340000
