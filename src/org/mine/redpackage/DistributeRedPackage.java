
package org.mine.redpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 100元的红包随机发给10个人，每人最多不能超过12元，最少不能低于6元 
 */
public class DistributeRedPackage {

	private int personNum;
	private long totAmt;
	private final long LAST_AMT;
	private final long MOST_AMT;
 
	public static void main(String[] args) {

		DistributeRedPackage instance = new DistributeRedPackage(12, 10000, 600, 1200);
		Map<Integer,Long> result = instance.doDistribute();

		Set<Integer> entry = result.keySet();
		Iterator<Integer> it =  entry.iterator();
		long tot = 0;
		while(it.hasNext()){
			int index = it.next();
			long userAmt =((Long)result.get(index) + instance.LAST_AMT);
			System.out.println(index + "==> " + userAmt/100.0 );
			tot += userAmt;
		}
		System.out.println("tot ==>" + tot/100.0);
	}

	public DistributeRedPackage(int personNum, long totAmt, long lastAmt, long mostAmt) {

		this.personNum = personNum;
		this.totAmt = totAmt;
		LAST_AMT = lastAmt;
		MOST_AMT = mostAmt;
	}

	private Map<Integer,Long> doDistribute(){

		long leastAmt = this.totAmt - this.personNum * LAST_AMT;
		long currentMostAmt = this.MOST_AMT - this.LAST_AMT;
		Map<Integer,Long> result = new HashMap<Integer,Long>();
		while(leastAmt > 0){
			long currentAmt = (long)(Math.random() * currentMostAmt);
			int personIndex = (int)(Math.random() * this.personNum);

			if(currentAmt > leastAmt){
				continue;
			}

			if(result.containsKey(personIndex)){
				if((result.get(personIndex) + currentAmt <= currentMostAmt))
					result.put(personIndex, (result.get(personIndex) + currentAmt));
				else
					continue;
			}
			else {
				result.put(personIndex, currentAmt);
			}
			leastAmt = leastAmt - currentAmt;
		}
		return result;
	}
}
