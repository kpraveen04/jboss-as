/*
* JBoss, Home of Professional Open Source.
* Copyright 2011, Red Hat Middleware LLC, and individual contributors
* as indicated by the @author tags. See the copyright.txt file in the
* distribution for a full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.jboss.as.host.controller.model.jvm;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.NAME;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.VALUE;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.WRITE_ATTRIBUTE_OPERATION;

import org.jboss.as.controller.registry.ManagementResourceRegistration;
import org.jboss.as.controller.registry.Resource;
import org.jboss.dmr.ModelNode;
import org.junit.Test;

/**
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
public class GlobalJvmModelTestCase extends AbstractJvmModelTest {

    public GlobalJvmModelTestCase() {
        super(false);
    }

    @Test
    public void testWriteDebugEnabled() throws Exception {
        testEmptyAddSubsystem();
        ModelNode op = createOperation(WRITE_ATTRIBUTE_OPERATION);
        op.get(NAME).set("debug-enabled");
        op.get(VALUE).set(true);
        executeForFailure(op);
    }

    @Test
    public void testWriteDebugOptions() throws Exception {
        testEmptyAddSubsystem();
        ModelNode op = createOperation(WRITE_ATTRIBUTE_OPERATION);
        op.get(NAME).set("debug-options");
        op.get(VALUE).set(true);
        executeForFailure(op);
    }

    protected void initModel(Resource rootResource, ManagementResourceRegistration registration) {
        super.initModel(rootResource, registration);
        registration.registerSubModel(JvmResourceDefinition.GLOBAL);
    }
}
