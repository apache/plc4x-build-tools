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
package org.apache.plc4x.plugins.codegenerator.types.references;

import java.util.Optional;

/**
 * Used to convert between types.
 */
public interface TypeReferenceConversions {
    /**
     * @return true if {@code this} is instance of {@link BooleanTypeReference}
     */
    default boolean isBooleanTypeReference() {
        return this instanceof BooleanTypeReference;
    }

    /**
     * @return a {@link BooleanTypeReference} if castable.
     */
    default Optional<BooleanTypeReference> asBooleanTypeReference() {
        return Optional.of(this).filter(BooleanTypeReference.class::isInstance).map(BooleanTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ByteTypeReference}
     */
    default boolean isByteTypeReference() {
        return this instanceof ByteTypeReference;
    }

    /**
     * @return a {@link ByteTypeReference} if castable.
     */
    default Optional<ByteTypeReference> asByteTypeReference() {
        return Optional.of(this).filter(ByteTypeReference.class::isInstance).map(ByteTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ComplexTypeReference}
     */
    default boolean isComplexTypeReference() {
        return this instanceof ComplexTypeReference;
    }

    /**
     * @return a {@link ComplexTypeReference} if castable.
     */
    default Optional<ComplexTypeReference> asComplexTypeReference() {
        return Optional.of(this).filter(ComplexTypeReference.class::isInstance).map(ComplexTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link NonSimpleTypeReference}
     */
    default boolean isNonSimpleTypeReference() {
        return this instanceof NonSimpleTypeReference;
    }

    /**
     * @return a {@link NonSimpleTypeReference} if castable.
     */
    default Optional<NonSimpleTypeReference> asNonSimpleTypeReference() {
        return Optional.of(this).filter(NonSimpleTypeReference.class::isInstance).map(NonSimpleTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ArrayTypeReference}
     */
    default boolean isArrayTypeReference() {
        return this instanceof ArrayTypeReference;
    }

    /**
     * @return a {@link ArrayTypeReference} if castable.
     */
    default Optional<ArrayTypeReference> asArrayTypeReference() {
        return Optional.of(this).filter(ArrayTypeReference.class::isInstance).map(ArrayTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link EnumTypeReference}
     */
    default boolean isEnumTypeReference() {
        return this instanceof EnumTypeReference;
    }

    /**
     * @return a {@link EnumTypeReference} if castable.
     */
    default Optional<EnumTypeReference> asEnumTypeReference() {
        return Optional.of(this).filter(EnumTypeReference.class::isInstance).map(EnumTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link DataIoTypeReference}
     */
    default boolean isDataIoTypeReference() {
        return this instanceof DataIoTypeReference;
    }

    /**
     * @return a {@link DataIoTypeReference} if castable.
     */
    default Optional<DataIoTypeReference> asDataIoTypeReference() {
        return Optional.of(this).filter(DataIoTypeReference.class::isInstance).map(DataIoTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link FloatTypeReference}
     */
    default boolean isFloatTypeReference() {
        return this instanceof FloatTypeReference;
    }

    /**
     * @return a {@link FloatTypeReference} if castable.
     */
    default Optional<FloatTypeReference> asFloatTypeReference() {
        return Optional.of(this).filter(FloatTypeReference.class::isInstance).map(FloatTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link IntegerTypeReference}
     */
    default boolean isIntegerTypeReference() {
        return this instanceof IntegerTypeReference;
    }

    /**
     * @return a {@link IntegerTypeReference} if castable.
     */
    default Optional<IntegerTypeReference> asIntegerTypeReference() {
        return Optional.of(this).filter(IntegerTypeReference.class::isInstance).map(IntegerTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link SimpleTypeReference}
     */
    default boolean isSimpleTypeReference() {
        return this instanceof SimpleTypeReference;
    }

    /**
     * @return a {@link SimpleTypeReference} if castable.
     */
    default Optional<SimpleTypeReference> asSimpleTypeReference() {
        return Optional.of(this).filter(SimpleTypeReference.class::isInstance).map(SimpleTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link SimpleVarLengthTypeReference}
     */
    default boolean isSimpleVarLengthTypeReference() {
        return this instanceof SimpleVarLengthTypeReference;
    }

    /**
     * @return a {@link SimpleVarLengthTypeReference} if castable.
     */
    default Optional<SimpleVarLengthTypeReference> asSimpleVarLengthTypeReference() {
        return Optional.of(this).filter(SimpleVarLengthTypeReference.class::isInstance).map(SimpleVarLengthTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link StringTypeReference}
     */
    default boolean isStringTypeReference() {
        return this instanceof StringTypeReference;
    }

    /**
     * @return a {@link StringTypeReference} if castable.
     */
    default Optional<StringTypeReference> asStringTypeReference() {
        return Optional.of(this).filter(StringTypeReference.class::isInstance).map(StringTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link VstringTypeReference}
     */
    default boolean isVstringTypeReference() {
        return this instanceof VstringTypeReference;
    }

    /**
     * @return a {@link StringTypeReference} if castable.
     */
    default Optional<VstringTypeReference> asVstringTypeReference() {
        return Optional.of(this).filter(VstringTypeReference.class::isInstance).map(VstringTypeReference.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link TemporalTypeReference}
     */
    default boolean isTemporalTypeReference() {
        return this instanceof TemporalTypeReference;
    }

    /**
     * @return a {@link TemporalTypeReference} if castable.
     */
    default Optional<TemporalTypeReference> asTemporalTypeReference() {
        return Optional.of(this).filter(TemporalTypeReference.class::isInstance).map(TemporalTypeReference.class::cast);
    }


}
