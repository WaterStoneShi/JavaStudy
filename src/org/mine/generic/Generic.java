
package org.mine.generic;

import java.math.BigDecimal;

public class Generic {

	/**
	 * @function 
	 * @return void
	 * @param args
	 */
	public static void main(String[] args) {

		Generic generic = new Generic();
		System.out.println(generic.returnGeneric(BigDecimal.valueOf(100)));
		
	}

	public <T extends Number> T returnGeneric(T t){
		return t;
	}
}
