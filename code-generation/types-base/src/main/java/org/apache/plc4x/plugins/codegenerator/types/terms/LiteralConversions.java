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
package org.apache.plc4x.plugins.codegenerator.types.terms;

import java.util.Optional;

/**
 * Used to convert between types.
 */
public interface LiteralConversions {

    /**
     * @return true if {@code this} is instance of {@link BooleanLiteral}
     */
    default boolean isBooleanLiteral() {
        return this instanceof BooleanLiteral;
    }

    /**
     * @return a {@link BooleanLiteral} if castable.
     */
    default Optional<BooleanLiteral> asBooleanLiteral() {
        return Optional.of(this).filter(BooleanLiteral.class::isInstance).map(BooleanLiteral.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link NullLiteral}
     */
    default boolean isNullLiteral() {
        return this instanceof NullLiteral;
    }

    /**
     * @return a {@link NullLiteral} if castable.
     */
    default Optional<NullLiteral> asNullLiteral() {
        return Optional.of(this).filter(NullLiteral.class::isInstance).map(NullLiteral.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link NumericLiteral}
     */
    default boolean isNumericLiteral() {
        return this instanceof NumericLiteral;
    }

    /**
     * @return a {@link NumericLiteral} if castable.
     */
    default Optional<NumericLiteral> asNumericLiteral() {
        return Optional.of(this).filter(NumericLiteral.class::isInstance).map(NumericLiteral.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link StringLiteral}
     */
    default boolean isStringLiteral() {
        return this instanceof StringLiteral;
    }

    /**
     * @return a {@link StringLiteral} if castable.
     */
    default Optional<StringLiteral> asStringLiteral() {
        return Optional.of(this).filter(StringLiteral.class::isInstance).map(StringLiteral.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link VariableLiteral}
     */
    default boolean isVariableLiteral() {
        return this instanceof VariableLiteral;
    }

    /**
     * @return a {@link VariableLiteral} if castable.
     */
    default Optional<VariableLiteral> asVariableLiteral() {
        return Optional.of(this).filter(VariableLiteral.class::isInstance).map(VariableLiteral.class::cast);
    }

}
