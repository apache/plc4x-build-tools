/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.plugins.codegenerator.types.fields;

import java.util.Optional;

/**
 * Used to convert between types.
 */
public interface FieldConversions {
    /**
     * @return true if {@code this} is instance of {@link AbstractField}
     */
    default boolean isAbstractField() {
        return this instanceof AbstractField;
    }

    /**
     * @return a {@link AbstractField} if castable.
     */
    default Optional<AbstractField> asAbstractField() {
        return Optional.of(this).filter(AbstractField.class::isInstance).map(AbstractField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ArrayField}
     */
    default boolean isArrayField() {
        return this instanceof ArrayField;
    }

    /**
     * @return a {@link ArrayField} if castable.
     */
    default Optional<ArrayField> asArrayField() {
        return Optional.of(this).filter(ArrayField.class::isInstance).map(ArrayField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link AssertField}
     */
    default boolean isAssertField() {
        return this instanceof AssertField;
    }

    /**
     * @return a {@link AssertField} if castable.
     */
    default Optional<AssertField> asAssertField() {
        return Optional.of(this).filter(AssertField.class::isInstance).map(AssertField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ChecksumField}
     */
    default boolean isChecksumField() {
        return this instanceof ChecksumField;
    }

    /**
     * @return a {@link ChecksumField} if castable.
     */
    default Optional<ChecksumField> asChecksumField() {
        return Optional.of(this).filter(ChecksumField.class::isInstance).map(ChecksumField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ConstField}
     */
    default boolean isConstField() {
        return this instanceof ConstField;
    }

    /**
     * @return a {@link ConstField} if castable.
     */
    default Optional<ConstField> asConstField() {
        return Optional.of(this).filter(ConstField.class::isInstance).map(ConstField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link DiscriminatorField}
     */
    default boolean isDiscriminatorField() {
        return this instanceof DiscriminatorField;
    }

    /**
     * @return a {@link DiscriminatorField} if castable.
     */
    default Optional<DiscriminatorField> asDiscriminatorField() {
        return Optional.of(this).filter(DiscriminatorField.class::isInstance).map(DiscriminatorField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link EnumField}
     */
    default boolean isEnumField() {
        return this instanceof EnumField;
    }

    /**
     * @return a {@link EnumField} if castable.
     */
    default Optional<EnumField> asEnumField() {
        return Optional.of(this).filter(EnumField.class::isInstance).map(EnumField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ImplicitField}
     */
    default boolean isImplicitField() {
        return this instanceof ImplicitField;
    }

    /**
     * @return a {@link ImplicitField} if castable.
     */
    default Optional<ImplicitField> asImplicitField() {
        return Optional.of(this).filter(ImplicitField.class::isInstance).map(ImplicitField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ManualArrayField}
     */
    default boolean isManualArrayField() {
        return this instanceof ManualArrayField;
    }

    /**
     * @return a {@link ManualArrayField} if castable.
     */
    default Optional<ManualArrayField> asManualArrayField() {
        return Optional.of(this).filter(ManualArrayField.class::isInstance).map(ManualArrayField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ManualField}
     */
    default boolean isManualField() {
        return this instanceof ManualField;
    }

    /**
     * @return a {@link ManualField} if castable.
     */
    default Optional<ManualField> asManualField() {
        return Optional.of(this).filter(ManualField.class::isInstance).map(ManualField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link NamedField}
     */
    default boolean isNamedField() {
        return this instanceof NamedField;
    }

    /**
     * @return a {@link NamedField} if castable.
     */
    default Optional<NamedField> asNamedField() {
        return Optional.of(this).filter(NamedField.class::isInstance).map(NamedField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link OptionalField}
     */
    default boolean isOptionalField() {
        return this instanceof OptionalField;
    }

    /**
     * @return a {@link OptionalField} if castable.
     */
    default Optional<OptionalField> asOptionalField() {
        return Optional.of(this).filter(OptionalField.class::isInstance).map(OptionalField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link PaddingField}
     */
    default boolean isPaddingField() {
        return this instanceof PaddingField;
    }

    /**
     * @return a {@link PaddingField} if castable.
     */
    default Optional<PaddingField> asPaddingField() {
        return Optional.of(this).filter(PaddingField.class::isInstance).map(PaddingField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link PropertyField}
     */
    default boolean isPropertyField() {
        return this instanceof PropertyField;
    }

    /**
     * @return a {@link PropertyField} if castable.
     */
    default Optional<PropertyField> asPropertyField() {
        return Optional.of(this).filter(PropertyField.class::isInstance).map(PropertyField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ReservedField}
     */
    default boolean isReservedField() {
        return this instanceof ReservedField;
    }

    /**
     * @return a {@link ReservedField} if castable.
     */
    default Optional<ReservedField> asReservedField() {
        return Optional.of(this).filter(ReservedField.class::isInstance).map(ReservedField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link SimpleField}
     */
    default boolean isSimpleField() {
        return this instanceof SimpleField;
    }

    /**
     * @return a {@link SimpleField} if castable.
     */
    default Optional<SimpleField> asSimpleField() {
        return Optional.of(this).filter(SimpleField.class::isInstance).map(SimpleField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link SwitchField}
     */
    default boolean isSwitchField() {
        return this instanceof SwitchField;
    }

    /**
     * @return a {@link SwitchField} if castable.
     */
    default Optional<SwitchField> asSwitchField() {
        return Optional.of(this).filter(SwitchField.class::isInstance).map(SwitchField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link TypedField}
     */
    default boolean isTypedField() {
        return this instanceof TypedField;
    }

    /**
     * @return a {@link TypedField} if castable.
     */
    default Optional<TypedField> asTypedField() {
        return Optional.of(this).filter(TypedField.class::isInstance).map(TypedField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link UnknownField}
     */
    default boolean isUnknownField() {
        return this instanceof UnknownField;
    }

    /**
     * @return a {@link UnknownField} if castable.
     */
    default Optional<UnknownField> asUnknownField() {
        return Optional.of(this).filter(UnknownField.class::isInstance).map(UnknownField.class::cast);
    }


    /**
     * @return true if {@code this} is instance of {@link VirtualField}
     */
    default boolean isVirtualField() {
        return this instanceof VirtualField;
    }

    /**
     * @return a {@link VirtualField} if castable.
     */
    default Optional<VirtualField> asVirtualField() {
        return Optional.of(this).filter(VirtualField.class::isInstance).map(VirtualField.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link ArrayField} with {@link ArrayField.LoopType}{@code .COUNT} or
     * is instance of {@link ManualArrayField} with {@link ManualArrayField.LoopType}{@code .COUNT}
     */
    default boolean isCountArrayField() {
        if (this instanceof ArrayField) {
            ArrayField arrayField = (ArrayField) this;
            return arrayField.getLoopType() == ArrayField.LoopType.COUNT;
        }
        if (this instanceof ManualArrayField) {
            ManualArrayField arrayField = (ManualArrayField) this;
            return arrayField.getLoopType() == ManualArrayField.LoopType.COUNT;
        }
        return false;
    }

    /**
     * @return true if {@code this} is instance of {@link ArrayField} with {@link ArrayField.LoopType}{@code .LENGTH} or
     * is instance of {@link ManualArrayField} with {@link ManualArrayField.LoopType}{@code .LENGTH}
     */
    default boolean isLengthArrayField() {
        if (this instanceof ArrayField) {
            ArrayField arrayField = (ArrayField) this;
            return arrayField.getLoopType() == ArrayField.LoopType.LENGTH;
        }
        if (this instanceof ManualArrayField) {
            ManualArrayField arrayField = (ManualArrayField) this;
            return arrayField.getLoopType() == ManualArrayField.LoopType.LENGTH;
        }
        return false;
    }

    /**
     * @return true if {@code this} is instance of {@link ArrayField} with {@link ArrayField.LoopType}{@code .TERMINATED} or
     * is instance of {@link ManualArrayField} with {@link ManualArrayField.LoopType}{@code .TERMINATED}
     */
    default boolean isTerminatedArrayField() {
        if (this instanceof ArrayField) {
            ArrayField arrayField = (ArrayField) this;
            return arrayField.getLoopType() == ArrayField.LoopType.TERMINATED;
        }
        if (this instanceof ManualArrayField) {
            ManualArrayField arrayField = (ManualArrayField) this;
            return arrayField.getLoopType() == ManualArrayField.LoopType.TERMINATED;
        }
        return false;
    }

}
