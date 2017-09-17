package com.bits.ms.ccdi.entity.cntxt;
/**
 * This class holds the context information when task is being executed.
 * 
 * @author COGNIZANT
 *
 */
public class TaskContext extends ActivityContext{

	private static final long serialVersionUID = 1023665334219945553L;

	/**
	 * Empty constructor.
	 */
	public TaskContext(){
		
	}
	
	/**
	 * Constructor for task context.
	 *  
	 * @param taskContext
	 */
	public TaskContext(TaskContext taskContext){
		super(taskContext);
	}
}
