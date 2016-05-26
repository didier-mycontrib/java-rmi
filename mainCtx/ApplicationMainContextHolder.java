package temp.multi.mainCtx;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*
 * Remarque : dès que spring prend en charge un composant , il détecte si celui-ci implémente 
 * l'interface spéciale "ApplicationContextAware" et dans ce cas il appelle automatiquement
 * la méthode setApplicationContext(ApplicationContext context) en passant/fournissant le contexte spring courant.
 * 
 * Cette méthode peut alors stocker cette information dans une variable de classe statique
 * de manière à ce que n'importe quelle classe java prise en charge par la même JVM puisse accéder à ce contexte
 * en appelant la méthode statique getAppMainContext().
 * 
 * Ceci permet un accès aux composants Spring gérés par ce contexte
 * depuis :
 *          - d'autres contextes spring 
 *          - des composants "java" quelconques (pas gérés par Spring):
 *          
 *  ApplicationMainContextHolder.getAppMainContext().getBean(...)  ou ...       
 */


@Component //ou équivalent xml ou javaConfig
public class ApplicationMainContextHolder implements ApplicationContextAware {
	
	private static ApplicationContext myAppMainContext;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		myAppMainContext = context;
		
	}
	
	public static ApplicationContext getAppMainContext(){
		return myAppMainContext;
	}

}
