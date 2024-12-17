package bgu.spl.mics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A Future object represents a promised result - an object that will
 * eventually be resolved to hold a result of some operation. The class allows
 * Retrieving the result once it is available.
 * 
 * Only private methods may be added to this class.
 * No public constructor is allowed except for the empty constructor.
 */

 /* ====================================
 To Do:
 check if get() needs to be synchronized
 check if resolve() needs to be synched
 implement timeService for the second get(time,unit) function
 ====================================*/
public class Future<T> {
	
	private T result;
	private boolean isDone;
	/**
	 * This should be the the only public constructor in this class.
	 */
	public Future() {
		result = null;
		isDone = false;
	}
	
	/**
     * retrieves the result the Future object holds if it has been resolved.
     * This is a blocking method! It waits for the computation in case it has
     * not been completed.
     * <p>
     * @return return the result of type T if it is available, if not wait until it is available.
     * 	       
     */
	public T get() {
		while (!isDone) {
			
		}
		//===========Check Later==================
		return result;
	}
	
	/**
     * Resolves the result of this Future object.
     */
	public void resolve (T result) { //Check if needs to be synched
		this.result = result;
		isDone = true;
	}
	
	/**
     * @return true if this object has been resolved, false otherwise
     */
	public boolean isDone() {
		return isDone;
	}
	
	/**
     * retrieves the result the Future object holds if it has been resolved,
     * This method is non-blocking, it has a limited amount of time determined
     * by {@code timeout}
     * <p>
     * @param timout 	the maximal amount of time units to wait for the result.
     * @param unit		the {@link TimeUnit} time units to wait.
     * @return return the result of type T if it is available, if not, 
     * 	       wait for {@code timeout} TimeUnits {@code unit}. If time has
     *         elapsed, return null.
     */
	public T get(long timeout, TimeUnit unit) {
		long currTime;
		long finishTime = currTime + timeout; //Convert to same time units
		while(!isDone() & currTime<finishTime){
			currTime = currTimeService;
		}
		return result;
	}

}