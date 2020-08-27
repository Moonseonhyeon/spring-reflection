import java.lang.reflect.Method;

//스프링 로딩 될 때
public class CosContainer { //IoC Container라고 생각하면 된다. 그럼 얘로 @뭐가 붙었는지 쫘악 스캔한다. 

	//리턴입이랑 상관없음.
//invoke : 호출
	private <T> void invokeAnnotation(T instance) {
		Method[] methods = instance.getClass().getDeclaredMethods(); //그 가 들고 있는 모든 메서드를 다 담아준다.
		for (Method m : methods) {
			if(m.isAnnotationPresent(NumCheck.class)) {
				System.out.println("NumCheck 가지고 있음.");
			}
			//톰켓시작시에 데이터베이스 관련된 쪽의 어노테이션들을 쫘악 스캔
			//스캔을 두번하는데 톰켓실행시에 Dispatcher Servlet이 스캔해서 container에 IoC해준다.
			
		}
		System.out.println("size : " +methods.length );
	}
	
	//코드말고 메모리에 뜬 메서드 주소찾아냄.
	
	public static void main(String[] args) {
		CosContainer c = new CosContainer();
		c.invokeAnnotation(new Money());
	}
	
}
