package org.trueoop.app;

public class Application implements IApplication {

	private ITask _task;

	public Application(ITask task) {
		this._task = task;
	}
	
	public Application() {
		this(null);
	}

	@Override
	public void run(IEnviroment enviroment) {
		if(null != _task)
			_task.run(enviroment);
	}

}
