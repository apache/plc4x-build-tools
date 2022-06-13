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
package org.apache.plc4x.plugins.codegenerator.types.definitions;

import java.util.Optional;

/**
 * Used to convert between types.
 */
public interface TypeDefinitionConversions {

    /**
     * @return true if {@code this} is a {@link ComplexTypeDefinition}.
     */
    default boolean isComplexTypeDefinition() {
        return this instanceof ComplexTypeDefinition;
    }

    /**
     * @return a {@link ComplexTypeDefinition} if castable.
     */
    default Optional<ComplexTypeDefinition> asComplexTypeDefinition() {
        return Optional.of(this).filter(ComplexTypeDefinition.class::isInstance).map(ComplexTypeDefinition.class::cast);
    }

    /**
     * @return true if {@code this} is a {@link DataIoTypeDefinition}.
     */
    default boolean isDataIoTypeDefinition() {
        return this instanceof DataIoTypeDefinition;
    }

    /**
     * @return a {@link DataIoTypeDefinition} if castable.
     */
    default Optional<DataIoTypeDefinition> asDataIoTypeDefinition() {
        return Optional.of(this).filter(DataIoTypeDefinition.class::isInstance).map(DataIoTypeDefinition.class::cast);
    }

    /**
     * @return true if {@code this} is a {@link DiscriminatedComplexTypeDefinition}.
     */
    default boolean isDiscriminatedComplexTypeDefinition() {
        return this instanceof DiscriminatedComplexTypeDefinition;
    }

    /**
     * @return a {@link DiscriminatedComplexTypeDefinition} if castable.
     */
    default Optional<DiscriminatedComplexTypeDefinition> asDiscriminatedComplexTypeDefinition() {
        return Optional.of(this).filter(DiscriminatedComplexTypeDefinition.class::isInstance).map(DiscriminatedComplexTypeDefinition.class::cast);
    }

    /**
     * @return true if {@code this} is a {@link EnumTypeDefinition}.
     */
    default boolean isEnumTypeDefinition() {
        return this instanceof EnumTypeDefinition;
    }

    /**
     * @return a {@link EnumTypeDefinition} if castable.
     */
    default Optional<EnumTypeDefinition> asEnumTypeDefinition() {
        return Optional.of(this).filter(EnumTypeDefinition.class::isInstance).map(EnumTypeDefinition.class::cast);
    }

}
