package br.com.caelum.livraria.exception;

import javax.ejb.ApplicationException;

/**
 * 
 * @author Cleberson
 * Como essa exceção é uma ApplicationException, precisamos falar para o Container que deve ter rollback nas transação
 * quando exceção desse tipo for lançada. Por padrão, ApplicationException são checked, não tem rollback e não inativa
 * o session bean que lançou a exeção, devemos explicitamente informar.
 *
 * Como configuramos para ter rollback, podemos herdar de unchecked Exception = RuntimeException
 *
 */
@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LivrariaException(String message) {
		super(message);
	}

}
