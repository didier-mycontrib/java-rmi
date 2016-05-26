package temp.multi.mainCtx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//import temp.multi.secondaryCtx.Cb;

@Component
public class C2 {
	
	@Autowired
	private ApplicationContext context;
	
	/*
	public void testAccessingComponentOfChildContext(){
		context.getBean(Cb.class).sayHelloCb();
		//not working : components of child context are not visible from parent context
	}*/

}
