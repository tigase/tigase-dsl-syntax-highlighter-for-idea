/*
 * TDSLLanguageCodeStyleSettingsProvider.java
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

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;

public class TDSLLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

	@NotNull
	@Override
	public Language getLanguage() {
		return TDSLLanguage.INSTANCE;
	}

	@Override
	public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
		if (settingsType == SettingsType.SPACING_SETTINGS) {
			consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS");
			consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Assignment operator");

			consumer.showStandardOptions("SPACE_AFTER_COMMA");
			consumer.showStandardOptions("SPACE_AFTER_COMMA", "After comma");

			consumer.showStandardOptions("SPACE_AROUND_ADDITIVE_OPERATORS");
			consumer.showStandardOptions("SPACE_AFTER_COLON");

			consumer.showStandardOptions("SPACE_BEFORE_METHOD_CALL_PARENTHESES");
			consumer.renameStandardOption("SPACE_BEFORE_METHOD_CALL_PARENTHESES", "Before bean definition");
		} else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
			consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
		}
	}

	@Override
	public String getCodeSample(@NotNull SettingsType settingsType) {
		return "# comment here\n" + "\n" + "test = 'zz'\n" + "test = 22\n" + "\n" + "xyz = true\n" + "xyz = 22L\n" +
				"xyz = 22 + 33\n" + "wyz = \"test\" + \"kot\"\n" + "\n" + "lista1 = [ 22, 33 ]\n" +
				"lista2 = [ \"Test\", \"ala\", \"kot\" ]\n" + "\n" + "lista3 = [ \"test\" + \"kot\", 11, 22 + 33 ]\n" +
				"\n" + "zmienna1 = env('test1', \"22\")\n" + "zmienna2 = prop(\"test2\", \"test\")\n" + "\n" +
				"wyz = \"test\" + env(\"test1\")\n" + "wyz = env(\"test1\") + prop(\"test2\")\n" +
				"wyz = env(\"test1\") + \"test\"\n" + "\n" + "test {\n" + "}\n" + "\n" +
				"test0(active: true, class: test) {\n" + "}\n" + "\n" + "test01() {\n" + "}\n" + "\n" +
				"test1(class:tigase.server.XMPPServer, exportable: true) {\n" + "    testing = 22\n" +
				"    x = 'tst'\n" + "}\n" + "\n" + "test2 (class: tigase.server.XMPPServer, active: true) {\n" + "}\n" +
				"\n" + "#comment\n" + "test1 () {\n" + "    wpis = 'ss'\n" + "}\n";
	}
	
}
