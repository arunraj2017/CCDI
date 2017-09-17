package com.bits.ms.ccdi.entity.cntxt;

/**
 * This class holds the context related information when job/task is being executed.
 * 
 * @author COGNIZANT
 *
 */
public class ActivityContext extends BaseContext {

	private static final long serialVersionUID = 2858945534917416703L;

	private String type;
	private String category;
	private String invocationMode;

	/**
	 * Empty constructor.
	 */
	public ActivityContext() {

	}

	/**
	 * 
	 * @param jobActivityContext
	 */
	public ActivityContext(ActivityContext jobActivityContext) {
		if(null != jobActivityContext)
		{
			this.type = jobActivityContext.type;
			this.category = jobActivityContext.category;
			this.invocationMode = jobActivityContext.invocationMode;
		}
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

	/**
	 * @return the invocationMode
	 */
	public String getInvocationMode()
	{
		return invocationMode;
	}

	/**
	 * @param invocationMode the invocationMode to set
	 */
	public void setInvocationMode(String invocationMode)
	{
		this.invocationMode = invocationMode;
	}

	
}
