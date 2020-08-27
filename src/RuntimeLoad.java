
interface Printerface{
	public void print();
}

//내 컨트롤러 수행되기 전에 한번 돌고 나서
public class RuntimeLoad {
	public static void main(String[] args) {
		CosContainer c = new CosContainer();	
		
		Money m = c.invokeAnnotation(new Money());
		try {
			int money = m.minus();
			System.out.println("남은 금액은 : "+ money);
		}catch (Exception e) {
			System.out.println("Money 오브젝트가 만들어지지 않았어요.");
		}
		
		//int money = m.minus();
		//System.out.println("남은 금액은 : "+ money);
	}

}
