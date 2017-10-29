/*
 * TDSLFormattingModelBuilder.java
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

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tigase.idea.tdsl.psi.TDSLTypes;

public class TDSLFormattingModelBuilder
		implements FormattingModelBuilder {

	private static final TokenSet OPERATORS = TokenSet.create(TDSLTypes.OPERATORADD, TDSLTypes.OPERATORDIVIDE,
															  TDSLTypes.OPERATORMULTIPLY, TDSLTypes.OPERATORSUBSTRACT);

	private static SpacingBuilder createSpaceBuilder(CodeStyleSettings globalSettings) {
		CommonCodeStyleSettings settings = globalSettings.getCommonSettings(TDSLLanguage.INSTANCE);
		return new SpacingBuilder(globalSettings, TDSLLanguage.INSTANCE).around(TDSLTypes.ASSIGNMENT)
				.spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
				.before(TDSLTypes.PROP)
				.none()
				// spacing around bean cfg
				.around(TDSLTypes.BEAN_CFG)
				.spaceIf(settings.SPACE_BEFORE_METHOD_CALL_PARENTHESES)
				.before(TDSLTypes.BEANCFGPROPNAME)
				.none()
				// space around operators
				.around(OPERATORS)
				.spaceIf(settings.SPACE_AROUND_ADDITIVE_OPERATORS)
				.after(TDSLTypes.COMMA)
				.spaceIf(settings.SPACE_AFTER_COMMA)
				.after(TDSLTypes.COLON)
				.spaceIf(settings.SPACE_AFTER_COLON);
	}

	@NotNull
	@Override
	public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
		return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
																	   new TDSLBlock(element.getNode(),
																					 Wrap.createWrap(WrapType.NONE,
																									 false),
																					 Alignment.createAlignment(),
																					 createSpaceBuilder(settings)),
																	   settings);
	}

	@Nullable
	@Override
	public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
		return null;
	}
}
