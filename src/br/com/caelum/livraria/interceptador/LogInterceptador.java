package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long millis = System.currentTimeMillis();
		
		Object o = context.proceed();
		
		String nomeMetodo = context.getMethod().getName();
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		
		System.out.print("Nome da classe: " + nomeClasse + ", nome do método: " + nomeMetodo + ".");
		System.out.println("[INFO] Tempo gasto no acesso: " + (System.currentTimeMillis() - millis) + " ms.");
		
		return o;
	}
	
}
