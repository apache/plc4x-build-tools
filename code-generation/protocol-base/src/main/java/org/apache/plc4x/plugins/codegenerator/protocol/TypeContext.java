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

import org.apache.plc4x.plugins.codegenerator.types.definitions.TypeDefinition;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * The type context of a protocol
 */
public interface TypeContext {
    /**
     * Returns a map of type definitions for which code has to be generated.
     *
     * @return the Map of types that need to be generated.
     */
    Map<String, TypeDefinition> getTypeDefinitions();

    /**
     * Returns a map of consumers which still require a {@link TypeDefinition}
     *
     * @return the map of consumers which require a type
     */
    Map<String, List<Consumer<TypeDefinition>>> getUnresolvedTypeReferences();
}
