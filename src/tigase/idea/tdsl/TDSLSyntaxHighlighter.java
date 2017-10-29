/*
 * TDSLSyntaxHighlighter.java
 *
 * Tigase DSL Syntax Highlighter for IDEA
 * Copyright (C) 2017 "Tigase, Inc." <office@tigase.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 *
 */
package tigase.idea.tdsl;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import tigase.idea.tdsl.psi.TDSLTypes;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.LINE_COMMENT;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.OPERATION_SIGN;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TDSLSyntaxHighlighter
		extends SyntaxHighlighterBase {

	public static final TextAttributesKey SEPARATOR = createTextAttributesKey("TDSL_SEPARATOR", OPERATION_SIGN);
	public static final TextAttributesKey COMMENT = createTextAttributesKey("TDSL_COMMENT", LINE_COMMENT);

	public static final TextAttributesKey STRING = createTextAttributesKey("TDSL_STRING",
																		   DefaultLanguageHighlighterColors.STRING);
	public static final TextAttributesKey NUMBER = createTextAttributesKey("TDSL_NUMBER",
																		   DefaultLanguageHighlighterColors.NUMBER);
	public static final TextAttributesKey BOOLEAN = createTextAttributesKey("TDSL_BOOLEAN",
																			DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey BEAN_NAME = createTextAttributesKey("TDSL_BEAN_NAME",
																			  DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey BEAN_CFG_PROP_NAME = createTextAttributesKey("TDSL_BEAN_CFG_PROP_NAME",
																					   DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey OPERATOR = createTextAttributesKey("TDSL_OPERATOR",
																			 DefaultLanguageHighlighterColors.OPERATION_SIGN);
	public static final TextAttributesKey BRACES = createTextAttributesKey("TDSL_BRACES",
																		   DefaultLanguageHighlighterColors.BRACES);
	public static final TextAttributesKey PARENTHESIS = createTextAttributesKey("TDSL_PARENTHESIS",
																				DefaultLanguageHighlighterColors.PARENTHESES);
	public static final TextAttributesKey BRACKETS = createTextAttributesKey("TDSL_BRACKETS",
																			 DefaultLanguageHighlighterColors.BRACKETS);
	public static final TextAttributesKey ENVPROPFNNAME = createTextAttributesKey("TDSL_ENVPROPFNNAME",
																				  DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey PROPERTY_NAME = createTextAttributesKey("TDSL_PROPERTY_NAME",
																				  DefaultLanguageHighlighterColors.IDENTIFIER);

	public static final TextAttributesKey[] SEPARATOR_KEYS = {SEPARATOR};
	public static final TextAttributesKey[] COMMENT_KEYS = {COMMENT};
	public static final TextAttributesKey[] EMPTY_KEYS = {};

	public static final TextAttributesKey[] STRING_KEYS = {STRING};
	public static final TextAttributesKey[] NUMBER_KEYS = {NUMBER};
	public static final TextAttributesKey[] BOOLEAN_KEYS = {BOOLEAN};
	public static final TextAttributesKey[] BEAN_NAME_KEYS = {BEAN_NAME};
	public static final TextAttributesKey[] BEAN_CFG_PROP_NAME_KEYS = {BEAN_CFG_PROP_NAME};
	public static final TextAttributesKey[] OPERATOR_KEYS = {OPERATOR};
	public static final TextAttributesKey[] BRACES_KEYS = {BRACES};
	public static final TextAttributesKey[] PARENTHESIS_KEYS = {PARENTHESIS};
	public static final TextAttributesKey[] BRACKETS_KEYS = {BRACKETS};
	public static final TextAttributesKey[] ENVPROPFNNAME_KEYS = {ENVPROPFNNAME};
	public static final TextAttributesKey[] PROPERTY_NAME_KEYS = {PROPERTY_NAME};

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new TDSLLexerAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		if (tokenType.equals(TDSLTypes.ASSIGNMENT)) {
			return SEPARATOR_KEYS;
		} else if (tokenType.equals(TDSLTypes.COMMENT)) {
			return COMMENT_KEYS;
		} else if (tokenType.equals(TDSLTypes.NUMBER)) {
			return NUMBER_KEYS;
		} else if (tokenType.equals(TDSLTypes.STRING)) {
			return STRING_KEYS;
		} else if (tokenType.equals(TDSLTypes.BOOLEAN)) {
			return BOOLEAN_KEYS;
		} else if (tokenType.equals(TDSLTypes.BEAN)) {
			return BEAN_NAME_KEYS;
		} else if (tokenType.equals(TDSLTypes.BEANNAME)) {
			return BEAN_NAME_KEYS;
		} else if (tokenType.equals(TDSLTypes.BEANCFGPROPNAME)) {
			return BEAN_CFG_PROP_NAME_KEYS;
		} else if (tokenType.equals(TDSLTypes.OPERATORADD) || tokenType.equals(TDSLTypes.OPERATORSUBSTRACT) ||
				tokenType.equals(TDSLTypes.OPERATORMULTIPLY) || tokenType.equals(TDSLTypes.OPERATORDIVIDE)) {
			return OPERATOR_KEYS;
		} else if (tokenType.equals(TDSLTypes.LCURLY) || tokenType.equals(TDSLTypes.RCURLY)) {
			return BRACES_KEYS;
		} else if (tokenType.equals(TDSLTypes.LPAREN) || tokenType.equals(TDSLTypes.RPAREN)) {
			return PARENTHESIS_KEYS;
		} else if (tokenType.equals(TDSLTypes.LBRACK) || tokenType.equals(TDSLTypes.RBRACK)) {
			return BRACKETS_KEYS;
		} else if (tokenType.equals(TDSLTypes.ENVPROPFNNAME)) {
			return ENVPROPFNNAME_KEYS;
		} else if (tokenType.equals(TDSLTypes.PROPNAME)) {
			return PROPERTY_NAME_KEYS;
		}

		return EMPTY_KEYS;
	}
}
