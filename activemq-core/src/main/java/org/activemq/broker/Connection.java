/**
 * <a href="http://activemq.org">ActiveMQ: The Open Source Message Fabric</a>
 *
 * Copyright 2005 (C) LogicBlaze, Inc. http://www.logicblaze.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
package org.activemq.broker;

import org.activemq.Service;
import org.activemq.broker.region.ConnectionStatistics;
import org.activemq.command.Command;
import org.activemq.command.Response;

/**
 * 
 * @version $Revision: 1.5 $
 */
public interface Connection extends Service {

    /**
     * @return the connector that created this connection.
     */
    public Connector getConnector();

    /**
     * Sends a message to the client.
     * 
     * @param message
     *            the message to send to the client.
     */
    public void dispatchSync(Command message);

    /**
     * Sends a message to the client.
     * 
     * @param command
     */
    public void dispatchAsync(Command command);

    /**
     * Services a client command and submits it to the broker.
     * 
     * @param command
     */
    public Response service(Command command);

    /**
     * Handles an unexpected error associated with a connection.
     * 
     * @param error
     */
    public void serviceException(Throwable error);

    /**
     * @return true if the Connection is slow
     */
    public boolean isSlow();

    /**
     * @return if after being marked, the Connection is still writing
     */
    public boolean isBlocked();

    /**
     * @return true if the Connection is connected
     */
    public boolean isConnected();

    /**
     * @return true if the Connection is active
     */
    public boolean isActive();

    /**
     * Returns the number of messages to be dispatched to this connection
     */
    public int getDispatchQueueSize();
    
    /**
     * Returns the statistics for this connection
     */
    public ConnectionStatistics getStatistics();

}
