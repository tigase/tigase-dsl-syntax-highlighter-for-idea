/*
 * TDSLCodeStyleSettingsProvider.java
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

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TDSLCodeStyleSettingsProvider
		extends CodeStyleSettingsProvider {

	@Nullable
	@Override
	public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
		return new TDSLCodeStyleSettings(settings);
	}

	@Nullable
	@Override
	public String getConfigurableDisplayName() {
		return "TDSL";
	}

	@NotNull
	@Override
	public Configurable createSettingsPage(CodeStyleSettings settings, CodeStyleSettings originalSettings) {
		return new CodeStyleAbstractConfigurable(settings, originalSettings, "TDSL") {
			@Nullable
			@Override
			public String getHelpTopic() {
				return null;
			}

			@Override
			protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
				return new TDSLCodeStyleMainPanel(getCurrentSettings(), settings);
			}
		};
	}

	private static class TDSLCodeStyleMainPanel
			extends TabbedLanguageCodeStylePanel {

		protected TDSLCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
			super(TDSLLanguage.INSTANCE, currentSettings, settings);
		}
	}
}
