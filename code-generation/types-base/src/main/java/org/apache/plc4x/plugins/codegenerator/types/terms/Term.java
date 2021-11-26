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

public interface Term extends TermConversions {

    boolean contains(String str);

    /**
     * Returns a string represenatation of the {@link Term}.
     * In contrast to {@code Object.toString()} this is meant to be used in code rather than debug output.
     *
     * @return a string represenatation of the {@link Term}.
     */
    String stringRepresentation();

    /**
     * Check if the expression doesn't reference any variables.
     * If this is the case, the expression can be evaluated at code-generation time.
     *
     * @return true if it doesn't reference any variable literals.
     */
    default boolean isFixedValueExpression() {
        if (asLiteral().map(LiteralConversions::isVariableLiteral).orElse(false)) {
            return false;
        }
        if (isUnaryTerm()) {
            UnaryTerm unaryTerm = (UnaryTerm) this;
            return unaryTerm.getA().isFixedValueExpression();
        }
        if (isBinaryTerm()) {
            BinaryTerm binaryTerm = (BinaryTerm) this;
            return binaryTerm.getA().isFixedValueExpression() && binaryTerm.getB().isFixedValueExpression();
        }
        if (isTernaryTerm()) {
            TernaryTerm ternaryTerm = (TernaryTerm) this;
            return ternaryTerm.getA().isFixedValueExpression()
                    && ternaryTerm.getB().isFixedValueExpression()
                    && ternaryTerm.getC().isFixedValueExpression();
        }
        return true;
    }

    /**
     * Converts a given discriminator description into a symbolic name.
     *
     * @return name
     */
    default String getDiscriminatorName() {
        if (isLiteral()) {
            Literal literal = (Literal) this;
            if (literal instanceof NullLiteral) {
                return "null";
            } else if (literal instanceof BooleanLiteral) {
                return Boolean.toString(((BooleanLiteral) literal).getValue());
            } else if (literal instanceof NumericLiteral) {
                return ((NumericLiteral) literal).getNumber().toString();
            } else if (literal instanceof HexadecimalLiteral) {
                return ((HexadecimalLiteral) literal).getHexString();
            } else if (literal instanceof StringLiteral) {
                return ((StringLiteral) literal).getValue();
            } else if (literal instanceof VariableLiteral) {
                VariableLiteral variableLiteral = (VariableLiteral) literal;
                return variableLiteral.getVariableLiteralName();
            }
        } else if (isUnaryTerm()) {
            UnaryTerm unaryTerm = (UnaryTerm) this;
            return unaryTerm.getA().getDiscriminatorName();
        } else if (isBinaryTerm()) {
            BinaryTerm binaryTerm = (BinaryTerm) this;
            return binaryTerm.getA().getDiscriminatorName() + "_" + binaryTerm.getB().getDiscriminatorName();
        } else if (isTernaryTerm()) {
            TernaryTerm ternaryTerm = (TernaryTerm) this;
            return ternaryTerm.getA().getDiscriminatorName() + "_" + ternaryTerm.getB().getDiscriminatorName()
                    + "_" + ternaryTerm.getC().getDiscriminatorName();
        }
        return "";
    }

}
