/*
 * TDSLFileType.java
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

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TDSLFileType
		extends LanguageFileType {

	public static final TDSLFileType INSTANCE = new TDSLFileType();

	private TDSLFileType() {
		super(TDSLLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName() {
		return "TDSL file";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "Tigase DSL file";
	}

	@NotNull
	@Override
	public String getDefaultExtension() {
		return "tdsl";
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return TDSLIcons.FILE;
	}
}
