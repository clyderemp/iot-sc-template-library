/** Generated by itemis CREATE code generator. */
package smarthub.java;

import com.yakindu.core.IEventDriven;
import com.yakindu.core.IStatemachine;
import com.yakindu.core.ITimed;
import com.yakindu.core.ITimerService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller_Component implements ITimed, IEventDriven {
	public static class Sensors {
		private Controller_Component parent;
		
		public Sensors(Controller_Component parent) {
			this.parent = parent;
		}
		private boolean triggered;
		
		public synchronized boolean getTriggered() {
			synchronized(parent) {
				return triggered;
			}
		}
		
		public void setTriggered(boolean value) {
			synchronized(parent) {
				this.triggered = value;
			}
		}
		
	}
	
	public static class Actuator {
		private Controller_Component parent;
		
		public Actuator(Controller_Component parent) {
			this.parent = parent;
		}
		private boolean trigger;
		
		
		public void raiseTrigger() {
			synchronized(parent) {
				parent.inEventQueue.add(() -> {
					trigger = true;
				});
				parent.runCycle();
			}
		}
		
		private boolean triggered;
		
		public synchronized boolean getTriggered() {
			synchronized(parent) {
				return triggered;
			}
		}
		
		public void setTriggered(boolean value) {
			synchronized(parent) {
				this.triggered = value;
			}
		}
		
	}
	
	protected Sensors sensors;
	
	protected Actuator actuator;
	
	public enum State {
		_CONTROLLER_COMPONENT___CONTROLLER_ISON_,
		_CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_,
		_CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_,
		_CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_,
		_CONTROLLER_COMPONENT___OFF_,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private ITimerService timerService;
	
	private final boolean[] timeEvents = new boolean[2];
	
	private BlockingQueue<Runnable> inEventQueue = new LinkedBlockingQueue<Runnable>();
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		synchronized(Controller_Component.this) {
			return isExecuting;
		}
	}
	
	protected void setIsExecuting(boolean value) {
		synchronized(Controller_Component.this) {
			this.isExecuting = value;
		}
	}
	public Controller_Component() {
		sensors = new Sensors(this);
		actuator = new Actuator(this);
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInEvents();
		
		setActivity(false);
		
		sensors.setTriggered(false);
		
		actuator.setTriggered(false);
		
		isExecuting = false;
	}
	
	public synchronized void enter() {
		if (timerService == null) {
			throw new IllegalStateException("Timer service must be set.");
		}
		
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		enterSequence__Controller_Component__default();
		isExecuting = false;
	}
	
	public synchronized void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		exitSequence__Controller_Component_();
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public synchronized boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public synchronized boolean isFinal() {
		return false;
	}
	private void clearInEvents() {
		off = false;
		on = false;
		actuator.trigger = false;
		timeEvents[0] = false;
		timeEvents[1] = false;
	}
	
	private void microStep() {
		switch (stateVector[0]) {
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_:
			_Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data__react(-1l);
			break;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_:
			_Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received__react(-1l);
			break;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_:
			_Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator__react(-1l);
			break;
		case _CONTROLLER_COMPONENT___OFF_:
			_Controller_Component___off__react(-1l);
			break;
		default:
			break;
		}
	}
	
	private void runCycle() {
		if (timerService == null) {
			throw new IllegalStateException("Timer service must be set.");
		}
		
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		nextEvent();
		do { 
			microStep();
			
			clearInEvents();
		} while (nextEvent());
		
		isExecuting = false;
	}
	
	protected boolean nextEvent() {
		if(!inEventQueue.isEmpty()) {
			inEventQueue.poll().run();
			return true;
		}
		return false;
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public synchronized boolean isStateActive(State state) {
	
		switch (state) {
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON_:
			return stateVector[0].ordinal() >= State.
					_CONTROLLER_COMPONENT___CONTROLLER_ISON_.ordinal()&& stateVector[0].ordinal() <= State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_.ordinal();
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_:
			return stateVector[0] == State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_:
			return stateVector[0] == State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_:
			return stateVector[0] == State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_;
		case _CONTROLLER_COMPONENT___OFF_:
			return stateVector[0] == State._CONTROLLER_COMPONENT___OFF_;
		default:
			return false;
		}
	}
	
	public synchronized void setTimerService(ITimerService timerService) {
		this.timerService = timerService;
	}
	
	public ITimerService getTimerService() {
		return timerService;
	}
	
	public synchronized void raiseTimeEvent(int eventID) {
		inEventQueue.add(() -> {
			timeEvents[eventID] = true;
		});
		runCycle();
	}
	
	public Sensors sensors() {
		return sensors;
	}
	
	public Actuator actuator() {
		return actuator;
	}
	
	
	private boolean off;
	
	
	public void raiseOff() {
		synchronized(Controller_Component.this) {
			inEventQueue.add(() -> {
				off = true;
			});
			runCycle();
		}
	}
	
	private boolean on;
	
	
	public void raiseOn() {
		synchronized(Controller_Component.this) {
			inEventQueue.add(() -> {
				on = true;
			});
			runCycle();
		}
	}
	
	private boolean activity;
	
	public synchronized boolean getActivity() {
		synchronized(Controller_Component.this) {
			return activity;
		}
	}
	
	public void setActivity(boolean value) {
		synchronized(Controller_Component.this) {
			this.activity = value;
		}
	}
	
	/* Entry action for state '<Waiting_for_Sensor_Data>'. */
	private void entryAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_() {
		timerService.setTimer(this, 0, 100l, true);
		
		setActivity(false);
	}
	
	/* Entry action for state '<Sensor_Data_Received>'. */
	private void entryAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received_() {
		setActivity(true);
		
		actuator.raiseTrigger();
	}
	
	/* Entry action for state '<Trigger_Actuator>'. */
	private void entryAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_() {
		timerService.setTimer(this, 1, 200l, true);
		
		actuator.setTriggered(true);
	}
	
	/* Exit action for state '<Waiting_for_Sensor_Data>'. */
	private void exitAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_() {
		timerService.unsetTimer(this, 0);
	}
	
	/* Exit action for state '<Trigger_Actuator>'. */
	private void exitAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_() {
		timerService.unsetTimer(this, 1);
		
		actuator.setTriggered(false);
	}
	
	/* 'default' enter sequence for state <Controller_isON> */
	private void enterSequence__Controller_Component___Controller_isON__default() {
		enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals__default();
	}
	
	/* 'default' enter sequence for state <Waiting_for_Sensor_Data> */
	private void enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data__default() {
		entryAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_();
		stateVector[0] = State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_;
	}
	
	/* 'default' enter sequence for state <Sensor_Data_Received> */
	private void enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received__default() {
		entryAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received_();
		stateVector[0] = State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_;
	}
	
	/* 'default' enter sequence for state <Trigger_Actuator> */
	private void enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator__default() {
		entryAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_();
		stateVector[0] = State._CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_;
	}
	
	/* 'default' enter sequence for state <off> */
	private void enterSequence__Controller_Component___off__default() {
		stateVector[0] = State._CONTROLLER_COMPONENT___OFF_;
	}
	
	/* 'default' enter sequence for region <Controller_Component> */
	private void enterSequence__Controller_Component__default() {
		react__Controller_Component___entry_Default();
	}
	
	/* 'default' enter sequence for region <Controller_Receiving_and_Sending_Signals> */
	private void enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals__default() {
		react__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___entry_Default();
	}
	
	/* Default exit sequence for state <Controller_isON> */
	private void exitSequence__Controller_Component___Controller_isON_() {
		exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals_();
	}
	
	/* Default exit sequence for state <Waiting_for_Sensor_Data> */
	private void exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_() {
		stateVector[0] = State.$NULLSTATE$;
		
		exitAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_();
	}
	
	/* Default exit sequence for state <Sensor_Data_Received> */
	private void exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received_() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state <Trigger_Actuator> */
	private void exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_() {
		stateVector[0] = State.$NULLSTATE$;
		
		exitAction__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_();
	}
	
	/* Default exit sequence for state <off> */
	private void exitSequence__Controller_Component___off_() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region <Controller_Component> */
	private void exitSequence__Controller_Component_() {
		switch (stateVector[0]) {
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_:
			exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_();
			break;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_:
			exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received_();
			break;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_:
			exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_();
			break;
		case _CONTROLLER_COMPONENT___OFF_:
			exitSequence__Controller_Component___off_();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region <Controller_Receiving_and_Sending_Signals> */
	private void exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals_() {
		switch (stateVector[0]) {
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___WAITING_FOR_SENSOR_DATA_:
			exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_();
			break;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___SENSOR_DATA_RECEIVED_:
			exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received_();
			break;
		case _CONTROLLER_COMPONENT___CONTROLLER_ISON___CONTROLLER_RECEIVING_AND_SENDING_SIGNALS___TRIGGER_ACTUATOR_:
			exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react__Controller_Component___entry_Default() {
		enterSequence__Controller_Component___Controller_isON__default();
	}
	
	/* Default react sequence for initial entry  */
	private void react__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___entry_Default() {
		enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data__default();
	}
	
	private long react(long transitioned_before) {
		return transitioned_before;
	}
	
	private long _Controller_Component___Controller_isON__react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
			if (off) {
				exitSequence__Controller_Component___Controller_isON_();
				enterSequence__Controller_Component___off__default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long _Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data__react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
			if (sensors.getTriggered()) {
				exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_();
				enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received__default();
				_Controller_Component___Controller_isON__react(0l);
				
				transitioned_after = 0l;
			} else {
				if (timeEvents[0]) {
					exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data_();
					timeEvents[0] = false;
					enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data__default();
					_Controller_Component___Controller_isON__react(0l);
					
					transitioned_after = 0l;
				}
			}
		}
		if (transitioned_after==transitioned_before) {
			transitioned_after = _Controller_Component___Controller_isON__react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long _Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received__react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
			if (actuator.trigger) {
				exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Sensor_Data_Received_();
				enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator__default();
				_Controller_Component___Controller_isON__react(0l);
				
				transitioned_after = 0l;
			}
		}
		if (transitioned_after==transitioned_before) {
			transitioned_after = _Controller_Component___Controller_isON__react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long _Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator__react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
			if (!sensors.getTriggered()) {
				exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_();
				enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Waiting_for_Sensor_Data__default();
				_Controller_Component___Controller_isON__react(0l);
				
				transitioned_after = 0l;
			} else {
				if (timeEvents[1]) {
					exitSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator_();
					timeEvents[1] = false;
					enterSequence__Controller_Component___Controller_isON___Controller_Receiving_and_Sending_Signals___Trigger_Actuator__default();
					_Controller_Component___Controller_isON__react(0l);
					
					transitioned_after = 0l;
				}
			}
		}
		if (transitioned_after==transitioned_before) {
			transitioned_after = _Controller_Component___Controller_isON__react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long _Controller_Component___off__react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
			if (on) {
				exitSequence__Controller_Component___off_();
				enterSequence__Controller_Component___Controller_isON__default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	/* Can be used by the client code to trigger a run to completion step without raising an event. */
	public synchronized void triggerWithoutEvent() {
		runCycle();
	}
}
