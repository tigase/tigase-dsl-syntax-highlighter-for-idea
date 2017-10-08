/*
 * TDSLLexerBase.java
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

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import java.util.Stack;

import static tigase.idea.tdsl.TDSLParserDefinition.LEFT_BRACES;
import static tigase.idea.tdsl.psi.TDSLTypes.*;

public abstract class TDSLLexerBase implements FlexLexer {

	public final Stack<Integer> stateStack = new Stack<>();
	private final Stack<IElementType> bracesStack = new Stack<>();
	
	protected void yybeginstate(int... states) {
		for (int state : states) {
			stateStack.push(state);
			yybegin(state);
		}
	}

	protected void yyendstate(int... states) {
		int previous = stateStack.isEmpty() ? getInitialState() : stateStack.pop();
	}

	protected IElementType storeToken(IElementType tokenType) {
		if (LEFT_BRACES.contains(tokenType)) {
			bracesStack.push(tokenType);
		}
		else if (tokenType == RCURLY) {
			IElementType leftType = LCURLY;
			while (!bracesStack.isEmpty() && leftType != bracesStack.peek()) {
				bracesStack.pop();
			}
			if (!bracesStack.isEmpty() && leftType == bracesStack.peek()) {
				bracesStack.pop();
			}
		}
		else if (tokenType == RPAREN || tokenType == RBRACK) {
			if (!bracesStack.isEmpty() && bracesStack.peek() != LCURLY) {
				bracesStack.pop();
			}
		}
//		else if (tokenType == mRPAREN || tokenType == mRBRACK) {
//			if (!bracesStack.isEmpty() && bracesStack.peek() != mLCURLY) {
//				bracesStack.pop();
//			}
//		}
//		if (indexOf(getDivisionStates(), yystate()) != -1 && DIVISION_IS_EXPECTED_AFTER.contains(tokenType)) {
//			yybeginstate(getDivisionExpectedState());
//		}
		return tokenType;
	}

	protected boolean isWithinBraces() {
		return !bracesStack.empty() && bracesStack.peek() != LCURLY;
	}


	protected abstract int getInitialState();
	
}
