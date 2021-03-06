/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.rest.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * @author Tijs Rademakers
 */
public class ActivitiServletContextListener implements ServletContextListener {
  
  protected static final Logger LOGGER = Logger.getLogger(ActivitiServletContextListener.class.getName());

  public void contextInitialized(ServletContextEvent event) {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    if (processEngine == null) {
      LOGGER.log(Level.SEVERE,"Could not start the Activiti Engine");
    }
  }

  public void contextDestroyed(ServletContextEvent event) {
    ProcessEngines.destroy();
  }

}
