package com.bits.ms.ccdi.entity.cntxt;

/**
 * This class holds the context related information when job is executed.
 * 
 * @author AD40439
 *
 */
public class JobContext extends ActivityContext {

	private static final long serialVersionUID = 7957647886171154447L;
	
	private String jobEnableFlagId;

	/**
	 * Empty constructor for Job context
	 */
	public JobContext(){
		super();
	}

	/**
	 * Constructor for Job context
	 * @param jobContext
	 */
	public JobContext(JobContext jobContext){
		super(jobContext);
	}

	/**
	 * @param jobEnableFlagId the jobEnableFlagId to set
	 */
	public void setJobEnableFlagId(String jobEnableFlagId)
	{
		this.jobEnableFlagId = jobEnableFlagId;
	}

	/**
	 * @return the jobEnableFlagId
	 */
	public String getJobEnableFlagId()
	{
		return jobEnableFlagId;
	}

	@Override
	public String toString()
	{
		return "JobContext [jobEnableFlagId=" + jobEnableFlagId + "]";
	}

}

