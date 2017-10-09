// This is a generated file. Not intended for manual editing.
package tigase.idea.tdsl.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static tigase.idea.tdsl.psi.TDSLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TDSLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == BEAN) {
      r = bean(b, 0);
    }
    else if (t == BEAN_CFG) {
      r = beanCfg(b, 0);
    }
    else if (t == BEAN_CFG_PROP_PAIR) {
      r = beanCfgPropPair(b, 0);
    }
    else if (t == ENV_FUNCTION) {
      r = envFunction(b, 0);
    }
    else if (t == PROP) {
      r = prop(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // beanName [ beanCfg] LCURLY [ (prop|bean|COMMENT)* ] RCURLY
  public static boolean bean(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bean")) return false;
    if (!nextTokenIs(b, BEANNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEANNAME);
    r = r && bean_1(b, l + 1);
    r = r && consumeToken(b, LCURLY);
    r = r && bean_3(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, BEAN, r);
    return r;
  }

  // [ beanCfg]
  private static boolean bean_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bean_1")) return false;
    beanCfg(b, l + 1);
    return true;
  }

  // [ (prop|bean|COMMENT)* ]
  private static boolean bean_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bean_3")) return false;
    bean_3_0(b, l + 1);
    return true;
  }

  // (prop|bean|COMMENT)*
  private static boolean bean_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bean_3_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!bean_3_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bean_3_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // prop|bean|COMMENT
  private static boolean bean_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bean_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prop(b, l + 1);
    if (!r) r = bean(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [ beanCfgPropPair (comma beanCfgPropPair)* ] RPAREN
  public static boolean beanCfg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfg")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && beanCfg_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, BEAN_CFG, r);
    return r;
  }

  // [ beanCfgPropPair (comma beanCfgPropPair)* ]
  private static boolean beanCfg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfg_1")) return false;
    beanCfg_1_0(b, l + 1);
    return true;
  }

  // beanCfgPropPair (comma beanCfgPropPair)*
  private static boolean beanCfg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = beanCfgPropPair(b, l + 1);
    r = r && beanCfg_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma beanCfgPropPair)*
  private static boolean beanCfg_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfg_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!beanCfg_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "beanCfg_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comma beanCfgPropPair
  private static boolean beanCfg_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfg_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && beanCfgPropPair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // beanCfgPropName colon (boolean|beanCfgPropValue)
  public static boolean beanCfgPropPair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfgPropPair")) return false;
    if (!nextTokenIs(b, BEANCFGPROPNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BEANCFGPROPNAME, COLON);
    r = r && beanCfgPropPair_2(b, l + 1);
    exit_section_(b, m, BEAN_CFG_PROP_PAIR, r);
    return r;
  }

  // boolean|beanCfgPropValue
  private static boolean beanCfgPropPair_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beanCfgPropPair_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, BEANCFGPROPVALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // envPropFnName LPAREN string ("," string)? RPAREN
  public static boolean envFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "envFunction")) return false;
    if (!nextTokenIs(b, ENVPROPFNNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENVPROPFNNAME, LPAREN, STRING);
    r = r && envFunction_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ENV_FUNCTION, r);
    return r;
  }

  // ("," string)?
  private static boolean envFunction_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "envFunction_3")) return false;
    envFunction_3_0(b, l + 1);
    return true;
  }

  // "," string
  private static boolean envFunction_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "envFunction_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // propName ASSIGNMENT value
  public static boolean prop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prop")) return false;
    if (!nextTokenIs(b, PROPNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPNAME, ASSIGNMENT);
    r = r && value(b, l + 1);
    exit_section_(b, m, PROP, r);
    return r;
  }

  /* ********************************************************** */
  // (prop|bean|COMMENT)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    int c = current_position_(b);
    while (true) {
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // prop|bean|COMMENT
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prop(b, l + 1);
    if (!r) r = bean(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (number (operatorAdd|operatorSubstract|operatorMultiply|operatorDivide) number) | ((string|envFunction) operatorAdd (string|envFunction)) | (LBRACK value (comma value)* RBRACK) | envFunction | string | number | boolean
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = value_0(b, l + 1);
    if (!r) r = value_1(b, l + 1);
    if (!r) r = value_2(b, l + 1);
    if (!r) r = envFunction(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // number (operatorAdd|operatorSubstract|operatorMultiply|operatorDivide) number
  private static boolean value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && value_0_1(b, l + 1);
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  // operatorAdd|operatorSubstract|operatorMultiply|operatorDivide
  private static boolean value_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATORADD);
    if (!r) r = consumeToken(b, OPERATORSUBSTRACT);
    if (!r) r = consumeToken(b, OPERATORMULTIPLY);
    if (!r) r = consumeToken(b, OPERATORDIVIDE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (string|envFunction) operatorAdd (string|envFunction)
  private static boolean value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_1_0(b, l + 1);
    r = r && consumeToken(b, OPERATORADD);
    r = r && value_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string|envFunction
  private static boolean value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    if (!r) r = envFunction(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string|envFunction
  private static boolean value_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    if (!r) r = envFunction(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACK value (comma value)* RBRACK
  private static boolean value_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && value(b, l + 1);
    r = r && value_2_2(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma value)*
  private static boolean value_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_2_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!value_2_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "value_2_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comma value
  private static boolean value_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
