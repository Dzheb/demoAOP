package ru.dzheb.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dzheb.aop.demo.MyServiceBean;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class AopApplication {
	/**
	 * 1. Создать аннотацию замера времени исполнения
	 * метода (Timer). Она может ставиться над
	 * методами или классами.
	 * Аннотация работает так: после исполнения метода
	 * (метода класса) с такой аннотацией, необходимо
	 * в лог записать следующее:
	 * className - methodName
	 * #(количество секунд выполнения)
	 *
	 * 2.* Создать аннотацию RecoverException, которую можно
	 * ставить только над методами.
	 * <code>
	 *   @interface RecoverException {
	 *     Class<? extends RuntimeException>[] noRecoverFor() default {};
	 *   }
	 * </code>
	 * У аннотации должен быть параметр noRecoverFor,
	 * в котором можно перечислить другие классы
	 * исключений.
	 * Аннотация работает так: если во время
	 * исполнения метода был экспешн,
	 * то не прокидывать его выше и возвращать
	 * из метода значение по умолчанию
	 * (null, 0, false, ...).
	 * При этом, если тип исключения входит
	 * в список перечисленных в noRecoverFor
	 * исключений, то исключение
	 * НЕ прерывается и прокидывается выше.
	 * 3.*** Параметр noRecoverFor должен учитывать иерархию исключений.
	 *
	 * Сдавать ссылкой на файл-аспект в проекте на гитхабе.
	 */

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(AopApplication.class, args);
		MyServiceBean myServiceBean = context.getBean(MyServiceBean.class);
		try{
		System.out.println(myServiceBean.method1(null));
		} catch (Throwable e){
			log.info("Error {}", e.getMessage());
		}
		System.out.println(myServiceBean.method2("argument"));


//			System.out.println(RuntimeException.class.isAssignableFrom(IllegalArgumentException.class));
//		System.out.println(IllegalArgumentException.class.isAssignableFrom(RuntimeException.class));

	}

}
