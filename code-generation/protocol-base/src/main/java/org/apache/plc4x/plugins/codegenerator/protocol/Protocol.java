/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.plugins.codegenerator.protocol;

import org.apache.plc4x.plugins.codegenerator.types.exceptions.GenerationException;

import java.util.Optional;

public interface Protocol {

    /**
     * The name of the protocol what the plugin will use to select the correct protocol module.
     *
     * @return the name of the protocol.
     */
    String getName();

    /**
     * Returns a map of type definitions for which code has to be generated.
     *
     * @return the Map of types that need to be generated.
     * @throws GenerationException if anything goes wrong parsing.
     */
    TypeContext getTypeContext() throws GenerationException;


    /**
     * @return the protocolVersion is applicable
     */
    default Optional<String> getVersion() {
        return Optional.empty();
    }

}
