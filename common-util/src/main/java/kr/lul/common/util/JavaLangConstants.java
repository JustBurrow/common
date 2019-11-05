package kr.lul.common.util;

/**
 * Java 언어 수준의 상수.
 *
 * @author justburrow
 * @since 2018. 9. 20.
 */
public abstract class JavaLangConstants {
  /**
   * @see Boolean#TYPE
   */
  public static final String BOOLEAN_TYPE_NAME = "boolean";
  /**
   * @see Byte#TYPE
   */
  public static final String BYTE_TYPE_NAME = "byte";
  /**
   * @see Short#TYPE
   */
  public static final String SHORT_TYPE_NAME = "short";
  /**
   * @see Integer#TYPE
   */
  public static final String INTEGER_TYPE_NAME = "int";
  /**
   * @see Long#TYPE
   */
  public static final String LONG_TYPE_NAME = "long";
  /**
   * @see Float#TYPE
   */
  public static final String FLOAT_TYPE_NAME = "float";
  /**
   * @see Double#TYPE
   */
  public static final String DOUBLE_TYPE_NAME = "double";
  /**
   * @see Character#TYPE
   */
  public static final String CHARACTER_TYPE_NAME = "char";

  /**
   * @see Boolean#TYPE
   */
  public static final String BOOLEAN_TYPE_ARRAY_CLASS_NAME = "[Z";
  /**
   * @see Byte#TYPE
   */
  public static final String BYTE_TYPE_ARRAY_CLASS_NAME = "[B";
  /**
   * @see Short#TYPE
   */
  public static final String SHORT_TYPE_ARRAY_CLASS_NAME = "[S";
  /**
   * @see Integer#TYPE
   */
  public static final String INTEGER_TYPE_ARRAY_CLASS_NAME = "[I";
  /**
   * @see Long#TYPE
   */
  public static final String LONG_TYPE_ARRAY_CLASS_NAME = "[J";
  /**
   * @see Float#TYPE
   */
  public static final String FLOAT_TYPE_ARRAY_CLASS_NAME = "[F";
  /**
   * @see Double#TYPE
   */
  public static final String DOUBLE_TYPE_ARRAY_CLASS_NAME = "[D";
  /**
   * @see Character#TYPE
   */
  public static final String CHARACTER_TYPE_ARRAY_CLASS_NAME = "[C";

  protected JavaLangConstants() {
    throw new UnsupportedOperationException("does not support instance.");
  }
}
