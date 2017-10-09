/*
 * TDSLColorSettingsPage.java
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

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class TDSLColorSettingsPage implements ColorSettingsPage {

	private static final AttributesDescriptor[] DESCRIPTORS = {
			new AttributesDescriptor("Separator", TDSLSyntaxHighlighter.SEPARATOR),
			new AttributesDescriptor("Bean name", TDSLSyntaxHighlighter.BEAN_NAME),
			new AttributesDescriptor("Bean parameter name", TDSLSyntaxHighlighter.BEAN_CFG_PROP_NAME),
			new AttributesDescriptor("Braces", TDSLSyntaxHighlighter.BRACES),
			new AttributesDescriptor("Parenthesis", TDSLSyntaxHighlighter.PARENTHESIS),
			new AttributesDescriptor("Brackets", TDSLSyntaxHighlighter.BRACKETS),
			new AttributesDescriptor("Operators", TDSLSyntaxHighlighter.OPERATOR),
			new AttributesDescriptor("Property name", TDSLSyntaxHighlighter.PROPERTY_NAME),
			new AttributesDescriptor("Environment variable/property read function", TDSLSyntaxHighlighter.ENVPROPFNNAME),
			new AttributesDescriptor("Comment", TDSLSyntaxHighlighter.COMMENT)
	};

	@Nullable
	@Override
	public Icon getIcon() {
		return TDSLIcons.FILE;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new TDSLSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
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

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "TDSL";
	}
}
