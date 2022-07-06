package org.apache.plc4x.plugins.codegenerator.types.terms;

/**
 * WildcardTerm is a marker interface for wildcards
 */
public interface WildcardTerm {
    WildcardTerm INSTANCE = new WildcardTerm() {
        public String toString() {
            return "WildcardTerm{}";
        }
    };

    default boolean contains(String s) {
        throw new IllegalStateException("Should never be called");
    }

    default String stringRepresentation() {
        throw new IllegalStateException("Should never be called");
    }

}
