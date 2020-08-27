import java.lang.reflect.Field;
import java.lang.reflect.Method;

//스프링 로딩 될 때
public class CosContainer { //IoC Container라고 생각하면 된다. 그럼 얘로 @뭐가 붙었는지 쫘악 스캔한다. 

	//public 인수타입 리턴타입 함수명(){} //인수타입은 리턴입이랑 상관없음.
//invoke : 호출
	public <T> T invokeAnnotation(T instance) {
		Method[] methods = instance.getClass().getDeclaredMethods(); //그 instance가 들고 있는 모든 메서드를 다 담아준다.
		for (Method m : methods) {
			if(m.isAnnotationPresent(NumCheck.class)) {
				System.out.println("NumCheck 가지고 있음.");
				Field f[] = instance.getClass().getFields();
				
				try {
					int num1 = f[0].getInt(instance);
					int num2 = f[1].getInt(instance);
					
					System.out.println(num1);
					System.out.println(num2);
					
					if(num1 - num2 < 0) {
						System.out.println("금액이 부족합니다.");
						return null;
					}
				}catch(Exception e) {					
				}			
				
			}
			//톰켓시작시에 데이터베이스 관련된 쪽의 어노테이션들을 쫘악 스캔
			//스캔을 두번하는데 톰켓실행시에 Dispatcher Servlet이 스캔해서 container에 IoC해준다.			
			//레거시할 때도 xml파일 2개 - 처음 한번 띄울 것: DB관련/ 요청시 마다 띄우는 어노테이션
		}
		return instance;
		//System.out.println("메서드 몇개 가지고 있어? size : " +methods.length );
	}
	
	//코드말고 메모리에 뜬 메서드 주소찾아냄.

	
}
