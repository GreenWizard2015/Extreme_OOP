package org.trueoop.app;

public class Application implements IApplication {

	private ITask _task;

	public Application(ITask task) {
		this._task = task;
	}
	
	public Application() {
		this(null);
	}

	public void run(String[] args) {
		if(null != _task)
			_task.run();		
	}

}
