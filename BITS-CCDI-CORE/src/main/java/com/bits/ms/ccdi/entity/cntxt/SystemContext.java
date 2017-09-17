/**
 * 
 */
package com.bits.ms.ccdi.entity.cntxt;

import com.bits.ms.ccdi.entity.constants.EntityAPIConstants;

/**
 * SystemContext will be singleton and the properties will be initialized when
 * the instance is first created.
 * 
 * @author AD40439
 * 
 */
public final class SystemContext extends BaseContext {
	private static  SystemContext instance = null;

	private static final long serialVersionUID = 5674288440233126229L;
	private String serverClusterID;
	private String serverNodeID;
	private String serverInstanceID;
	private String serverCellID;
	private String environment;

	/**
	 * Empty constructor
	 */
	private SystemContext() {
		super();
	}

	/**
	 * Ensure that only one instance is created in the whole application.
	 * 
	 * @return
	 */
	public static SystemContext getInstance() {
		if (instance == null) {
			synchronized (SystemContext.class) {
				// Double check
				if (instance == null) {
					instance = new SystemContext();

					// Initialize system properties here.
					instance.setServerClusterID(System
							.getProperty(EntityAPIConstants.CLUSTER_ID_KEY));
					instance.setServerNodeID(System
							.getProperty(EntityAPIConstants.NODE_ID_KEY));
					instance.setServerInstanceID(System
							.getProperty(EntityAPIConstants.INSTANCE_ID_KEY));
					instance.setServerCellID(System
							.getProperty(EntityAPIConstants.CELL_ID_KEY));
					instance.setEnvironment(System
							.getProperty(EntityAPIConstants.ENVIRONMENT_KEY));
				}
			}
		}
		return instance;
	}

	/**
	 * @return the serverClusterID
	 */
	public String getServerClusterID() {
		return serverClusterID;
	}

	/**
	 * @param serverClusterID
	 *            the serverClusterID to set
	 */
	public void setServerClusterID(String serverClusterID) {
		this.serverClusterID = serverClusterID;
	}

	/**
	 * @return the serverNodeID
	 */
	public String getServerNodeID() {
		return serverNodeID;
	}

	/**
	 * @param serverNodeID
	 *            the serverNodeID to set
	 */
	public void setServerNodeID(String serverNodeID) {
		this.serverNodeID = serverNodeID;
	}

	/**
	 * @return the serverInstanceID
	 */
	public String getServerInstanceID() {
		return serverInstanceID;
	}

	/**
	 * @param serverInstanceID
	 *            the serverInstanceID to set
	 */
	public void setServerInstanceID(String serverInstanceID) {
		this.serverInstanceID = serverInstanceID;
	}

	/**
	 * @return the serverCellID
	 */
	public String getServerCellID() {
		return serverCellID;
	}

	/**
	 * @param serverCellID
	 *            the serverCellID to set
	 */
	public void setServerCellID(String serverCellID) {
		this.serverCellID = serverCellID;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment
	 *            the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return String
				.format("environment=%s, serverClusterID=%s, serverNodeID=%s, serverInstanceID=%s, serverCellID=%s",
						environment, serverClusterID, serverNodeID,
						serverInstanceID, serverCellID);
	}

}
